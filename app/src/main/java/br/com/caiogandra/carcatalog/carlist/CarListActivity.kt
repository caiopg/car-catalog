package br.com.caiogandra.carcatalog.carlist

import android.app.Activity
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import br.com.caiogandra.carcatalog.R
import br.com.caiogandra.carcatalog.base.BaseActivity
import br.com.caiogandra.carcatalog.carlist.adapter.CarListAdapter
import br.com.caiogandra.carcatalog.carlist.view.CarListView
import br.com.caiogandra.carcatalog.carlist.viewmodel.CarListViewModel
import br.com.caiogandra.carcatalog.databinding.ActivityCarListBinding
import br.com.caiogandra.carcatalog.model.Car
import br.com.caiogandra.carcatalog.newcar.NewCarFlowActivity
import com.pawegio.kandroid.startActivityForResult
import dagger.android.AndroidInjection
import javax.inject.Inject

class CarListActivity: BaseActivity(), CarListView {

    @Inject lateinit var viewModel: CarListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityCarListBinding>(this, R.layout.activity_car_list)

        updateToolbarTitle(R.string.car_list_toolbar_title)

        binding.viewModel = viewModel
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.car_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId) {
            R.id.menu_car_list_add -> {

                startActivityForResult<NewCarFlowActivity>(NewCarFlowActivity.REQUEST_CODE)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == NewCarFlowActivity.REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            viewModel.updateData()
        }

        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun updateCarListAdapter(recyclerView: RecyclerView, cars: List<Car>) {
        var adapter = recyclerView.adapter

        if(adapter != null) {
            with(adapter as CarListAdapter) {
                this.cars = cars
                adapter.notifyDataSetChanged()
            }
        } else {
            adapter = CarListAdapter(application, cars)
            val linearLayoutManager = LinearLayoutManager(this)
            linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

            recyclerView.layoutManager = linearLayoutManager
            recyclerView.adapter = adapter
        }


    }
}
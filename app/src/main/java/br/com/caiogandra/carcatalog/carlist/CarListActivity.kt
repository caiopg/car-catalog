package br.com.caiogandra.carcatalog.carlist

import android.arch.lifecycle.ViewModelProviders
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
import br.com.caiogandra.carcatalog.carlist.viewmodel.factory.CarListViewModelFactory
import br.com.caiogandra.carcatalog.databinding.ActivityCarListBinding
import br.com.caiogandra.carcatalog.model.Car
import com.pawegio.kandroid.longToast

class CarListActivity: BaseActivity(), CarListView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityCarListBinding>(this, R.layout.activity_car_list)
        val viewModel = obtainViewModel()

        binding.viewModel = viewModel
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.car_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId) {
            R.id.menu_car_list_add -> {
                //todo
                longToast("test")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun obtainViewModel(): CarListViewModel {
        val viewModelFactory = CarListViewModelFactory(application, this)
        return ViewModelProviders.of(this, viewModelFactory).get(CarListViewModel::class.java)
    }

    override fun updateCarListAdapter(recyclerView: RecyclerView, cars: List<Car>) {
        val carListAdapter = CarListAdapter(application, cars)

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL

        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = carListAdapter
    }
}
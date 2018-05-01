package br.com.caiogandra.carcatalog.carlist

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import br.com.caiogandra.carcatalog.R
import br.com.caiogandra.carcatalog.base.BaseActivity
import br.com.caiogandra.carcatalog.carlist.view.CarListView
import br.com.caiogandra.carcatalog.databinding.ActivityCarListBinding
import br.com.caiogandra.carcatalog.model.Car
import com.pawegio.kandroid.longToast

class CarListActivity: BaseActivity(), CarListView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityCarListBinding>(this, R.layout.activity_car_list)
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

    override fun updateCarListAdapter(recyclerView: RecyclerView, car: List<Car>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
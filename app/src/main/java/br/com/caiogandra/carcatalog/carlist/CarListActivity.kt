package br.com.caiogandra.carcatalog.carlist

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import br.com.caiogandra.carcatalog.R
import br.com.caiogandra.carcatalog.base.BaseActivity
import br.com.caiogandra.carcatalog.databinding.ActivityCarListBinding
import com.pawegio.kandroid.longToast

class CarListActivity : BaseActivity() {

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
}
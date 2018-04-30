package br.com.caiogandra.carcatalog.carlist

import android.os.Bundle
import br.com.caiogandra.carcatalog.R
import br.com.caiogandra.carcatalog.base.BaseActivity

class CarListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_list)
    }
}

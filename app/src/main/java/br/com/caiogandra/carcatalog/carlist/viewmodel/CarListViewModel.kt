package br.com.caiogandra.carcatalog.carlist.viewmodel

import android.app.Application
import br.com.caiogandra.carcatalog.base.BaseView
import br.com.caiogandra.carcatalog.base.BaseViewModel
import br.com.caiogandra.carcatalog.db.DbHelper

class CarListViewModel(application: Application) : BaseViewModel<BaseView?>(application) {

    fun setupViewModel() {
        val cars = DbHelper.fetchAllCars()
    }

}
package br.com.caiogandra.carcatalog.carlist.viewmodel

import android.app.Application
import android.databinding.Bindable
import android.view.View
import br.com.caiogandra.carcatalog.base.BaseViewModel
import br.com.caiogandra.carcatalog.carlist.view.CarListView
import br.com.caiogandra.carcatalog.db.DbHelper

class CarListViewModel(application: Application, carListView: CarListView) : BaseViewModel<CarListView>(application) {

    @Bindable
    val cars = DbHelper.fetchAllCars()

    @Bindable
    override var view: CarListView? = carListView

    @Bindable
    fun getListVisibility() : Int {
        return if (cars.isNotEmpty()) View.VISIBLE else View.GONE
    }

    @Bindable
    fun getEmptyWarningVisibility() : Int {
        return if (cars.isNotEmpty()) View.GONE else View.VISIBLE
    }
}
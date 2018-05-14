package br.com.caiogandra.carcatalog.carlist.viewmodel

import android.databinding.Bindable
import android.view.View
import br.com.caiogandra.carcatalog.BR
import br.com.caiogandra.carcatalog.base.BaseViewModel
import br.com.caiogandra.carcatalog.carlist.view.CarListView
import br.com.caiogandra.carcatalog.datasource.car.CarRepository

class CarListViewModel(carListView: CarListView) : BaseViewModel<CarListView>() {

    @Bindable
    var cars = CarRepository.fetchAllCars()

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

    fun updateData() {
        cars = CarRepository.fetchAllCars()
        registry.notifyChange(this, BR._all)
    }
}
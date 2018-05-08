package br.com.caiogandra.carcatalog.carlist.viewmodel

import android.databinding.Bindable
import br.com.caiogandra.carcatalog.base.BaseView
import br.com.caiogandra.carcatalog.base.BaseViewModel
import br.com.caiogandra.carcatalog.model.Car

class CarListItemViewModel(car: Car) : BaseViewModel<BaseView?>() {

    @Bindable
    val carYear = car.year.toString()

    @Bindable
    val carBrand = car.brand.toString()

    @Bindable
    val carModel = car.model.toString()

    @Bindable
    val carValue = "R$ " + car.value
}
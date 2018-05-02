package br.com.caiogandra.carcatalog.carlist.viewmodel

import android.app.Application
import android.databinding.Bindable
import br.com.caiogandra.carcatalog.base.BaseView
import br.com.caiogandra.carcatalog.base.BaseViewModel
import br.com.caiogandra.carcatalog.model.Car

class CarListItemViewModel(application: Application, car: Car) : BaseViewModel<BaseView?>(application) {

    @Bindable
    val carYear = car.year

    @Bindable
    val carBrand = car.brand

    @Bindable
    val carModel = car.model

    @Bindable
    val carValue = car.value
}
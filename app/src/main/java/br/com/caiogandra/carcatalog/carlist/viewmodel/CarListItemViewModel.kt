package br.com.caiogandra.carcatalog.carlist.viewmodel

import android.databinding.Bindable
import br.com.caiogandra.carcatalog.base.BaseView
import br.com.caiogandra.carcatalog.base.BaseViewModel
import br.com.caiogandra.carcatalog.model.Car
import java.text.NumberFormat
import java.util.*

class CarListItemViewModel(car: Car) : BaseViewModel<BaseView?>() {

    private val valueReal = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))

    @Bindable
    val fipeCode = car.fipeCode

    @Bindable
    val carYear = car.year

    @Bindable
    val carBrand = car.brand

    @Bindable
    val carModel = car.model

    @Bindable
    val carValue = valueReal.format(car.value)
}
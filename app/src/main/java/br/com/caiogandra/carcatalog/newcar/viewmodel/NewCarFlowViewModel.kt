package br.com.caiogandra.carcatalog.newcar.viewmodel

import br.com.caiogandra.carcatalog.base.BaseView
import br.com.caiogandra.carcatalog.base.BaseViewModel
import br.com.caiogandra.carcatalog.datasource.car.CarRepository
import br.com.caiogandra.carcatalog.model.Car


class NewCarFlowViewModel(private val carRepository: CarRepository): BaseViewModel<BaseView?>() {

    var car: Car = Car(id = carRepository.fetchTotalCars())

    fun updateBrand(brand: String) {
        car.brand = brand
    }

    fun updateCar(model: String, year: String, value: Int, fipeCode: String) {
        car.model = model
        car.year = year
        car.value = value
        car.fipeCode = fipeCode
    }

    fun getBrand(): String {
        return car.brand
    }

    fun persistCar() {
        carRepository.persistCar(car)
    }

}
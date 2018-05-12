package br.com.caiogandra.carcatalog.newcar.controller

interface CarController {

    fun updateBrand(brand: String)

    fun updateModel(model: String)

    fun updateYear(year: String)

    fun updateValue(value: Int)

    fun updateFipeCode(fipeCode: String)

    fun getBrand(): String

    fun persistCar()

}
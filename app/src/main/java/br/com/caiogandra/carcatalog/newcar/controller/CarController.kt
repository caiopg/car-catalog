package br.com.caiogandra.carcatalog.newcar.controller

interface CarController {

    fun updateCar(model: String, year: String, value: Int, fipeCode: String)

    fun updateBrand(brand: String)

    fun getBrand(): String

    fun persistCar()

}
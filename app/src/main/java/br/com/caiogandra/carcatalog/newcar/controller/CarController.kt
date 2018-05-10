package br.com.caiogandra.carcatalog.newcar.controller

interface CarController {

    fun updateBrand(brand: String)

    fun updateModel(model: String)

    fun updateYear(year: Int)

    fun updateValue(value: Int)

}
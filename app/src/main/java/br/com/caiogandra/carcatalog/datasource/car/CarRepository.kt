package br.com.caiogandra.carcatalog.datasource.car

import br.com.caiogandra.carcatalog.model.Car

interface CarRepository {

    fun fetchAllCars(): List<Car>

    fun fetchTotalCars(): Int

    fun persistCar(car: Car)
}
package br.com.caiogandra.carcatalog.datasource.car

import br.com.caiogandra.carcatalog.model.Car
import com.vicpin.krealmextensions.queryAll
import com.vicpin.krealmextensions.save

object CarRepository {

    fun fetchAllCars(): List<Car> {
        return Car().queryAll()
    }

    fun fetchTotalCars(): Int {
        return fetchAllCars().size
    }

    fun persistCar(car: Car) {
        car.save()
    }

}
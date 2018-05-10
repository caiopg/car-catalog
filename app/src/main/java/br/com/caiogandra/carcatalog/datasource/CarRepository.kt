package br.com.caiogandra.carcatalog.datasource

import br.com.caiogandra.carcatalog.model.Car
import com.vicpin.krealmextensions.queryAll

object CarRepository {

    fun fetchAllCars(): List<Car> {
        return Car().queryAll()
    }

    fun fetchTotalCars(): Int {
        return fetchAllCars().size
    }

}
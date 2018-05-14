package br.com.caiogandra.carcatalog.datasource.car

import br.com.caiogandra.carcatalog.model.Car
import com.vicpin.krealmextensions.queryAll
import com.vicpin.krealmextensions.save
import javax.inject.Inject

class CarRepositoryImpl @Inject constructor(): CarRepository {

    override fun fetchAllCars(): List<Car> {
        return Car().queryAll()
    }

    override fun fetchTotalCars(): Int {
        return fetchAllCars().size
    }

    override fun persistCar(car: Car) {
        car.save()
    }

}
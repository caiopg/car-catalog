package br.com.caiogandra.carcatalog.db

import br.com.caiogandra.carcatalog.model.Car
import com.vicpin.krealmextensions.queryAll

object DbHelper {

    fun fetchAllCars() : List<Car>{
        return Car().queryAll()
    }

}
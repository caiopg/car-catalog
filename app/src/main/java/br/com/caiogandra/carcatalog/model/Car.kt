package br.com.caiogandra.carcatalog.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Car (
        @PrimaryKey open var id : Int = 0,
        open var fipeCode : String = "",
        open var brand : String = "",
        open var model : String = "",
        open var year : String = "",
        open var value : Int = 0
    ): RealmObject()
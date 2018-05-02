package br.com.caiogandra.carcatalog.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Car (
        @PrimaryKey open var id : Int = 0,
        open var brand : String = "",
        open var model : String = "",
        open var year : Int = 0,
        open var value : Int = 0
    ): RealmObject()
package br.com.caiogandra.carcatalog.network.data

data class DataWrapper<T> (
    var apiThrowable: Throwable? = null,
    var data: T? = null
)
package br.com.caiogandra.carcatalog.network.listener

interface NetworkListener<T> {
    fun onSuccess(dataWrapper: T?)
    fun onException(throwable: Throwable?)
}

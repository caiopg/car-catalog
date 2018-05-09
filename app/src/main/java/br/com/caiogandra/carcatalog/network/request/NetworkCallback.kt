package br.com.caiogandra.carcatalog.network.request

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class NetworkCallback<T>: Callback<T> {

    abstract fun handleResponseData(data: T?)

    abstract fun handleError(response: Response<T>?)

    abstract fun handleThrowable(throwable: Throwable?)

    override fun onResponse(call: Call<T>?, response: Response<T>?) {
        if (response?.body() != null) {
            handleResponseData(response.body())
        } else {
            handleError(response)
        }
    }

    override fun onFailure(call: Call<T>?, t: Throwable?) {
        handleThrowable(t)
    }
}
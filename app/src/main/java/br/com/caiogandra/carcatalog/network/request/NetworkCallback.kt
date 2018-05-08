package br.com.caiogandra.carcatalog.network.request

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class NetworkCallback<T>: Callback<Response<T>> {

    abstract fun handleResponseData(data: T?)

    abstract fun handleError(response: Response<Response<T>>?)

    abstract fun handleThrowable(throwable: Throwable?)

    override fun onResponse(call: Call<Response<T>>?, response: Response<Response<T>>?) {

        if (response?.body()?.body() != null) {
            handleResponseData(response.body()!!.body())
        } else {
            handleError(response)
        }
    }

    override fun onFailure(call: Call<Response<T>>?, t: Throwable?) {
        handleThrowable(t)
    }
}
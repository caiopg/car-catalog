package br.com.caiogandra.carcatalog.network.request

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import br.com.caiogandra.carcatalog.network.data.DataWrapper
import br.com.caiogandra.carcatalog.network.exception.NetworkException
import com.pawegio.kandroid.v
import retrofit2.Call
import retrofit2.Response

class NetworkRequestHandler {
    companion object {
        fun <R> doRequest(call: Call<R>): LiveData<DataWrapper<R>> {
            val liveData = MutableLiveData<DataWrapper<R>>()
            val dataWrapper = DataWrapper<R>()

            call.enqueue(object : NetworkCallback<R>() {
                override fun handleResponseData(data: R?) {
                    dataWrapper.data = data
                    liveData.value = dataWrapper
                }

                override fun handleError(response: Response<R>?) {
                    dataWrapper.apiThrowable = NetworkException()
                    liveData.value = dataWrapper
                }

                override fun handleThrowable(throwable: Throwable?) {
                    dataWrapper.apiThrowable = throwable
                    liveData.value = dataWrapper
                }

            })

            return liveData
        }
    }
}
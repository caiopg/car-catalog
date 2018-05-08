package br.com.caiogandra.carcatalog.network.request

import android.arch.lifecycle.Observer
import br.com.caiogandra.carcatalog.network.data.DataWrapper
import br.com.caiogandra.carcatalog.network.listener.NetworkListener

class NetworkObserver<T>(val changeListener: NetworkListener<T>): Observer<DataWrapper<T>> {

    override fun onChanged(dataWrapper: DataWrapper<T>?) {
        if(dataWrapper != null) {
            if(dataWrapper.data != null) {
                changeListener.onSuccess(dataWrapper.data)
            } else {
                changeListener.onException(dataWrapper.apiThrowable)
            }
        }
    }
}
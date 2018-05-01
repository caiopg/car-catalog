package br.com.caiogandra.carcatalog.base

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.Observable
import android.databinding.PropertyChangeRegistry

open class BaseViewModel<V : BaseView?>(application: Application) : AndroidViewModel(application), Observable {

    private val registry = PropertyChangeRegistry()

    var view: V? = null
        protected set

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
        registry.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
        registry.remove(callback)
    }

    override fun onCleared() {
        super.onCleared()
        view = null
    }
}
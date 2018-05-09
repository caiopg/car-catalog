package br.com.caiogandra.carcatalog.base

import android.arch.lifecycle.ViewModel
import android.databinding.Observable
import android.databinding.PropertyChangeRegistry

open class BaseViewModel<V : BaseView?>: ViewModel(), Observable {

    protected val registry = PropertyChangeRegistry()

    open var view: V? = null
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
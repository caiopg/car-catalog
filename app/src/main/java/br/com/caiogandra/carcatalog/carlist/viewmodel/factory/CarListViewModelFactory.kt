package br.com.caiogandra.carcatalog.carlist.viewmodel.factory

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.caiogandra.carcatalog.carlist.view.CarListView
import br.com.caiogandra.carcatalog.carlist.viewmodel.CarListViewModel
import javax.inject.Inject

class CarListViewModelFactory @Inject constructor(private val carListView: CarListView) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CarListViewModel(carListView) as T
    }
}
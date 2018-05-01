package br.com.caiogandra.carcatalog.carlist.viewmodel.factory

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.caiogandra.carcatalog.carlist.view.CarListView
import br.com.caiogandra.carcatalog.carlist.viewmodel.CarListViewModel

class CarListViewModelFactory(private val application: Application, private val carListViewModel: CarListView) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CarListViewModel(application, carListViewModel) as T
    }
}
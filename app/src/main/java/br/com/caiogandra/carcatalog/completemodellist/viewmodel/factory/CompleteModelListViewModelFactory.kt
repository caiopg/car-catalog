package br.com.caiogandra.carcatalog.completemodellist.viewmodel.factory

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.caiogandra.carcatalog.completemodellist.viewmodel.CompleteModelListViewModel
import br.com.caiogandra.carcatalog.datasource.implementation.FipeRepositoryImpl
import br.com.caiogandra.carcatalog.newcar.controller.CarController
import br.com.caiogandra.carcatalog.newcar.controller.FragmentController
import javax.inject.Inject

class CompleteModelListViewModelFactory @Inject constructor(private val fipeRepositoryImpl: FipeRepositoryImpl,
                                                    private val carController: CarController,
                                                    private val fragmentController: FragmentController) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CompleteModelListViewModel(fipeRepositoryImpl, carController, fragmentController) as T
    }
}
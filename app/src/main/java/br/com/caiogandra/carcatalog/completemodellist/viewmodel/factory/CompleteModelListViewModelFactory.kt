package br.com.caiogandra.carcatalog.completemodellist.viewmodel.factory

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.caiogandra.carcatalog.completemodellist.view.CompleteModelListView
import br.com.caiogandra.carcatalog.completemodellist.viewmodel.CompleteModelListViewModel
import br.com.caiogandra.carcatalog.datasource.fipe.FipeRepository
import br.com.caiogandra.carcatalog.newcar.controller.CarController
import br.com.caiogandra.carcatalog.newcar.controller.FragmentController
import javax.inject.Inject

class CompleteModelListViewModelFactory @Inject constructor(private val fipeRepository: FipeRepository,
                                                            private val carController: CarController,
                                                            private val fragmentController: FragmentController,
                                                            private val completeModeListView: CompleteModelListView) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CompleteModelListViewModel(fipeRepository, carController, fragmentController, completeModeListView) as T
    }
}
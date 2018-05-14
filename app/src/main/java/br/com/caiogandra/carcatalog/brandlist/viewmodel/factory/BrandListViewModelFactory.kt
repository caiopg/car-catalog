package br.com.caiogandra.carcatalog.brandlist.viewmodel.factory

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.caiogandra.carcatalog.brandlist.viewmodel.BrandListViewModel
import br.com.caiogandra.carcatalog.datasource.fipe.FipeRepository
import br.com.caiogandra.carcatalog.newcar.controller.CarController
import br.com.caiogandra.carcatalog.newcar.controller.FragmentController
import javax.inject.Inject

class BrandListViewModelFactory @Inject constructor(private val fipeRepository: FipeRepository,
                                                    private val carController: CarController,
                                                    private val fragmentController: FragmentController) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BrandListViewModel(fipeRepository, carController, fragmentController) as T
    }
}
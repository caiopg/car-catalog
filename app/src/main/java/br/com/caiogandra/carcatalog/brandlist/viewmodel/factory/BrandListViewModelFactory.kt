package br.com.caiogandra.carcatalog.brandlist.viewmodel.factory

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.caiogandra.carcatalog.brandlist.viewmodel.BrandListViewModel
import br.com.caiogandra.carcatalog.datasource.implementation.FipeRepositoryImpl
import javax.inject.Inject

class BrandListViewModelFactory @Inject constructor(private val fipeRepositoryImpl: FipeRepositoryImpl) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BrandListViewModel(fipeRepositoryImpl) as T
    }
}
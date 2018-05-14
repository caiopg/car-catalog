package br.com.caiogandra.carcatalog.carlist.viewmodel.factory

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.caiogandra.carcatalog.datasource.car.CarRepository
import br.com.caiogandra.carcatalog.newcar.viewmodel.NewCarFlowViewModel
import javax.inject.Inject

class NewCarFlowViewModelFactory @Inject constructor(private val carRepository: CarRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewCarFlowViewModel(carRepository) as T
    }
}
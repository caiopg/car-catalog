package br.com.caiogandra.carcatalog.completemodellist.viewmodel

import android.arch.lifecycle.LiveData
import android.view.View
import android.widget.RadioGroup
import br.com.caiogandra.carcatalog.BR
import br.com.caiogandra.carcatalog.base.BaseView
import br.com.caiogandra.carcatalog.base.BaseViewModel
import br.com.caiogandra.carcatalog.completemodellist.CompleteModelListFragment
import br.com.caiogandra.carcatalog.datasource.implementation.FipeRepositoryImpl
import br.com.caiogandra.carcatalog.model.response.CompleteModel
import br.com.caiogandra.carcatalog.network.data.DataWrapper
import br.com.caiogandra.carcatalog.newcar.controller.CarController
import br.com.caiogandra.carcatalog.newcar.controller.FragmentController

class CompleteModelListViewModel(private val fipeRepositoryImpl: FipeRepositoryImpl,
                         private val carController: CarController,
                         private val fragmentController: FragmentController) : BaseViewModel<BaseView?>() {

    private var selectedCompleteModel: Int = -1

    var completeModels: List<CompleteModel> = ArrayList()

    fun fetchCompleteModels(): LiveData<DataWrapper<List<CompleteModel>>> {
        return fipeRepositoryImpl.fetchModels(carController.getBrand())
    }

    fun onNextClicked(@Suppress("UNUSED_PARAMETER") view: View) {
        val completeModel = completeModels[selectedCompleteModel]

        carController.updateModel(completeModel.model)
        carController.updateYear(completeModel.year)
        carController.updateFipeCode(completeModel.fipeCode)
        fragmentController.goToNextFragment(CompleteModelListFragment.TAG)
    }

    fun onCompleteModelChanged(@Suppress("UNUSED_PARAMETER") radioGroup: RadioGroup, checkedId: Int) {
        selectedCompleteModel = checkedId
        registry.notifyChange(this, BR._all)
    }

    fun buttonEnabled(): Boolean {
        return selectedCompleteModel > 0
    }

}
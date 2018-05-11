package br.com.caiogandra.carcatalog.completemodellist.viewmodel

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LiveData
import android.view.View
import android.widget.RadioGroup
import br.com.caiogandra.carcatalog.BR
import br.com.caiogandra.carcatalog.base.BaseViewModel
import br.com.caiogandra.carcatalog.completemodellist.view.CompleteModelListView
import br.com.caiogandra.carcatalog.datasource.implementation.FipeRepositoryImpl
import br.com.caiogandra.carcatalog.model.response.CompleteCar
import br.com.caiogandra.carcatalog.model.response.CompleteModel
import br.com.caiogandra.carcatalog.network.data.DataWrapper
import br.com.caiogandra.carcatalog.newcar.controller.CarController
import br.com.caiogandra.carcatalog.newcar.controller.FragmentController

class CompleteModelListViewModel(private val fipeRepositoryImpl: FipeRepositoryImpl,
                                 private val carController: CarController,
                                 private val fragmentController: FragmentController,
                                 override var view: CompleteModelListView) : BaseViewModel<CompleteModelListView>() {

    private var selectedCompleteModel: Int = -1

    var completeModels: List<CompleteModel> = ArrayList()

    fun fetchCompleteModels(): LiveData<DataWrapper<List<CompleteModel>>> {
        return fipeRepositoryImpl.fetchModels(carController.getBrand())
    }

    fun fetchCompleteCar(fipeCode: String, year: String): LiveData<DataWrapper<CompleteCar>> {
        return fipeRepositoryImpl.fetchCompleteCar(fipeCode, year)
    }

    fun onCreateClicked(@Suppress("UNUSED_PARAMETER") view: View) {
        val completeModel = completeModels[selectedCompleteModel]

        carController.updateModel(completeModel.model)
        carController.updateYear(completeModel.year)
        carController.updateFipeCode(completeModel.fipeCode)
        val view = this.view

        view!!.showSummaryDialog(completeModel.fipeCode, completeModel.year)
    }

    fun onCompleteModelChanged(@Suppress("UNUSED_PARAMETER") radioGroup: RadioGroup, checkedId: Int) {
        selectedCompleteModel = checkedId
        registry.notifyChange(this, BR._all)
    }

    fun buttonEnabled(): Boolean {
        return selectedCompleteModel > 0
    }

}
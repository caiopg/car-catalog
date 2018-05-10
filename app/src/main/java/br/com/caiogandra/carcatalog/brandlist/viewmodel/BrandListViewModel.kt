package br.com.caiogandra.carcatalog.brandlist.viewmodel

import android.arch.lifecycle.LiveData
import android.view.View
import android.widget.RadioGroup
import br.com.caiogandra.carcatalog.BR
import br.com.caiogandra.carcatalog.base.BaseView
import br.com.caiogandra.carcatalog.base.BaseViewModel
import br.com.caiogandra.carcatalog.brandlist.BrandListFragment
import br.com.caiogandra.carcatalog.datasource.implementation.FipeRepositoryImpl
import br.com.caiogandra.carcatalog.model.response.Brand
import br.com.caiogandra.carcatalog.network.data.DataWrapper
import br.com.caiogandra.carcatalog.newcar.controller.CarController
import br.com.caiogandra.carcatalog.newcar.controller.FragmentController

class BrandListViewModel(private val fipeRepositoryImpl: FipeRepositoryImpl,
                         private val carController: CarController,
                         private val fragmentController: FragmentController) : BaseViewModel<BaseView?>() {

    private var selectedBrandId: Int = -1

    var brands: List<Brand> = ArrayList()

    fun fetchBrands(): LiveData<DataWrapper<List<Brand>>> {
        return fipeRepositoryImpl.fetchBrands()
    }

    fun onNextClicked(@Suppress("UNUSED_PARAMETER") view: View) {
        carController.updateBrand(brands[selectedBrandId].brand)
        fragmentController.goToNextFragment(BrandListFragment.TAG)
    }

    fun onBrandChanged(@Suppress("UNUSED_PARAMETER") radioGroup: RadioGroup, checkedId: Int) {
        selectedBrandId = checkedId
        registry.notifyChange(this, BR._all)
    }

    fun buttonEnabled(): Boolean {
        return selectedBrandId > 0
    }

}
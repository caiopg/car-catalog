package br.com.caiogandra.carcatalog.brandlist.viewmodel

import android.arch.lifecycle.LiveData
import android.view.View
import android.widget.RadioGroup
import br.com.caiogandra.carcatalog.BR
import br.com.caiogandra.carcatalog.base.BaseView
import br.com.caiogandra.carcatalog.base.BaseViewModel
import br.com.caiogandra.carcatalog.datasource.implementation.FipeRepositoryImpl
import br.com.caiogandra.carcatalog.model.response.Brand
import br.com.caiogandra.carcatalog.network.data.DataWrapper

class BrandListViewModel(private val fipeRepositoryImpl: FipeRepositoryImpl) : BaseViewModel<BaseView?>() {

    private var brands: List<Brand> = ArrayList()
    private var selectedBrandId: Int = -1

    fun fetchBrands(): LiveData<DataWrapper<List<Brand>>> {
        return fipeRepositoryImpl.fetchBrands()
    }

    fun onNextClicked(@Suppress("UNUSED_PARAMETER") view: View) {
    }

    fun onBrandChanged(@Suppress("UNUSED_PARAMETER") radioGroup: RadioGroup, checkedId: Int) {
        selectedBrandId = checkedId
        registry.notifyChange(this, BR._all)
    }

    fun buttonEnabled(): Boolean {
        return selectedBrandId > 0
    }

}
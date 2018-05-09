package br.com.caiogandra.carcatalog.brandlist.viewmodel

import android.arch.lifecycle.LiveData
import android.util.Log
import android.view.View
import android.widget.RadioGroup
import br.com.caiogandra.carcatalog.BR
import br.com.caiogandra.carcatalog.base.BaseView
import br.com.caiogandra.carcatalog.base.BaseViewModel
import br.com.caiogandra.carcatalog.model.response.Brand
import br.com.caiogandra.carcatalog.network.FipeApi
import br.com.caiogandra.carcatalog.network.data.DataWrapper
import br.com.caiogandra.carcatalog.network.request.NetworkRequestHandler

class BrandListViewModel(private val fipeApi: FipeApi) : BaseViewModel<BaseView?>() {

    private var brands: List<Brand> = ArrayList()
    private var selectedBrandId: Int = -1

    fun fetchBrands(): LiveData<DataWrapper<List<Brand>>> {
        return NetworkRequestHandler.doRequest(fipeApi.fetchBrands())
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
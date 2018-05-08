package br.com.caiogandra.carcatalog.brandlist.viewmodel

import android.arch.lifecycle.LiveData
import br.com.caiogandra.carcatalog.base.BaseView
import br.com.caiogandra.carcatalog.base.BaseViewModel
import br.com.caiogandra.carcatalog.model.response.Brand
import br.com.caiogandra.carcatalog.model.response.Brands
import br.com.caiogandra.carcatalog.network.FipeApi
import br.com.caiogandra.carcatalog.network.data.DataWrapper
import br.com.caiogandra.carcatalog.network.request.NetworkRequestHandler

class BrandListViewModel(private val fipeApi: FipeApi) : BaseViewModel<BaseView?>() {

    fun fetchBrands(): LiveData<DataWrapper<Brands>> {
        return NetworkRequestHandler.doRequest(fipeApi.fetchBrands())
    }

}
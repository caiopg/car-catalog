package br.com.caiogandra.carcatalog.datasource.implementation

import android.arch.lifecycle.LiveData
import br.com.caiogandra.carcatalog.datasource.FipeRepository
import br.com.caiogandra.carcatalog.model.response.Brand
import br.com.caiogandra.carcatalog.model.response.CompleteModel
import br.com.caiogandra.carcatalog.network.FipeApi
import br.com.caiogandra.carcatalog.network.data.DataWrapper
import br.com.caiogandra.carcatalog.network.request.NetworkRequestHandler
import javax.inject.Inject

class FipeRepositoryImpl @Inject constructor(private val fipeApi: FipeApi): FipeRepository {

    override fun fetchModels(brand: String): LiveData<DataWrapper<List<CompleteModel>>> {
        return NetworkRequestHandler.doRequest(fipeApi.fetchModels(brand))
    }

    override fun fetchBrands(): LiveData<DataWrapper<List<Brand>>> {
        return NetworkRequestHandler.doRequest(fipeApi.fetchBrands())
    }
}
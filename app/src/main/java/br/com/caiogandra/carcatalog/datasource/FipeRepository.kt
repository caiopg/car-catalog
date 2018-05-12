package br.com.caiogandra.carcatalog.datasource

import android.arch.lifecycle.LiveData
import br.com.caiogandra.carcatalog.model.response.Brand
import br.com.caiogandra.carcatalog.model.response.CompleteCar
import br.com.caiogandra.carcatalog.model.response.CompleteModel
import br.com.caiogandra.carcatalog.network.data.DataWrapper

interface FipeRepository {

    fun fetchBrands(): LiveData<DataWrapper<List<Brand>>>

    fun fetchModels(brand: String): LiveData<DataWrapper<List<CompleteModel>>>

    fun fetchCompleteCar(fipeCode: String, year: String): LiveData<DataWrapper<List<CompleteCar>>>
}
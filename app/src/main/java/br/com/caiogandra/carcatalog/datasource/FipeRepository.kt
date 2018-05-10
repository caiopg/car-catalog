package br.com.caiogandra.carcatalog.datasource

import android.arch.lifecycle.LiveData
import br.com.caiogandra.carcatalog.model.response.Brand
import br.com.caiogandra.carcatalog.network.data.DataWrapper

interface FipeRepository {

    fun fetchBrands(): LiveData<DataWrapper<List<Brand>>>
}
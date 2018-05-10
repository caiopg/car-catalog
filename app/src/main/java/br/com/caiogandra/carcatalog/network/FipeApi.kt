package br.com.caiogandra.carcatalog.network

import br.com.caiogandra.carcatalog.model.response.Brand
import br.com.caiogandra.carcatalog.model.response.CarCompleteModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FipeApi {

    @GET("/cars/brand")
    fun fetchBrands(): Call<List<Brand>>

    @GET("/cars/brand/{brand}")
    fun fetchModels(@Path("brand") brand: String): Call<List<CarCompleteModel>>

    @GET("/cars/{fipeCode}/{year}")
    fun fetchValue(@Path("fipeCode") fipeCode: Int, @Path("year") year: Int)

}
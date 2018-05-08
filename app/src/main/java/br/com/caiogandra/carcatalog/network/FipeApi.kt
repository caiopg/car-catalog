package br.com.caiogandra.carcatalog.network

import br.com.caiogandra.carcatalog.model.response.Brand
import br.com.caiogandra.carcatalog.model.response.Brands
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface FipeApi {

    @GET("/cars/brand")
    fun fetchBrands(): Call<Response<Brands>>

    @GET("/cars/brand/{model}")
    fun fetchModels(@Path("model") model: String)

    @GET("/cars/{fipeCode}/{year}")
    fun fetchValue(@Path("fipeCode") fipeCode: Int, @Path("year") year: Int)

}
package br.com.caiogandra.carcatalog.network.di

import br.com.caiogandra.carcatalog.BuildConfig
import br.com.caiogandra.carcatalog.model.response.Brands
import br.com.caiogandra.carcatalog.network.FipeApi
import br.com.caiogandra.carcatalog.network.serializer.BrandsDeserializer
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun providesFipeApi(): FipeApi {

        val brandsDeserializer = GsonBuilder().registerTypeAdapter(Brands::class.java, BrandsDeserializer())
                .create()

        val client = OkHttpClient.Builder()

        if(BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            client.addInterceptor(loggingInterceptor)
        }

        return Retrofit.Builder()
                .baseUrl(BuildConfig.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(brandsDeserializer))
                .client(client.build())
                .build()
                .create(FipeApi::class.java)
    }
}
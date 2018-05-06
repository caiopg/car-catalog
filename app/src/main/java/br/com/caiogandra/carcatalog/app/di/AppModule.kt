package br.com.caiogandra.carcatalog.app.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun providesContext(application: Application): Context {
        return application
    }
}
package br.com.caiogandra.carcatalog.app.di

import br.com.caiogandra.carcatalog.app.App
import br.com.caiogandra.carcatalog.datasource.di.DataSourceModule
import br.com.caiogandra.carcatalog.network.di.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, NetworkModule::class, ActivityBinding::class, DataSourceModule::class])

interface AppComponent: AndroidInjector<App> {

    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<App>()
}
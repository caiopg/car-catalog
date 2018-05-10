package br.com.caiogandra.carcatalog.datasource.di

import br.com.caiogandra.carcatalog.datasource.FipeRepository
import br.com.caiogandra.carcatalog.datasource.implementation.FipeRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class DataSourceModule {

    @Binds
    abstract fun BindsFipeRepository(fipeRepositoryImpl: FipeRepositoryImpl) : FipeRepository
}
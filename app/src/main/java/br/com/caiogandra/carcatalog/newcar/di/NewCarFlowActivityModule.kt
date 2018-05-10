package br.com.caiogandra.carcatalog.newcar.di

import br.com.caiogandra.carcatalog.newcar.NewCarFlowActivity
import br.com.caiogandra.carcatalog.newcar.controller.CarController
import br.com.caiogandra.carcatalog.newcar.controller.FragmentController
import dagger.Binds
import dagger.Module

@Module
abstract class NewCarFlowActivityModule {

    @Binds
    abstract fun BindsCarController(newCarFlowActivity: NewCarFlowActivity): CarController

    @Binds
    abstract fun BindsFragmentController(newCarFlowActivity: NewCarFlowActivity): FragmentController
}
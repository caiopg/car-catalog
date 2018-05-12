package br.com.caiogandra.carcatalog.app.di

import br.com.caiogandra.carcatalog.carlist.CarListActivity
import br.com.caiogandra.carcatalog.carlist.di.CarListActivityModule
import br.com.caiogandra.carcatalog.newcar.NewCarFlowActivity
import br.com.caiogandra.carcatalog.newcar.di.NewCarFlowActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBinding {

    @ContributesAndroidInjector(modules = [CarListActivityModule::class])
    abstract fun bindCarListActivity(): CarListActivity

    @ContributesAndroidInjector(modules = [FragmentBinding::class, NewCarFlowActivityModule::class])
    abstract fun bindNewCarFlowActivity(): NewCarFlowActivity
}
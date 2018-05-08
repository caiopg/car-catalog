package br.com.caiogandra.carcatalog.app.di

import br.com.caiogandra.carcatalog.carlist.CarListActivity
import br.com.caiogandra.carcatalog.newcar.NewCarFlowActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBinding {

    @ContributesAndroidInjector
    abstract fun bindCarListActivity(): CarListActivity

    @ContributesAndroidInjector(modules = [FragmentBinding::class])
    abstract fun bindNewCarFlowActivity(): NewCarFlowActivity
}
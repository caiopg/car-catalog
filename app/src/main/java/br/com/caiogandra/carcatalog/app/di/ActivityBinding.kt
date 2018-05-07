package br.com.caiogandra.carcatalog.app.di

import br.com.caiogandra.carcatalog.newcar.NewCarFlowActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBinding {

    @ContributesAndroidInjector(modules = [FragmentBinding::class])
    abstract fun bindNewCarFlowActivity(): NewCarFlowActivity
}
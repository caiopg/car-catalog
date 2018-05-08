package br.com.caiogandra.carcatalog.app.di

import br.com.caiogandra.carcatalog.brandlist.BrandListFragment
import br.com.caiogandra.carcatalog.brandlist.di.BrandListFragmentModule
import br.com.caiogandra.carcatalog.modellist.ModelListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBinding {

    @ContributesAndroidInjector(modules = [BrandListFragmentModule::class])
    abstract fun bindBrandListFragment(): BrandListFragment

    @ContributesAndroidInjector
    abstract fun bindModelListFragment(): ModelListFragment
}
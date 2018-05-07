package br.com.caiogandra.carcatalog.app.di

import br.com.caiogandra.carcatalog.brandlist.BrandListFragment
import br.com.caiogandra.carcatalog.modellist.ModelListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBinding {

    @ContributesAndroidInjector
    abstract fun bindBrandListFragment(): BrandListFragment

    @ContributesAndroidInjector
    abstract fun bindModelListFragment(): ModelListFragment
}
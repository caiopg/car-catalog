package br.com.caiogandra.carcatalog.app.di

import br.com.caiogandra.carcatalog.brandlist.BrandListFragment
import br.com.caiogandra.carcatalog.brandlist.di.BrandListFragmentModule
import br.com.caiogandra.carcatalog.completemodellist.CompleteModelListFragment
import br.com.caiogandra.carcatalog.completemodellist.di.CompleteModelListFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBinding {

    @ContributesAndroidInjector(modules = [BrandListFragmentModule::class])
    abstract fun bindBrandListFragment(): BrandListFragment

    @ContributesAndroidInjector(modules = [CompleteModelListFragmentModule::class])
    abstract fun bindCompleteModelListFragment(): CompleteModelListFragment
}
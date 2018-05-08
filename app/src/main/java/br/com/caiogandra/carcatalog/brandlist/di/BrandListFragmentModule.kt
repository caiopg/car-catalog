package br.com.caiogandra.carcatalog.brandlist.di

import android.arch.lifecycle.ViewModelProviders
import br.com.caiogandra.carcatalog.brandlist.BrandListFragment
import br.com.caiogandra.carcatalog.brandlist.viewmodel.BrandListViewModel
import br.com.caiogandra.carcatalog.brandlist.viewmodel.factory.BrandListViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class BrandListFragmentModule {

    @Provides
    fun providesBrandListViewModel(fragment: BrandListFragment, factory: BrandListViewModelFactory): BrandListViewModel {
        return ViewModelProviders.of(fragment, factory).get(BrandListViewModel::class.java)
    }
}
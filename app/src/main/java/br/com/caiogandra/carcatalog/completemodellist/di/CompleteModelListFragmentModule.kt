package br.com.caiogandra.carcatalog.completemodellist.di

import android.arch.lifecycle.ViewModelProviders
import br.com.caiogandra.carcatalog.completemodellist.CompleteModelListFragment
import br.com.caiogandra.carcatalog.completemodellist.view.CompleteModelListView
import br.com.caiogandra.carcatalog.completemodellist.viewmodel.CompleteModelListViewModel
import br.com.caiogandra.carcatalog.completemodellist.viewmodel.factory.CompleteModelListViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class CompleteModelListFragmentModule {

    @Provides
    fun providesCompleteModelListViewModel(fragment: CompleteModelListFragment, factory: CompleteModelListViewModelFactory): CompleteModelListViewModel {
        return ViewModelProviders.of(fragment, factory).get(CompleteModelListViewModel::class.java)
    }

    @Provides
    fun providesCompleteModelListView(fragment: CompleteModelListFragment): CompleteModelListView {
        return fragment
    }
}
package br.com.caiogandra.carcatalog.carlist.di

import android.arch.lifecycle.ViewModelProviders
import br.com.caiogandra.carcatalog.carlist.CarListActivity
import br.com.caiogandra.carcatalog.carlist.view.CarListView
import br.com.caiogandra.carcatalog.carlist.viewmodel.CarListViewModel
import br.com.caiogandra.carcatalog.carlist.viewmodel.factory.CarListViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class CarListActivityModule {

    @Provides
    fun providesCarListViewModel(activity: CarListActivity, factory: CarListViewModelFactory): CarListViewModel {
        return ViewModelProviders.of(activity, factory).get(CarListViewModel::class.java)
    }

    @Provides
    fun providesCarListView(activity: CarListActivity): CarListView {
        return activity
    }
}
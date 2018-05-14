package br.com.caiogandra.carcatalog.newcar.di

import android.arch.lifecycle.ViewModelProviders
import br.com.caiogandra.carcatalog.carlist.viewmodel.factory.NewCarFlowViewModelFactory
import br.com.caiogandra.carcatalog.newcar.NewCarFlowActivity
import br.com.caiogandra.carcatalog.newcar.controller.CarController
import br.com.caiogandra.carcatalog.newcar.controller.FragmentController
import br.com.caiogandra.carcatalog.newcar.viewmodel.NewCarFlowViewModel
import dagger.Module
import dagger.Provides

@Module
class NewCarFlowActivityModule {

    @Provides
    fun providesCarController(newCarFlowActivity: NewCarFlowActivity): CarController {
        return newCarFlowActivity
    }

    @Provides
    fun providesFragmentController(newCarFlowActivity: NewCarFlowActivity): FragmentController {
        return newCarFlowActivity
    }

    @Provides
    fun providesNewCarFlowViewModel(activity: NewCarFlowActivity, factory: NewCarFlowViewModelFactory): NewCarFlowViewModel {
        return ViewModelProviders.of(activity, factory).get(NewCarFlowViewModel::class.java)
    }
}
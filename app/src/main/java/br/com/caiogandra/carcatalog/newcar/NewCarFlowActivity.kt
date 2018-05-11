package br.com.caiogandra.carcatalog.newcar

import android.databinding.DataBindingUtil
import android.os.Bundle
import br.com.caiogandra.carcatalog.R
import br.com.caiogandra.carcatalog.base.BaseActivity
import br.com.caiogandra.carcatalog.base.BaseFragment
import br.com.caiogandra.carcatalog.brandlist.BrandListFragment
import br.com.caiogandra.carcatalog.databinding.ActivityCarListBinding
import br.com.caiogandra.carcatalog.model.Car
import br.com.caiogandra.carcatalog.completemodellist.CompleteModelListFragment
import br.com.caiogandra.carcatalog.datasource.CarRepository
import br.com.caiogandra.carcatalog.newcar.controller.CarController
import br.com.caiogandra.carcatalog.newcar.controller.FragmentController
import dagger.android.AndroidInjection

class NewCarFlowActivity: BaseActivity(), FragmentController, CarController {

    var car: Car = Car(id = CarRepository.fetchTotalCars())

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityCarListBinding>(this, R.layout.activity_new_car_flow)

        startFlow()
    }

    override fun startFlow() {
        supportFragmentManager.beginTransaction().replace(R.id.new_car_flow_container, BrandListFragment.newInstance()).commit()
    }

    override fun goToNextFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.new_car_flow_container, CompleteModelListFragment.newInstance()).commit()
    }

    override fun exitFlow() {
        //todo
    }

    override fun updateBrand(brand: String) {
        car.brand = brand
    }

    override fun updateModel(model: String) {
        car.model = model
    }

    override fun updateYear(year: String) {
        car.year = year
    }

    override fun updateValue(value: Int) {
        car.value
    }

    override fun updateFipeCode(fipeCode: String) {
        car.fipeCode
    }

    override fun getBrand(): String {
        return car.brand
    }
}
package br.com.caiogandra.carcatalog.newcar

import android.app.Activity
import android.databinding.DataBindingUtil
import android.os.Bundle
import br.com.caiogandra.carcatalog.R
import br.com.caiogandra.carcatalog.base.BaseActivity
import br.com.caiogandra.carcatalog.brandlist.BrandListFragment
import br.com.caiogandra.carcatalog.databinding.ActivityCarListBinding
import br.com.caiogandra.carcatalog.model.Car
import br.com.caiogandra.carcatalog.completemodellist.CompleteModelListFragment
import br.com.caiogandra.carcatalog.datasource.CarRepository
import br.com.caiogandra.carcatalog.newcar.controller.CarController
import br.com.caiogandra.carcatalog.newcar.controller.FragmentController
import com.pawegio.kandroid.v
import dagger.android.AndroidInjection

class NewCarFlowActivity: BaseActivity(), FragmentController, CarController {

    companion object {
        val REQUEST_CODE = 1
    }

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
        setResult(Activity.RESULT_OK)
        finish()
    }

    override fun updateBrand(brand: String) {
        car.brand = brand
    }

    override fun updateCar(model: String, year: String, value: Int, fipeCode: String) {
        car.model = model
        car.year = year
        car.value = value
        car.fipeCode = fipeCode
    }

    override fun getBrand(): String {
        return car.brand
    }

    override fun persistCar() {
        CarRepository.persistCar(car)
    }
}
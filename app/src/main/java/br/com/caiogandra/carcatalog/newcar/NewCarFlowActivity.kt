package br.com.caiogandra.carcatalog.newcar

import android.app.Activity
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.MenuItem
import br.com.caiogandra.carcatalog.R
import br.com.caiogandra.carcatalog.base.BaseActivity
import br.com.caiogandra.carcatalog.brandlist.BrandListFragment
import br.com.caiogandra.carcatalog.completemodellist.CompleteModelListFragment
import br.com.caiogandra.carcatalog.databinding.ActivityCarListBinding
import br.com.caiogandra.carcatalog.datasource.car.CarRepository
import br.com.caiogandra.carcatalog.model.Car
import br.com.caiogandra.carcatalog.newcar.controller.CarController
import br.com.caiogandra.carcatalog.newcar.controller.FragmentController
import br.com.caiogandra.carcatalog.newcar.viewmodel.NewCarFlowViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject


class NewCarFlowActivity: BaseActivity(), FragmentController, CarController {

    companion object {
        const val REQUEST_CODE = 1
    }

    @Inject lateinit var viewModel: NewCarFlowViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityCarListBinding>(this, R.layout.activity_new_car_flow)

        updateToolbarTitle(R.string.new_car_toolbat_title)
        showToolbarCloseButton()

        startFlow()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
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
        viewModel.updateBrand(brand)
    }

    override fun updateCar(model: String, year: String, value: Int, fipeCode: String) {
        viewModel.updateCar(model, year, value, fipeCode)
    }

    override fun getBrand(): String {
        return viewModel.getBrand()
    }

    override fun persistCar() {
        viewModel.persistCar()
    }
}
package br.com.caiogandra.carcatalog.newcar

import android.databinding.DataBindingUtil
import android.os.Bundle
import br.com.caiogandra.carcatalog.R
import br.com.caiogandra.carcatalog.base.BaseActivity
import br.com.caiogandra.carcatalog.base.BaseFragment
import br.com.caiogandra.carcatalog.brandlist.BrandListFragment
import br.com.caiogandra.carcatalog.databinding.ActivityCarListBinding
import br.com.caiogandra.carcatalog.datasource.CarRepository
import br.com.caiogandra.carcatalog.model.Car
import br.com.caiogandra.carcatalog.modellist.ModelListFragment
import br.com.caiogandra.carcatalog.newcar.controller.CarController
import br.com.caiogandra.carcatalog.newcar.controller.FragmentController
import dagger.android.AndroidInjection

class NewCarFlowActivity: BaseActivity(), FragmentController, CarController {

    private val FIRST_FRAGMENT_TAG = ModelListFragment.TAG

    private var fragmentMap = HashMap<String, String>()
    var car: Car = Car(id = CarRepository.fetchTotalCars())

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityCarListBinding>(this, R.layout.activity_new_car_flow)

        setupFragmentMap()
        startFlow()
    }

    fun setupFragmentMap() {
        fragmentMap = hashMapOf(BrandListFragment.TAG to ModelListFragment.TAG)
    }

    fun fetchNextFragment(tag: String): BaseFragment{
        return fetchFragment(fragmentMap[tag]!!)
    }

    fun fetchFragment(tag: String): BaseFragment{

        return when(tag) {
            BrandListFragment.TAG -> {
                BrandListFragment.newInstance()
            }
            ModelListFragment.TAG -> {
                ModelListFragment.newInstance()
            }
            else -> throw IllegalStateException("Unidentified TAG.")
        }
    }

    override fun startFlow() {
        supportFragmentManager.beginTransaction().replace(R.id.new_car_flow_container, fetchFragment(FIRST_FRAGMENT_TAG)).commit()
    }

    override fun goToNextFragment(tag: String) {
        supportFragmentManager.beginTransaction().replace(R.id.new_car_flow_container, fetchNextFragment(tag)).commit()
    }

    override fun exitFlow() {
        //todo
    }

    override fun updateBrand(brand: String) {
        car.brand = brand
    }

    override fun updateModel(model: String) {
        //todo
    }

    override fun updateYear(year: Int) {
        //todo
    }

    override fun updateValue(value: Int) {
        //todo
    }
}
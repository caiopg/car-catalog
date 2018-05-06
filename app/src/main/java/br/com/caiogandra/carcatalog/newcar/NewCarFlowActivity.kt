package br.com.caiogandra.carcatalog.newcar

import android.databinding.DataBindingUtil
import android.os.Bundle
import br.com.caiogandra.carcatalog.R
import br.com.caiogandra.carcatalog.base.BaseActivity
import br.com.caiogandra.carcatalog.base.BaseFragment
import br.com.caiogandra.carcatalog.brandlist.BrandListFragment
import br.com.caiogandra.carcatalog.databinding.ActivityCarListBinding
import br.com.caiogandra.carcatalog.modellist.ModelListFragment
import br.com.caiogandra.carcatalog.newcar.controller.FragmentController

class NewCarFlowActivity: BaseActivity(), FragmentController {

    var fragmentMap = HashMap<String?, String?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityCarListBinding>(this, R.layout.activity_new_car_flow)

        setupFragmentMap()
        startFlow()
    }

    fun setupFragmentMap() {
        fragmentMap = hashMapOf(BrandListFragment.TAG to ModelListFragment.TAG)
    }

    fun fetchNextFragment(tag: String): BaseFragment{

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
        supportFragmentManager.beginTransaction().replace(R.id.new_car_flow_container, BrandListFragment.newInstance())
    }

    override fun nextFragment() {
        //todo
//        fetchNextFragment(fragmentMap)
    }

    override fun exitFlow() {
        //todo
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
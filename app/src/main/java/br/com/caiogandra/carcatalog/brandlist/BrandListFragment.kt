package br.com.caiogandra.carcatalog.brandlist

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import br.com.caiogandra.carcatalog.R
import br.com.caiogandra.carcatalog.base.BaseFragment
import br.com.caiogandra.carcatalog.brandlist.viewmodel.BrandListViewModel
import br.com.caiogandra.carcatalog.databinding.FragmentBrandListBinding
import br.com.caiogandra.carcatalog.model.response.Brand
import br.com.caiogandra.carcatalog.network.listener.NetworkListener
import br.com.caiogandra.carcatalog.network.request.NetworkObserver
import com.pawegio.kandroid.longToast
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class BrandListFragment: BaseFragment() {

    companion object {
        val TAG = BrandListFragment::class.simpleName

        fun newInstance(): BrandListFragment {
            return BrandListFragment()
        }
    }

    private lateinit var binding: FragmentBrandListBinding

    @Inject lateinit var viewModel: BrandListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentBrandListBinding>(inflater,
                R.layout.fragment_brand_list, container, false)

        viewModel.fetchBrands().observe(
                this,
                NetworkObserver(object: NetworkListener<List<Brand>>{
                    override fun onSuccess(dataWrapper: List<Brand>?) {
                        updateRadioGroup(dataWrapper)
                    }

                    override fun onException(throwable: Throwable?) {
                        //todo
                    }
                })
        )

        return binding.root
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)

        super.onAttach(context)
    }

    private fun updateRadioGroup(brands: List<Brand>?) {
        if(brands !=  null) {
            brands.forEach {
                var radioButton = RadioButton(activity)
                radioButton.text = it.brand
                radioButton.tag = it.brand

                val layoutParams = RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT,
                        RadioGroup.LayoutParams.MATCH_PARENT)

                binding.brandListRadioGroup.addView(radioButton, layoutParams)
            }
        }
    }

}
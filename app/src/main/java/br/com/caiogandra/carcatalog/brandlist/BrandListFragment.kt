package br.com.caiogandra.carcatalog.brandlist

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.caiogandra.carcatalog.R
import br.com.caiogandra.carcatalog.base.BaseFragment
import br.com.caiogandra.carcatalog.databinding.FragmentBrandListBinding

class BrandListFragment: BaseFragment() {

    companion object {
        val TAG = BrandListFragment::class.simpleName

        fun newInstance(): BrandListFragment {
            return BrandListFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentBrandListBinding>(inflater,
                R.layout.fragment_brand_list, container, false)

        return binding.root
    }

}
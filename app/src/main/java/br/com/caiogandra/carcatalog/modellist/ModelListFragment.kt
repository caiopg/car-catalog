package br.com.caiogandra.carcatalog.modellist

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.caiogandra.carcatalog.R
import br.com.caiogandra.carcatalog.base.BaseFragment
import br.com.caiogandra.carcatalog.databinding.FragmentModelListBinding

class ModelListFragment: BaseFragment() {

    companion object {
        val TAG = ModelListFragment::class.simpleName

        fun newInstance(): ModelListFragment {
            return ModelListFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentModelListBinding>(inflater,
                R.layout.fragment_brand_list, container, false)

        return binding.root
    }

}
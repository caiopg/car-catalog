package br.com.caiogandra.carcatalog.completemodellist

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.caiogandra.carcatalog.R
import br.com.caiogandra.carcatalog.base.BaseFragment
import br.com.caiogandra.carcatalog.databinding.FragmentCompleteModelListBinding

class CompleteModelListFragment: BaseFragment() {

    companion object {
        val TAG = CompleteModelListFragment::class.simpleName!!

        fun newInstance(): CompleteModelListFragment {
            return CompleteModelListFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentCompleteModelListBinding>(inflater,
                R.layout.fragment_complete_model_list, container, false)

        return binding.root

        //todo similar to brand
    }

}
package br.com.caiogandra.carcatalog.completemodellist

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import br.com.caiogandra.carcatalog.R
import br.com.caiogandra.carcatalog.base.BaseFragment
import br.com.caiogandra.carcatalog.completemodellist.view.CompleteModelListView
import br.com.caiogandra.carcatalog.completemodellist.viewmodel.CompleteModelListViewModel
import br.com.caiogandra.carcatalog.databinding.FragmentCompleteModelListBinding
import br.com.caiogandra.carcatalog.model.response.CompleteCar
import br.com.caiogandra.carcatalog.model.response.CompleteModel
import br.com.caiogandra.carcatalog.network.listener.NetworkListener
import br.com.caiogandra.carcatalog.network.request.NetworkObserver
import dagger.android.support.AndroidSupportInjection
import java.text.NumberFormat
import java.util.*
import javax.inject.Inject

class CompleteModelListFragment: BaseFragment(), CompleteModelListView {

    companion object {
        fun newInstance(): CompleteModelListFragment {
            return CompleteModelListFragment()
        }
    }

    private lateinit var binding: FragmentCompleteModelListBinding
    private val valueReal = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))

    @Inject lateinit var viewModel: CompleteModelListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_complete_model_list, container, false)
        binding.viewModel = viewModel

        viewModel.fetchCompleteModels().observe(
                this,
                NetworkObserver(object: NetworkListener<List<CompleteModel>> {
                    override fun onSuccess(dataWrapper: List<CompleteModel>?) {
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

    private fun updateRadioGroup(completeModels: List<CompleteModel>?) {

        val sortedList = completeModels?.sortedWith(compareBy({it.model}, {it.year}))

        sortedList?.forEachIndexed { index, completeModel ->
            var radioButton = RadioButton(activity)
            radioButton.text = completeModel.model + " - " + completeModel.year
            radioButton.id = index

            val layoutParams = RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT,
                    RadioGroup.LayoutParams.MATCH_PARENT)

            binding.completeModelListRadioGroup.addView(radioButton, layoutParams)
        }

        if(sortedList != null) {
            viewModel.completeModels = sortedList
        }
    }

    override fun showSummaryDialog(fipeCode: String, year: String) {
        viewModel.fetchCompleteCar(fipeCode, year).observe(this, NetworkObserver(object: NetworkListener<List<CompleteCar>>{
            override fun onSuccess(dataWrapper: List<CompleteCar>?) {
                val carResponse = dataWrapper!![0]
                viewModel.updateCar(carResponse.model, carResponse.year,
                        carResponse.fipeCode, carResponse.value)

                val builder = context?.let { AlertDialog.Builder(it) }

                if (builder != null) {
                    with(builder) {
                        setTitle(R.string.complete_model_list_dialog_title)

                        val content = String.format(getString(R.string.complete_model_list_dialog_text),
                                carResponse.brand,
                                carResponse.model,
                                carResponse.year,
                                valueReal.format(carResponse.value))

                        setMessage(content)

                        setPositiveButton(R.string.general_ok, { dialog, which ->
                            dialog.dismiss()
                            viewModel.goToCarList()
                        })

                        builder.create()
                        builder.show()
                    }
                }
            }

            override fun onException(throwable: Throwable?) {
                //todo
            }
        }))
    }

}
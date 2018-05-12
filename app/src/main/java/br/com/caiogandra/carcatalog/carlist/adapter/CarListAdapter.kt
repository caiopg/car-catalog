package br.com.caiogandra.carcatalog.carlist.adapter

import android.app.Application
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.caiogandra.carcatalog.R
import br.com.caiogandra.carcatalog.carlist.viewmodel.CarListItemViewModel
import br.com.caiogandra.carcatalog.databinding.ItemCarListBinding
import br.com.caiogandra.carcatalog.model.Car

class CarListAdapter(private val application: Application, var cars : List<Car>) : RecyclerView.Adapter<CarListAdapter.CarListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarListViewHolder {

        var binding = DataBindingUtil.inflate<ItemCarListBinding>(LayoutInflater.from(application),
                R.layout.item_car_list, parent, false)

        return CarListViewHolder(binding.root, binding)
    }

    override fun getItemCount(): Int {
        return cars.size
    }

    override fun onBindViewHolder(holder: CarListViewHolder, position: Int) {
        val viewModel = CarListItemViewModel(cars[position])
        holder.viewBinding.viewModel = viewModel
    }

    class CarListViewHolder(itemView : View, val viewBinding: ItemCarListBinding) : RecyclerView.ViewHolder(itemView)
}
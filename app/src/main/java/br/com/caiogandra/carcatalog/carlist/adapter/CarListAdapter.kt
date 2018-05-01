package br.com.caiogandra.carcatalog.carlist.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import br.com.caiogandra.carcatalog.model.Car

class CarListAdapter(private val cars : List<Car>) : RecyclerView.Adapter<CarListAdapter.CarListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarListViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        return cars.size
    }

    override fun onBindViewHolder(holder: CarListViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class CarListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }
}
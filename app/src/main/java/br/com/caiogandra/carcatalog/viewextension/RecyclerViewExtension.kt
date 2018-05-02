package br.com.caiogandra.carcatalog.viewextension

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import br.com.caiogandra.carcatalog.carlist.view.CarListView
import br.com.caiogandra.carcatalog.model.Car

@BindingAdapter("bind:cars", "bind:view")
fun RecyclerView.setCarListAdapter( cars: List<Car>, view: CarListView) {
    view.updateCarListAdapter(this, cars)
}
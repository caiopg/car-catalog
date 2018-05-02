package br.com.caiogandra.carcatalog.carlist.view

import android.support.v7.widget.RecyclerView
import br.com.caiogandra.carcatalog.base.BaseView
import br.com.caiogandra.carcatalog.model.Car

interface CarListView: BaseView {
    fun updateCarListAdapter(recyclerView: RecyclerView, cars: List<Car>)
}
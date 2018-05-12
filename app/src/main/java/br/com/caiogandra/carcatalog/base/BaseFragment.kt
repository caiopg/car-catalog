package br.com.caiogandra.carcatalog.base

import android.support.v4.app.Fragment
import android.view.View

open class BaseFragment: Fragment() {

    fun showView(view: View?) {
        view?.visibility = View.VISIBLE
    }

    fun dismissView(view: View?) {
       view?.visibility = View.GONE
    }
}
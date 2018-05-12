package br.com.caiogandra.carcatalog.base

import android.support.v4.app.Fragment
import android.view.View
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import br.com.caiogandra.carcatalog.R


open class BaseFragment: Fragment() {

    fun showView(view: View?) {
        view?.visibility = View.VISIBLE
    }

    fun dismissView(view: View?) {
       view?.visibility = View.GONE
    }

    fun showErrorSnackbar(textId: Int) {
        view?.let {
            val snackbar = Snackbar.make(it, textId, Snackbar.LENGTH_LONG)

            snackbar.view.setBackgroundColor(ContextCompat.getColor(activity!!, R.color.red))
            snackbar.show()
        }
    }
}
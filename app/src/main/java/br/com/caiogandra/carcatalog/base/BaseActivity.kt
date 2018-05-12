package br.com.caiogandra.carcatalog.base

import br.com.caiogandra.carcatalog.R
import dagger.android.support.DaggerAppCompatActivity

open class BaseActivity : DaggerAppCompatActivity() {

    fun updateToolbarTitle(title: Int) {
        supportActionBar?.title = getString(title)
    }

    fun showToolbarCloseButton() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close_white)
    }
}
package br.com.caiogandra.carcatalog.base

import dagger.android.support.DaggerAppCompatActivity

open class BaseActivity : DaggerAppCompatActivity() {

    fun updateToolbarTitle(title: Int) {
        supportActionBar?.title = getString(title)
    }
}
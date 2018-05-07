package br.com.caiogandra.carcatalog.app

import br.com.caiogandra.carcatalog.app.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.realm.Realm
import io.realm.RealmConfiguration

class App: DaggerApplication() {

    override fun onCreate() {
        super.onCreate()

        initializeRealm()
    }

    private fun initializeRealm() {
        Realm.init(this)

        val realmConfig = RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build()

        Realm.setDefaultConfiguration(realmConfig)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

}
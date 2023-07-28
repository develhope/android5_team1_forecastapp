package co.develhope.meteoapp

import android.app.Application
import co.develhope.meteoapp.network.local.Place

class MyApplicationMeteo : Application() {

    companion object {
        var preferences: Preferences? = null
        val recentSearchesList = mutableListOf<Place>()
        lateinit var instance: MyApplicationMeteo
    }


    override fun onCreate() {
        super.onCreate()
        preferences = Preferences(applicationContext)
        instance = this
    }


}
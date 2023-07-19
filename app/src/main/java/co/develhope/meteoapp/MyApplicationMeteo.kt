package co.develhope.meteoapp

import android.app.Application

class MyApplicationMeteo : Application() {

    companion object {
        var preferences: Preferences? = null
        lateinit var instance: MyApplicationMeteo
    }


    override fun onCreate() {
        super.onCreate()
        preferences = Preferences(applicationContext)
        instance = this
    }


}
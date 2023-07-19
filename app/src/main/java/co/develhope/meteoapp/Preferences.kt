package co.develhope.meteoapp

import android.content.Context
import co.develhope.meteoapp.network.local.Place
import com.google.gson.GsonBuilder

class Preferences(context : Context) {

    val prefPlace = context.getSharedPreferences("place",Context.MODE_PRIVATE)

    private val gson = GsonBuilder().create()


    fun getPrefPlace(): Place? {
        val jsonPlace = prefPlace.getString("place", null)
        return jsonPlace?.let { gson.fromJson(it, Place::class.java) }
    }
}

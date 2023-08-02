package co.develhope.meteoapp

import android.content.Context
import co.develhope.meteoapp.data.local.Place
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

class Preferences(context : Context) {

    val prefPlace = context.getSharedPreferences("place",Context.MODE_PRIVATE)
    val preferencesRecentSearch = context.getSharedPreferences("recentSerches",Context.MODE_PRIVATE)

    private val gson = GsonBuilder().create()


    fun getPrefPlace(): Place? {
        val jsonPlace = prefPlace.getString("place", null)
        return jsonPlace?.let { gson.fromJson(it, Place::class.java) }
    }

    fun savePrefPlace(place : Place) {
        val placePref : String = Gson().toJson(place)
        prefPlace.edit().putString("place", placePref).apply()
    }

//    fun getRecentSearch(): MutableList<Place> {
//        val jsonRecentSearch = preferencesRecentSearch.getString("recentSearch", null)
//        return jsonRecentSearch?.let { gson.fromJson(it, Array<Place>::class.java)?.toMutableList() }
//            ?: mutableListOf()
//    }

//    fun saveRecentSearch(place : List<Place>) {
//        val recentSearch : String = Gson().toJson(place)
//        preferencesRecentSearch.edit().putString("recentSearch", recentSearch).apply()
//    }

    fun getRecentSearch(): MutableList<Place> {
        val gson = Gson()
        val json = preferencesRecentSearch.getString("recentSearch", null)
        val type = object : TypeToken<List<Place>>() {}.type
        return gson.fromJson(json, type)
            ?: mutableListOf()
    }

    fun saveRecentSearch(place: Place) {
        val listRecent = getRecentSearch()
        if (!listRecent.contains(place)) {
            listRecent.add(place)
        } else {
            listRecent.remove(place)
            listRecent.add(place)
        }
        val editor = preferencesRecentSearch.edit()
        val gson = Gson()
        val json = gson.toJson(listRecent)
        editor.putString("recentSearch", json)
        editor.apply()
    }
}

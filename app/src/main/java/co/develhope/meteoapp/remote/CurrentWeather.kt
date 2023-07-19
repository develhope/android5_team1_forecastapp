package co.develhope.meteoapp.remote

import com.google.gson.annotations.SerializedName

data class CurrentWeather(
    val temperature: Double,
    val windSpeed: Double,
    val weathercode: Int,
    @SerializedName("is_day") val isDay: Int,
    val time: String
)
package co.develhope.meteoapp.network.data

import com.google.gson.annotations.SerializedName

data class CurrentWeather (
    val temperature: Double,
    val time: String,
    val weathercode: Int,
    @SerializedName
        ("is_day") val isDay: Int,
    val windspeed: Double
)
package co.develhope.meteoapp.network.data

import com.google.gson.annotations.SerializedName

data class HourlyUnits(
    val rain: String,
    val showers: String,
    val snowfall: String,
    @SerializedName("temperature_2m")
    val temperature2m: String,
    val time: String,
    val weathercode: String,
    @SerializedName("windspeed_10m")
    val windspeed10m: String
)
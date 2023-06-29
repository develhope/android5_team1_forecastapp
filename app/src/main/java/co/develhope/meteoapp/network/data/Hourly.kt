package co.develhope.meteoapp.network.data

import com.google.gson.annotations.SerializedName
import java.time.OffsetDateTime


data class Hourly(
    val rain: List<Double>,
    val showers: List<Double>,
    val snowfall: List<Double>,
    @SerializedName("temperature_2m")
    val temperature2m: List<Double>,
    val time: List<String>,
    val weathercode: List<Int>,
    @SerializedName("windspeed_10m")
    val windspeed10m: List<Double>,
    val cloudcover: List<Double>,
    @SerializedName("precipitation_probability")
    val precipitationProb: List<Double>,
    @SerializedName("relativehumidity_2m")
    val relativeHumidity2m: List<Double>,
    @SerializedName("apparent_temperature")
    val apparentTemperature: List<Double>,
    @SerializedName("winddirection_10m")
    val windDirection: List<Int>,
)
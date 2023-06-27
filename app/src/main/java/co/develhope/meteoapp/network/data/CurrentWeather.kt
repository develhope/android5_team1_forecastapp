package co.develhope.meteoapp.network.data

import com.google.gson.annotations.SerializedName
import java.time.OffsetDateTime

data class CurrentWeather (
    val temperature: Double,
    val time: OffsetDateTime,
    val weathercode: Int,
    @SerializedName
        ("is_day") val isDay: Int,
    val windspeed: Double
)
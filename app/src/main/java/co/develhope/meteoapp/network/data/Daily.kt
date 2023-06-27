package co.develhope.meteoapp.network.data

import com.google.gson.annotations.SerializedName
import java.time.OffsetDateTime

data class Daily(
    @SerializedName("precipitation_sum")
    val precipitationSum: List<Double>,
    @SerializedName("rain_sum")
    val rainSum: List<Double>,
    val sunrise: List<String>,
    val sunset: List<String>,
    @SerializedName("temperature_2m_max")
    val temperature2mMax: List<Double>,
    @SerializedName("temperature_2m_min")
    val temperature2mMin: List<Double>,
    val time: OffsetDateTime,
    @SerializedName("weathercode")
    val weathercode: List<Int>,
    @SerializedName("windspeed_10m_max")
    val windspeed10mMax : List<Double>,
    val dayWeek: List<String>
)
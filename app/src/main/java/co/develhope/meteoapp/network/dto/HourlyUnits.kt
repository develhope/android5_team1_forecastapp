package co.develhope.meteoapp.network.dto


import com.google.gson.annotations.SerializedName
import org.threeten.bp.OffsetDateTime

data class HourlyUnits(
    val time: String,
    @SerializedName("temperature_2m") val temperature: String,
    @SerializedName("relativehumidity_2m") val humidityUnit: String,
    val rain: String,
    val cloudcover: String,
    @SerializedName("windspeed_10m") val windSpeed: String,
    @SerializedName("uv_index") val uvIndex: String,
)

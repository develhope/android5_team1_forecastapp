package co.develhope.meteoapp.remote

import com.google.gson.annotations.SerializedName

data class ForecastData(
    val latitude: Double,
    val longitude: Double,
    @SerializedName("generationtime_ms") val generationtimeMs: Double,
    @SerializedName("utc_offset_seconds") val utcOffsetSeconds: Int,
    val timezone: String,
    @SerializedName("timezone_abbreviation") val timezoneAbbreviation: String,
    val elevation: Double,
    @SerializedName("hourly_units") val hourlyUnits: HourlyUnits,
    val hourly: Hourly,
    @SerializedName("current_weather") val currentWeather: CurrentWeather,
    var isExpanded: Boolean = false
)

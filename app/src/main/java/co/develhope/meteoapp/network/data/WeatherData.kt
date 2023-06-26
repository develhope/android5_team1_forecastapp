package co.develhope.meteoapp.network.data

import com.google.gson.annotations.SerializedName

data class WeatherData(
    val latitude: Double,
    val longitude: Double,
    @SerializedName("generationtime_ms")
    val generationTimeMs: Double,
    @SerializedName("utc_offset_seconds")
    val utcOffsetSeconds: Int,
    val timezone: String,
    @SerializedName("timezone_abbreviation")
    val timezoneAbbreviation: String,
    val elevation: Double,
    @SerializedName("hourly_units")
    val hourlyHunits: HourlyUnits,
    val hourly: Hourly,
    @SerializedName("current_weather") val currentWeather: CurrentWeather,
)

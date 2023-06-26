package co.develhope.meteoapp.network.data

import com.google.gson.annotations.SerializedName

data class DailySummary(
    @SerializedName("current_weather")
    val currentWeather: CurrentWeather,
    val elevation: Double,
    @SerializedName("generationtime_ms")
    val generationtimeMs: Double,
    val hourly: Hourly,
    @SerializedName("hourly_units")
    val hourlyUnits: HourlyUnits,
    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    @SerializedName("timezone_abbreviation")
    val timezoneAbbreviation: String,
    @SerializedName("utc_offset_seconds")
    val utcOffsetSeconds: Int,
)

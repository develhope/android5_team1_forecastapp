package co.develhope.meteoapp.network.data

import com.google.gson.annotations.SerializedName

data class WeeklySummary(
    val currentWeather: CurrentWeather,
    val daily: Daily,
    val hourly: Hourly,
    val dailyUnits: DailyUnits,
    val elevation: Double,
    val generationtimeMs: Double,
    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    val timezoneAbbreviation: String,
    val utcOffsetSeconds: Int,
)
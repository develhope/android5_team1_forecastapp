package co.develhope.meteoapp.remote

import com.google.gson.annotations.SerializedName

data class DailySummary(
    @SerializedName("current_weather")
    val currentWeather: CurrentWeather,
    val daily: Daily,
    val hourly: Hourly,
    @SerializedName("hourly_units")
    val hourlyUnits: HourlyUnits,
    @SerializedName("daily_units")
    val dailyUnits: DailyUnits,
    val elevation: Double,
    @SerializedName("generationtime_ms")
    val generationTimeMs: Double,
    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    @SerializedName("timezone_abbreviation")
    val timezoneAbbreviation: String,
    @SerializedName("utc_offset_seconds")
    val utcOffsetSeconds: Int
)
package co.develhope.meteoapp.network.local

import org.threeten.bp.OffsetDateTime

data class WeatherSummary(
    val weatherType: WeatherType,
    val humidity: Int,
    val wind: Int,
    val tempMin: Int,
    val tempMax: Int,
    val rain: Int,
    val date: OffsetDateTime
)

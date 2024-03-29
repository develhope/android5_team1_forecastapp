package co.develhope.meteoapp.data.local

import org.threeten.bp.OffsetDateTime

data class WeatherSummary(
    val weatherType: WeatherType,
    val wind: Int,
    val tempMin: Int,
    val tempMax: Int,
    val rain: Int,
    val date: OffsetDateTime
)

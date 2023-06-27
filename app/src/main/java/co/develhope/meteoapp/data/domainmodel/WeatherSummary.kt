package co.develhope.meteoapp.data.domainmodel

import java.time.OffsetDateTime

data class WeatherSummary(
    val weatherType: WeatherType,
    val humidity: Int,
    val wind: Int,
    val tempMin: Int,
    val tempMax: Int,
    val rain: Int,
    val date: OffsetDateTime
)
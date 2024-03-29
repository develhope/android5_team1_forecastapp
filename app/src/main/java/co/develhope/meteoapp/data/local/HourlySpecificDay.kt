package co.develhope.meteoapp.data.local

import org.threeten.bp.OffsetDateTime

data class HourlySpecificDay(
    val time: OffsetDateTime,
    val weatherType: WeatherType,
    val temp: Int,
    val humidity: Int
)
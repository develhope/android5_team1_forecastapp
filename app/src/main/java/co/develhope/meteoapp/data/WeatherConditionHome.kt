package co.develhope.meteoapp.data

import co.develhope.meteoapp.network.data.Daily
import co.develhope.meteoapp.network.data.Hourly

data class WeatherConditionHome(
    val hourly: Hourly,
    val daily: Daily
)

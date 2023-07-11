package co.develhope.meteoapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class TodayTomorrowWeatherConditions(
    @StringRes val hour: Int,
    @DrawableRes val weather: Int,
    val temperature: String,
    val humidityPercentage : String,
    val tempCardView : String,
    val indiceUv : String,
    val humidityCardView : String,
    val windpseed : String,
    val rainCover : String,
    val rain : String,
    var isExpanded: Boolean = false
)

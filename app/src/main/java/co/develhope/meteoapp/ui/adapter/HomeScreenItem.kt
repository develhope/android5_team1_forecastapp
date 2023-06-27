package co.develhope.meteoapp.ui.adapter

import co.develhope.meteoapp.data.domainmodel.Place
import co.develhope.meteoapp.data.domainmodel.WeatherSummary

sealed class HomeScreenItem {
    data class CardItem(
        val dailyForecast: WeatherSummary
    ) : HomeScreenItem()

    data class Title(val place: Place) : HomeScreenItem()
    object Subtitle : HomeScreenItem()
}


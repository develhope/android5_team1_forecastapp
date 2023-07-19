package co.develhope.meteoapp.network.local

import co.develhope.meteoapp.R

enum class WeatherType {
    SUNNY, CLOUDY, RAINY;

    fun imageWeatherType(): Int {
        return when (this) {
            SUNNY -> R.drawable.sun
            RAINY -> R.drawable.rain
            CLOUDY -> R.drawable.sun_cloud
            else -> R.drawable.moon
        }
    }
}
fun Int?.getWeatherType(): WeatherType {
    return when(this) {
        0 -> WeatherType.SUNNY
        1, 2, 3 -> WeatherType.CLOUDY
        else -> WeatherType.RAINY
    }
}

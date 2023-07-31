package co.develhope.meteoapp.data.local

import co.develhope.meteoapp.R

enum class WeatherType {
    SUNNY, CLOUDY, RAINY, FOGGY, THUNDERSTORM, HEAVYRAIN, NIGHT;

    fun imageWeatherType(): Int {
        return when (this) {
            SUNNY -> R.drawable.sun
            RAINY -> R.drawable.rain
            CLOUDY -> R.drawable.sun_cloud
            THUNDERSTORM -> R.drawable.rain
            FOGGY -> R.drawable.sun_cloud
            HEAVYRAIN -> R.drawable.rain
            NIGHT -> R.drawable.moon
            else -> R.drawable.moon
        }
    }
}
fun Int?.getWeatherType(): WeatherType {
    return when(this) {
        0  -> WeatherType.SUNNY
        1, 2, 3 -> WeatherType.CLOUDY
        in 45..48 -> WeatherType.FOGGY
        in 51..77 -> WeatherType.RAINY
        80, 81, 82 -> WeatherType.HEAVYRAIN
        in 95..99 -> WeatherType.HEAVYRAIN
        else -> WeatherType.CLOUDY
    }
}

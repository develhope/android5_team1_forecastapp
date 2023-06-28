package co.develhope.meteoapp.data.domainmodel

import co.develhope.meteoapp.R

enum class WeatherType {
    Sun, Cloud, Rain, Fog, Tempest, HeavyRain;

    fun setIconWeatherType(): Int {
        return when (this) {
            Sun -> R.drawable.sun
            Rain -> R.drawable.rain
            Cloud -> R.drawable.sun_cloud
            Tempest -> R.drawable.rain
            Fog -> R.drawable.sun_cloud
            HeavyRain -> R.drawable.rain
            else -> R.drawable.moon
        }
    }
}
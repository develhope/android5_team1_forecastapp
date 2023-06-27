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
    fun Int?.getWeatherType(): WeatherType {
        return when (this) {
            0  -> WeatherType.Sun
            1, 2, 3 -> WeatherType.Cloud
            in 45..48 -> WeatherType.Fog
            in 51..77 -> WeatherType.Rain
            80, 81, 82 -> WeatherType.HeavyRain
            in 95..99 -> WeatherType.HeavyRain
            else -> WeatherType.Cloud

        }
    }
}
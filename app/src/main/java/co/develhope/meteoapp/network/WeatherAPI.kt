package co.develhope.meteoapp.network

import co.develhope.meteoapp.network.data.WeatherData
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    @GET("v1/forecast")
    suspend fun getWeatherInfo(
        @Query("latitudine") latitudine : Double,
        @Query("longitudine") longitudine : Double,
        @Query("hourly") hourly : List<String> = listOf(
            "temperature_2m",
            "rain",
            "showers",
            "snowfall",
            "weathercode",
            "windspeed_10m",
            "relativehumidity_2m",
            "cloudcover"
        ),
        @Query("current_weather") current_weather: Boolean = true,
        @Query("timezone") timezone: String = "Europe/Berlin",
    ) : WeatherData
}
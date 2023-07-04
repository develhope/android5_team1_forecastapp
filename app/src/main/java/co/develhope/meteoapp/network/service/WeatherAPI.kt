package co.develhope.meteoapp.network.service

import co.develhope.meteoapp.network.dto.DailySummary
import co.develhope.meteoapp.network.dto.WeeklySummary
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET("v1/forecast")
    suspend fun getDailyWeather(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("hourly") hourly: List<String> = listOf(
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
        @Query("timezone") timezone: String,
    ): Response<DailySummary>

    @GET("v1/forecast")
    suspend fun getWeeklyWeather(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("daily") daily: String,
        @Query("current_weather") currentWeather: Boolean,
        @Query("timezone") timezone: String
    ): WeeklySummary
}

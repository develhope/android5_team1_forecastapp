package co.develhope.meteoapp.network.service

import co.develhope.meteoapp.network.dto.ForecastData
import co.develhope.meteoapp.network.dto.WeeklySummary
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET("v1/forecast?latitude=52.52&longitude=13.41&hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,apparent_temperature,rain,weathercode,cloudcover,windspeed_10m,uv_index,is_day&timezone=auto&start_date=2023-07-10&end_date=2023-07-10")
    suspend fun getDailyWeather(): ForecastData

    @GET("v1/forecast")
    suspend fun getWeeklyWeather(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("daily") daily: String,
        @Query("current_weather") currentWeather: Boolean,
        @Query("timezone") timezone: String
    ): WeeklySummary
}

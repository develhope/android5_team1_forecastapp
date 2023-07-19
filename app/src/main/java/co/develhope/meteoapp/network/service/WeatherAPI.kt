package co.develhope.meteoapp.network.service

import co.develhope.meteoapp.remote.DailySummary
import co.develhope.meteoapp.remote.ForecastData
import co.develhope.meteoapp.remote.WeeklySummary
import org.threeten.bp.LocalDate
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET("forecast?")
    suspend fun getDailyWeather(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("start_date") startDate: LocalDate,
        @Query("end_date") endDate: LocalDate,
        @Query("hourly") hourly: List<String> = listOf(
            "temperature_2m",
            "rain",
            "showers",
            "snowfall",
            "weathercode",
            "windspeed_10m",
            "cloudcover",
            "precipitation_probability",
            "relativehumidity_2m",
            "apparent_temperature",
            ),
        @Query("current_weather") currentWeather: Boolean = true,
        @Query("timezone") timeZone: String = "auto"
    ): Response<DailySummary>

    @GET("forecast?")
    suspend fun getWeeklyWeather(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("daily") daily: String,
        @Query("current_weather") currentWeather: Boolean,
        @Query("timezone") timezone: String
    ): WeeklySummary
}

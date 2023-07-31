package co.develhope.meteoapp.network.service

import co.develhope.meteoapp.network.remote.DailySummary
import co.develhope.meteoapp.network.remote.ForecastData
import co.develhope.meteoapp.network.remote.WeeklySummary
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
        @Query("daily") daily: List<String> = listOf(
            "time",
            "weathercode",
            "temperature_2m_max",
            "temperature_2m_min",
            "rain_sum",
            "windspeed_10m_max"
        ) ,
        @Query("current_weather") currentWeather: Boolean = true,
        @Query("timezone") timezone: String = "auto"
    ): Response<WeeklySummary>
}

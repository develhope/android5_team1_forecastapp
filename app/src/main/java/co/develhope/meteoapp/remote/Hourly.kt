package co.develhope.meteoapp.remote

import co.develhope.meteoapp.network.local.CardSpecificDay
import co.develhope.meteoapp.network.local.HourlySpecificDay
import co.develhope.meteoapp.network.local.getWeatherType
import co.develhope.meteoapp.network.local.HourlyForecast
import com.google.gson.annotations.SerializedName
import org.threeten.bp.OffsetDateTime

data class Hourly(
    @SerializedName("rain")
    val rain: List<Double>,
    @SerializedName("showers")
    val showers: List<Double>,
    @SerializedName("snowfall")
    val snowfall: List<Double>,
    @SerializedName("temperature_2m")
    val temperature2m: List<Double>,
    @SerializedName("time")
    val time: List<OffsetDateTime>,
    @SerializedName("weathercode")
    val weathercode: List<Int>,
    @SerializedName("windspeed_10m")
    val windspeed10m: List<Double>,
    @SerializedName("cloudcover")
    val cloudcover: List<Double>,
    @SerializedName("precipitation_probability")
    val precipitation_probability: List<Double>,
    @SerializedName("relativehumidity_2m")
    val relativehumidity_2m: List<Double>,
    @SerializedName("apparent_temperature")
    val apparent_temperature: List<Double>,
    @SerializedName("winddirection_10m")
    val windDirection: List<Int>,
) {
    fun toDomain(): List<HourlyForecast> {
        return this.time.mapIndexed { index, time ->
            HourlyForecast(
                cardSpecificDay = CardSpecificDay(
                    uvIndex = "5/10",
                    coverage = this.cloudcover.getOrNull(index)?.toInt() ?: 0,
                    windspeed = this.windspeed10m.getOrNull(index)?.toInt() ?: 0,
                    rain = this.rain.getOrNull(index)?.toInt() ?: 0,
                    humidityCard = this.relativehumidity_2m.getOrNull(index)?.toInt() ?: 0,
                    tempPerceived = this.apparent_temperature.getOrNull(index)?.toInt() ?: 0
                ),
                hourlySpecificDay = HourlySpecificDay(
                    time = time,
                    weatherType = this.weathercode.getOrNull(index).getWeatherType(),
                    temp = this.apparent_temperature.getOrNull(index)?.toInt() ?: 0,
                    humidity = this.relativehumidity_2m.getOrNull(index)?.toInt() ?: 0
                )
            )
        }
    }
}
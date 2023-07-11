package co.develhope.meteoapp.network.dto

import co.develhope.meteoapp.today.CardSpecificDay
import co.develhope.meteoapp.today.HourlyForecast
import co.develhope.meteoapp.today.HourlySpecificDay
import com.google.gson.annotations.SerializedName
import co.develhope.meteoapp.today.domain.getWeatherType
import org.threeten.bp.OffsetDateTime

data class Hourly(
    val time: List<String>,
    @SerializedName("temperature_2m") var temperature: List<Double>,
    @SerializedName("relativehumidity_2m") val humidity: List<Int>,
    @SerializedName("dewpoint_2m") val dewPoint: List<Double>,
    @SerializedName("apparent_temperature") val apparentTemperature: List<Double>,
    val rain: List<Double>,
    val weathercode: List<Int>,
    val cloudcover: List<Int>,
    @SerializedName("windspeed_10m") val windspeed10m: List<Double>,
    @SerializedName("uv_index") val uvIndex: List<Double>,
    @SerializedName("is_day") val isDay: List<Int>,
) {

  /*  fun hourlyDomain(): List<HourlyForecast> {
        return this.time.mapIndexed { index, time ->
            HourlyForecast(
                cardSpecificDay = CardSpecificDay(
                    uvIndex = "5/10",
                    coverage = this.cloudcover.getOrNull(index)?.toInt() ?: 0,
                    windspeed = this.windspeed10m.getOrNull(index)?.toInt() ?: 0,
                    rain = this.rain.getOrNull(index)?.toInt() ?: 0,
                    humidityCard = this.humidity.getOrNull(index)?.toInt() ?: 0,
                    tempPerceived = this.temperature.getOrNull(index)?.toInt() ?: 0
                ),
                hourlySpecificDay = HourlySpecificDay(
                    time = time,
                    weatherType = this.weathercode.getOrNull(index).getWeatherType(),
                    temp = this.apparentTemperature.getOrNull(index)?.toInt() ?: 0,
                    humidity = this.dewPoint.getOrNull(index)?.toInt() ?: 0)
            )
        }

    }*/
}
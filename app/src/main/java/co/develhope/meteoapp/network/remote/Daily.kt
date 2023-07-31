package co.develhope.meteoapp.network.remote

import co.develhope.meteoapp.data.local.WeatherSummary
import co.develhope.meteoapp.data.local.getWeatherType
import com.google.gson.annotations.SerializedName
import org.threeten.bp.OffsetDateTime


data class Daily(
    @SerializedName("precipitation_sum")
    val precipitationSum: List<Double>,
    @SerializedName("rain_sum")
    val rainSum: List<Double>,
    val sunrise: List<String>,
    val sunset: List<String>,
    @SerializedName("temperature_2m_max")
    val temperature2mMax: List<Double>,
    @SerializedName("temperature_2m_min")
    val temperature2mMin: List<Double>,
    val time: List<OffsetDateTime>,
    @SerializedName("weathercode")
    val weathercode: List<Int>,
    @SerializedName("windspeed_10m_max")
    val windspeed10mMax : List<Double>,
    val dayWeek: List<String>
) {
    fun toDomain(): List<WeatherSummary> {
        return List(this.time.size) { index ->
            WeatherSummary(
                weatherType = this.weathercode.getOrNull(index).getWeatherType(),
                wind = this.windspeed10mMax.getOrNull(index)?.toInt() ?:0,
                tempMin = this.temperature2mMin.getOrNull(index)?.toInt() ?:0,
                tempMax = this.temperature2mMax.getOrNull(index)?.toInt() ?:0,
                rain = this.rainSum.getOrNull(index)?.toInt() ?:0,
                date = time
            )
        }
    }
}
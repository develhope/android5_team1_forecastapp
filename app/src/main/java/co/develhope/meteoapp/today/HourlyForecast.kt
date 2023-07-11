package co.develhope.meteoapp.today


import co.develhope.meteoapp.today.domain.Place
import co.develhope.meteoapp.today.domain.WeatherType
import org.threeten.bp.OffsetDateTime

sealed class TodayInfo{
    data class Results(val list: List<HourlyForecast>, val place: Place, val time: OffsetDateTime) : TodayInfo()
}


data class HourlyForecast (
    val cardSpecificDay: CardSpecificDay,
    val hourlySpecificDay: HourlySpecificDay
)

data class CardSpecificDay(
    val tempPerceived: Int,
    val humidityCard: Int,
    val coverage: Int,
    val uvIndex: String,
    val windspeed: Int,
    val rain: Int
)

data class HourlySpecificDay(
    val time: OffsetDateTime,
    val weatherType: WeatherType,
    val temp: Int,
    val humidity: Int
)

package co.develhope.meteoapp.network.local


import org.threeten.bp.OffsetDateTime

sealed class TodayInfo{
    data class ResultDayHourly(val hourlyForecast: HourlyForecast) : TodayInfo()
    data class ResultDayTitle(val place: Place, val date: OffsetDateTime) : TodayInfo()
}
data class HourlyForecast (
    val cardSpecificDay: CardSpecificDay,
    val hourlySpecificDay: HourlySpecificDay
)

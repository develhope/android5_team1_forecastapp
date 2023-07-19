package co.develhope.meteoapp.network.local

data class CardSpecificDay(
    val tempPerceived: Int,
    val humidityCard: Int,
    val coverage: Int,
    val uvIndex: String,
    val windspeed: Int,
    val rain: Int
)
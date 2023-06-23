package co.develhope.meteoapp

data class WeatherConditions(
    val hour: String,
    val weather: Int,
    val temperature: String,
    val humidity: String,
    val percepita: String,
    val indice: String,
    val umidita: String,
    val vento: String,
    val copertura: String,
    val pioggia: String,
    var isExpanded: Boolean = false
)

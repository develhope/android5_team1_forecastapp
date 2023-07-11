package co.develhope.meteoapp.today.domain

data class Place(
    val city: String,
    val region: String,
    val lat: Double,
    val log: Double,
)
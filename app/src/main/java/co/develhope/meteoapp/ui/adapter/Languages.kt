package co.develhope.meteoapp.ui.adapter

import java.util.Locale


fun getLocalizedDay(day: String): String {
    val locale = Locale.getDefault()
    return when (locale.language) {
        "it" -> getItaDay(day)
        else -> getEnDay(day)
    }
}

fun getItaDay(day: String): String {
    return when (day) {
        "MONDAY" -> "Lunedì"
        "TUESDAY" -> "Martedì"
        "WEDNESDAY" -> "Mercoledì"
        "THURSDAY" -> "Giovedì"
        "FRIDAY" -> "Venerdì"
        "SATURDAY" -> "Sabato"
        "SUNDAY" -> "Domenica"
        else -> ""
    }
}
fun getEnDay(day: String): String{
    return when(day){
        "MONDAY" -> "Monday"
        "TUESDAY" -> "Tuesday"
        "WEDNESDAY" -> "Wednesday"
        "THURSDAY" -> "Thursday"
        "FRIDAY" -> "Friday"
        "SATURDAY" -> "Saturday"
        "SUNDAY" -> "Sunday"
        else -> ""
    }
}
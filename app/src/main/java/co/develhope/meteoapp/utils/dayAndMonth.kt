package co.develhope.meteoapp.utils

import java.util.*

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

fun getLocalizedMonth(month: String): String {
    val locale = Locale.getDefault()
    return when (locale.language) {
        "it" -> getItaMonth(month)
        else -> getEnMonth(month)
    }
}

fun getItaMonth(month: String): String {
    return when (month) {
        "JANUARY" -> "Gennaio"
        "FEBRUARY" -> "Febbraio"
        "MARCH" -> "Marzo"
        "APRIL" -> "Aprile"
        "MAY" -> "Maggio"
        "JUNE" -> "Giugno"
        "JULY" -> "Luglio"
        "AUGUST" -> "Agosto"
        "SEPTEMBER" -> "Settembre"
        "OCTOBER" -> "Ottobre"
        "NOVEMBER" -> "Novembre"
        "DECEMBER" -> "Dicembre"
        else -> ""
    }
}

fun getEnMonth(month: String): String {
    return when (month) {
        "JANUARY" -> "January"
        "FEBRUARY" -> "February"
        "MARCH" -> "March"
        "APRIL" -> "April"
        "MAY" -> "May"
        "JUNE" -> "June"
        "JULY" -> "July"
        "AUGUST" -> "August"
        "SEPTEMBER" -> "September"
        "OCTOBER" -> "October"
        "NOVEMBER" -> "November"
        "DECEMBER" -> "December"
        else -> ""
    }
}


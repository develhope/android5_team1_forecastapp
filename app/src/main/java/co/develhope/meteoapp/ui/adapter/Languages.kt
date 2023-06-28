package co.develhope.meteoapp.ui.adapter

import android.icu.util.Calendar
import java.util.Locale


fun getLocalizedDay(day: String): String {
    val calendar = Calendar.getInstance()
    return when (calendar.get(Calendar.DAY_OF_WEEK)) {
        Calendar.MONDAY -> {
            when (Locale.getDefault().language) {
                "it" -> "Lunedì"
                else -> "Monday"
            }
        }
        Calendar.TUESDAY -> {
            when (Locale.getDefault().language) {
                "it" -> "Martedì"
                else -> "Tuesday"
            }
        }
        Calendar.WEDNESDAY -> {
            when (Locale.getDefault().language) {
                "it" -> "Mercoledì"
                else -> "Wednesday"
            }
        }
        Calendar.THURSDAY -> {
            when (Locale.getDefault().language) {
                "it" -> "Giovedì"
                else -> "Thursday"
            }
        }
        Calendar.FRIDAY -> {
            when (Locale.getDefault().language) {
                "it" -> "Venerdì"
                else -> "Friday"
            }
        }
        Calendar.SATURDAY -> {
            when (Locale.getDefault().language) {
                "it" -> "Sabato"
                else -> "Saturday"
            }
        }
        Calendar.SUNDAY -> {
            when (Locale.getDefault().language) {
                "it" -> "Domenica"
                else -> "Sunday"
            }
        }
        else -> ""
    }
}
package co.develhope.meteoapp

import android.graphics.drawable.Drawable
import android.widget.ImageView

data class TodayInfo(
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
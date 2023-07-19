package co.develhope.meteoapp.remote

import com.google.gson.annotations.SerializedName

data class DailyUnits(
    @SerializedName("precipitation_sum")
    val precipitationSum: String,
    @SerializedName("rain_sum")
    val rainSum: String,
    val sunrise: String,
    val sunset: String,
    @SerializedName("temperature_2m_max")
    val temperature2mMax: String,
    @SerializedName("temperature_2m_min")
    val temperature2mMin: String,
    val time: String,
    val weathercode: String
)
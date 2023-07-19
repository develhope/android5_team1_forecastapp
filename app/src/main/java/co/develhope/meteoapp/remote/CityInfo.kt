package co.develhope.meteoapp.remote

import co.develhope.meteoapp.network.local.Place
import com.google.gson.annotations.SerializedName

data class CityInfo(
    @SerializedName("generationtime_ms")
    val generationtimeMs: Double,
    @SerializedName("results")
    val results: List<Result>
){
    fun toDomain(): List<Place> {
        return this.results.mapIndexed { index, result ->
            Place(
                city = this.results.getOrNull(index)?.name.toString(),
                region = this.results.getOrNull(index)?.admin1.toString(),
                latitude = this.results.getOrNull(index)?.latitude.toString().toDouble(),
                longitude = this.results.getOrNull(index)?.longitude.toString().toDouble(),
            )
        }
    }
}
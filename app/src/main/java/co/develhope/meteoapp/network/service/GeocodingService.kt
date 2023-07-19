package co.develhope.meteoapp.network.service

import co.develhope.meteoapp.remote.CityInfo
import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodingService {
    @GET("search?")
    suspend fun getCityInfo(
        @Query("name") name : String,
        @Query("language") language: String
    ): CityInfo

}
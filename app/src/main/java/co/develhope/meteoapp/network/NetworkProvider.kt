package co.develhope.meteoapp.network

import co.develhope.meteoapp.network.local.Place
import co.develhope.meteoapp.network.service.GeocodingService
import co.develhope.meteoapp.network.service.WeatherAPI
import co.develhope.meteoapp.network.local.HourlyForecast
import co.develhope.meteoapp.network.local.WeatherSummary
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.threeten.bp.OffsetDateTime
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkProvider {
    private val BASE_URL = "https://api.open-meteo.com/v1/"
    private val BASE_GEOCODING_URL = "https://geocoding-api.open-meteo.com/v1/"
    private val interceptor = HttpLoggingInterceptor()

    init {
        interceptor.level = HttpLoggingInterceptor.Level.BODY
    }

    //geocoding istance
    private val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .build()

    private val gson = GsonBuilder()
        .registerTypeAdapter(OffsetDateTime::class.java, OffsetDateTimeTypeAdapter())
        .create()

    private val retrofitWeather = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(client)
        .build()

    private val retrofitGeocoding = Retrofit.Builder()
        .baseUrl(BASE_GEOCODING_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(client)
        .build()

    val weatherAPI: WeatherAPI = retrofitWeather.create(WeatherAPI::class.java)
    val geocodingService: GeocodingService = retrofitGeocoding.create(GeocodingService::class.java)

    suspend fun getDailySummary(
        latitude: Double,
        longitude: Double,
        start_Date: OffsetDateTime,
        end_Date: OffsetDateTime
    ): List<HourlyForecast> {
        return weatherAPI.getDailyWeather(
            latitude = latitude,
            longitude = longitude,
            startDate = start_Date.toLocalDate(),
            endDate = end_Date.toLocalDate()
        ).body()?.hourly?.toDomain() ?: emptyList()
    }
    suspend fun getPlace(place: String, language: String): List<Place> {
        return geocodingService.getCityInfo(
            name = place,
            language = language
        ).toDomain()
    }
}
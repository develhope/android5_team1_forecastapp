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
    private val okhttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()


    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okhttpClient)
        .build()

    val api: WeatherAPI = retrofit.create(WeatherAPI::class.java)

     //geocoding istance

    private val retrofitGeocoding = provideGeocodingRetrofit(
        client = provideOkHttpClient(provideHttpLoggingInterceptor()),
        gson = provideGson()
    )
    private val retrofitWeather = provideWeatherRetrofit(
        client = provideOkHttpClient(provideHttpLoggingInterceptor()),
        gson = provideGson()
    )
    private fun provideWeatherRetrofit(
        client: OkHttpClient,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }

    private fun provideGeocodingRetrofit(
        client: OkHttpClient,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_GEOCODING_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }
    private fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {

        return OkHttpClient.Builder()
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()
    }
    private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }
    private fun provideGeocodingService(): GeocodingService {
        return retrofitGeocoding.create(GeocodingService::class.java)
    }
    private fun provideWeatherService(): WeatherAPI {
        return retrofitWeather.create(WeatherAPI::class.java)
    }
    private fun provideGson(): Gson = GsonBuilder()
        .registerTypeAdapter(OffsetDateTime::class.java, OffsetDateTimeTypeAdapter())
        .create()
    suspend fun getDailySummary(
        latitude: Double,
        longitude: Double,
        start_Date: OffsetDateTime,
        end_Date: OffsetDateTime
    ): List<HourlyForecast> {
        return provideWeatherService().getDailyWeather(
            latitude = latitude,
            longitude = longitude,
            startDate = start_Date.toLocalDate(),
            endDate = end_Date.toLocalDate()
        ).body()?.hourly?.toDomain() ?: emptyList()
    }
    suspend fun getPlace(place: String, language: String): List<Place> {
        return provideGeocodingService().getCityInfo(
            name = place,
            language = language
        ).toDomain()
    }
}
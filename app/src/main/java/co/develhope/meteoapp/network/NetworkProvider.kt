package co.develhope.meteoapp.network

import co.develhope.meteoapp.network.service.WeatherAPI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.open-meteo.com/"
class NetworkProvider {
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

}
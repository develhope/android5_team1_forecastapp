package co.develhope.meteoapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.develhope.meteoapp.network.WeatherAPI
import co.develhope.meteoapp.network.data.WeatherData
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.threeten.bp.OffsetDateTime
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.open-meteo.com/"
class HomeScreenViewModel : ViewModel() {

    private var weatherApi : WeatherAPI
        get() {
            TODO()
        }
    private val _weatherLiveData = MutableLiveData<WeatherData>()
    val weatherLiveData : LiveData<WeatherData> = _weatherLiveData

    private fun provideGson(): Gson = GsonBuilder()
        .registerTypeAdapter(OffsetDateTime::class.java, OffsetDateTimeTypeAdapter())
        .create()

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(provideGson()))
            .build()

        weatherApi = retrofit.create(WeatherAPI::class.java)
    }

    private fun weatherProvider() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val weatherInfo = weatherApi.getWeeklyWeather(


                )




            } catch (e : Exception) {

            }
        }
    }
}
package co.develhope.meteoapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.develhope.meteoapp.network.WeatherAPI
import co.develhope.meteoapp.network.WeatherForecast
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeScreenViewModel : ViewModel() {

    private val livedata = MutableLiveData<String>()
    private val BASE_URL = "https://api.open-meteo.com/"
    private val api : WeatherAPI

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(WeatherAPI::class.java)
    }

    private fun weatherFetch() {
        viewModelScope.launch {
            try {
                val response = api.getWeatherInfo()
                val city = response.timezone



            } catch (e : Exception) {

            }
        }
    }
}
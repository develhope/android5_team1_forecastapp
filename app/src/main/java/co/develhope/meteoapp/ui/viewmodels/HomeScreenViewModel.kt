package co.develhope.meteoapp.ui.viewmodels

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.develhope.meteoapp.network.NetworkProvider
import co.develhope.meteoapp.network.dto.WeeklySummary
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel() {

    private val networkProvider = NetworkProvider()
    private val weatherAPI = networkProvider.api

    private val _weeklyWeatherData = MutableLiveData<WeeklySummary>()
    val weeklyWeatherData : MutableLiveData<WeeklySummary> = _weeklyWeatherData


    fun getWeeklyWeather(latitude : Double, longitude : Double, timezone: String){
        viewModelScope.launch {
            try{
                val response = weatherAPI.getWeeklyWeather(latitude,longitude, "temperature_2m_max,temperature_2m_min,rain_sum,windspeed_10m_max,weathercode", false, timezone)
                _weeklyWeatherData.postValue(response)
            }catch (e: Exception){

            }

        }
    }
}
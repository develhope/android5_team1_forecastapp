package co.develhope.meteoapp.today

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.develhope.meteoapp.network.NetworkProvider
import co.develhope.meteoapp.network.dto.ForecastData
import co.develhope.meteoapp.today.domain.Place
import kotlinx.coroutines.launch
import org.threeten.bp.OffsetDateTime


class TodayScreenViewModel : ViewModel() {
    private val api = NetworkProvider().api
    private val _dailyWeatherLiveData = MutableLiveData<ForecastData>()
    val dailyWeatherLiveData : LiveData<ForecastData> = _dailyWeatherLiveData

    fun getTodayWeather() {
        viewModelScope.launch {
            try {
                    val response = api.getDailyWeather()
                    _dailyWeatherLiveData.postValue(response)
                } catch (e: Exception) {
                Log.d("ciao2", "$e")
            }
        }
    }
}


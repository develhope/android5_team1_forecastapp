package co.develhope.meteoapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.develhope.meteoapp.MyApplicationMeteo
import co.develhope.meteoapp.data.local.Place
import co.develhope.meteoapp.data.local.WeatherSummary
import co.develhope.meteoapp.network.NetworkProvider
import kotlinx.coroutines.launch
import org.threeten.bp.OffsetDateTime

data class WeeklyResult(val list: List<WeatherSummary>, val place: Place)

class HomeScreenViewModel : ViewModel() {

    private val _weeklyWeatherData = MutableLiveData<WeeklyResult>()
    val weeklyWeatherData : LiveData<WeeklyResult> = _weeklyWeatherData


    fun getWeeklyWeather(){
        viewModelScope.launch {
            try{
                val place = MyApplicationMeteo.preferences?.getPrefPlace()
                if (place != null) {
                    val weeklyForecast = NetworkProvider().getWeeklySummary(
                        place.latitude,
                        place.longitude
                    )
                _weeklyWeatherData.value = WeeklyResult(weeklyForecast, place)
                }
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}
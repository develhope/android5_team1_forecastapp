package co.develhope.meteoapp.ui.tomorrow

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.develhope.meteoapp.MyApplicationMeteo
import co.develhope.meteoapp.network.NetworkProvider
import co.develhope.meteoapp.network.local.HourlyForecast
import co.develhope.meteoapp.network.local.Place
import co.develhope.meteoapp.remote.ForecastData
import kotlinx.coroutines.launch
import org.threeten.bp.OffsetDateTime

sealed class TomorrowResult() {
    data class Result(val list: List<HourlyForecast>, val place: Place, val date: OffsetDateTime) :
        TomorrowResult()
}

class TomorrowScreenViewModel : ViewModel() {

    private val api = NetworkProvider().weatherAPI
    private val _tomorrowWeatherLiveData = MutableLiveData<TomorrowResult>()
    val tomorrowWeatherLiveData : LiveData<TomorrowResult> = _tomorrowWeatherLiveData

    fun getTomorrowWeather() {
        viewModelScope.launch {
            try {
                val place = MyApplicationMeteo.preferences?.getPrefPlace()
                val date = OffsetDateTime.now().plusDays(1)
                if (place != null && date != null) {
                    val tomorrowForecast = NetworkProvider().getDailySummary(
                        place.latitude,
                        place.longitude,
                        date,
                        date
                    )
                    _tomorrowWeatherLiveData.value = TomorrowResult.Result(tomorrowForecast, place, date)
                }

            } catch (e : Exception) {
                e.printStackTrace()
            }
        }
    }
}
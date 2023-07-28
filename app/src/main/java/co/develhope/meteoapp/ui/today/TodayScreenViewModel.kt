package co.develhope.meteoapp.ui.today

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.develhope.meteoapp.MyApplicationMeteo
import co.develhope.meteoapp.network.NetworkProvider
import co.develhope.meteoapp.network.local.Place
import co.develhope.meteoapp.network.local.HourlyForecast
import kotlinx.coroutines.launch
import org.threeten.bp.OffsetDateTime

sealed class TodayResult() {
    data class Result(val list: List<HourlyForecast>, val place: Place, val date: OffsetDateTime) :
        TodayResult()
}
class TodayScreenViewModel : ViewModel() {
    private val api = NetworkProvider().weatherAPI
    private val _todayResult = MutableLiveData<TodayResult>()
    val todayResult: LiveData<TodayResult> = _todayResult


    fun getTodayWeather() {
        viewModelScope.launch {
            try {
                val place = MyApplicationMeteo.preferences?.getPrefPlace()
                val date = OffsetDateTime.now()
                if (place != null && date != null) {
                    val todayHourlyForecast = NetworkProvider().getDailySummary(
                        place.latitude,
                        place.longitude,
                        date,
                        date
                    )
                    _todayResult.value = TodayResult.Result(todayHourlyForecast, place, date)

                }
            }catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}



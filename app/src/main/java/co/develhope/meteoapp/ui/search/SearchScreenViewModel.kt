package co.develhope.meteoapp.ui.search


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.develhope.meteoapp.MyApplicationMeteo
import co.develhope.meteoapp.network.NetworkProvider
import co.develhope.meteoapp.data.local.Place
import kotlinx.coroutines.launch

class SearchScreenViewModel : ViewModel() {

    private val cityListLiveData = MutableLiveData<List<Place>>()
    val _cityListLiveData : LiveData<List<Place>> = cityListLiveData

    fun searchCity (city: String) {
        viewModelScope.launch {
            try {
                val place = NetworkProvider().getPlace(city, "it")
                cityListLiveData.postValue(place)
            } catch (e:Exception) {
                e.printStackTrace()
            }
        }
    }
    fun onCityClicked(item: Place) {
        MyApplicationMeteo.preferences?.savePrefPlace(item)
        Log.d("pref-place", "${MyApplicationMeteo.preferences?.getPrefPlace()}")
//        if (MyApplicationMeteo.recentSearchesList.size >= 10) MyApplicationMeteo.recentSearchesList.removeLast()
//        if (!MyApplicationMeteo.recentSearchesList.contains(item)) {
//            MyApplicationMeteo.recentSearchesList.add(item)
//        } else {
//            MyApplicationMeteo.recentSearchesList.remove(item)
//            MyApplicationMeteo.recentSearchesList.add(item)
//        }

    }
}
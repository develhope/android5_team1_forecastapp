package co.develhope.meteoapp.ui.search


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.develhope.meteoapp.MyApplicationMeteo
import co.develhope.meteoapp.network.NetworkProvider
import co.develhope.meteoapp.network.local.Place
import kotlinx.coroutines.launch

class SearchScreenViewModel : ViewModel() {

    val cityListLiveData = MutableLiveData<List<Place>>()
    val _cityListLiveData : LiveData<List<Place>> = cityListLiveData
    var recentSearches = MyApplicationMeteo.recentSearchesList

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
}
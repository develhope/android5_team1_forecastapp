package co.develhope.meteoapp.ui.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.develhope.meteoapp.network.NetworkProvider
import co.develhope.meteoapp.network.dto.CityList
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class SearchScreenViewModel : ViewModel() {

    private val networkProvider = NetworkProvider()
    private val geocodingApi = networkProvider.geoApi

    private val searchCityFlow = MutableSharedFlow<CityList>()

    fun getCities(city: String) {
        viewModelScope.launch {
            val city = geocodingApi.getGeolocalization(city)
            searchCityFlow.emit(city)
        }
    }
}
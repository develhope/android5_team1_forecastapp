package co.develhope.meteoapp.ui.search

import co.develhope.meteoapp.data.local.Place

sealed class SearchInput(){

    data class CardClick(val place: Place) : SearchInput()

}
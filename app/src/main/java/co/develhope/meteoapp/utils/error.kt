package co.develhope.meteoapp.utils

import android.annotation.SuppressLint
import android.view.View
import androidx.navigation.Navigation.findNavController
import co.develhope.meteoapp.R

fun error(view: View) {
    findNavController(view).navigate(R.id.errorScreen)
}
package co.develhope.meteoapp.network.service.geopermission

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.provider.Settings
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.startActivity
import co.develhope.meteoapp.MyApplicationMeteo
import co.develhope.meteoapp.data.local.Place
import com.google.android.gms.common.internal.StringResourceValueReader
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.util.Locale

const val PERMISSION_REQUEST_ACCESS_LOCATION = 100

object Geolocalization {

    fun getCurrentPosition(context: Context) {
        val fusedLocationProvideClient: FusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(context)

        if(checkPermission(context)) {
            if(isLocationEnabled(context)) {
                if(ActivityCompat.checkSelfPermission(
                        context,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                        context,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    return
                }
                fusedLocationProvideClient.lastLocation.addOnCompleteListener() {
                    val location: Location? = it.result
                    if(location != null) {
                        Toast.makeText(context, "Localizzazione avvenuta con successo", Toast.LENGTH_LONG).show()
                        val place = Place(
                            latitude = location.latitude,
                            longitude = location.longitude,
                            city = getCity(lat = location.latitude, log = location.longitude, context = context),
                            region = getCountry(lat = location.longitude, log = location.longitude, context = context)
                        )
                        MyApplicationMeteo.preferences?.savePrefPlace(place)
                    }
                }
            } else {
                Toast.makeText(context, "Attiva la Geolocalizzazione", Toast.LENGTH_SHORT).show()
                val input = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(context, input, null)
            }
        } else {
            requestPermission(context, PERMISSION_REQUEST_ACCESS_LOCATION)
        }
    }
    private fun requestPermission(context: Context, permission: Int) {
        ActivityCompat.requestPermissions(
            context as Activity, arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            ), permission
        )
    }

    private fun getCity(context: Context, lat: Double, log: Double): String {
        val city: String
        val geocoding = Geocoder(context, Locale.getDefault())
        val address = geocoding.getFromLocation(lat, log, 1)
        city = address?.get(0)?.locality ?: ""
        return city

    }

    private fun getCountry(context: Context, lat: Double, log: Double): String {
        val country: String
        val geocoding = Geocoder(context, Locale.getDefault())
        val address = geocoding.getFromLocation(lat, log, 1)
        country = address?.get(0)?.countryName ?: "-"
        return country
    }

    private fun checkPermission(context: Context): Boolean {
        return ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }
    private fun isLocationEnabled(context: Context): Boolean {
        val locationManager: LocationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER
        )
    }
}
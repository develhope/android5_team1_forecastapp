package co.develhope.meteoapp.network.service.geopermission

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import co.develhope.meteoapp.data.local.Place
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

const val PERMISSION_REQUEST_ACCESS_LOCATION = 100

object Geolocalization {

    private fun getCurrentPosition(context: Context) {
        var fusedLocationProvideClient: FusedLocationProviderClient =
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
                            city = getCity()
                        )
                    }
                }

            }
        }
    }

    private fun getCity(): String {

    }

    private fun checkPermission(context: Context): Boolean {
        return ActivityCompat.checkSelfPermission(
            context,
            android.Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
            context,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }
    private fun isLocationEnabled(context: Context): Boolean {
        val locationManager: LocationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER
        )
    }
}
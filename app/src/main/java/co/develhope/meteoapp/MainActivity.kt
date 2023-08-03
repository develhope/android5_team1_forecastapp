package co.develhope.meteoapp


import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import co.develhope.meteoapp.databinding.ActivityMainBinding
import co.develhope.meteoapp.network.service.geopermission.Geolocalization
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getGeolocalization()

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeScreen,
                R.id.todayScreen,
                R.id.tomorrowScreen,
                R.id.searchScreen
            )
        )
        binding.bottomNavigationMenu.setupWithNavController(navController)
        binding.bottomNavigationMenu.setOnItemReselectedListener {

        }

    }
    private fun getGeolocalization() {
        if (isGooglePlayServicesAvailable()) {
            try {
                Geolocalization.getCurrentPosition(this)

            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {
            Log.d(
                "MainActivity", "Error"
            )
        }
    }
    private fun isGooglePlayServicesAvailable(): Boolean {
        val apiAvailability = GoogleApiAvailability.getInstance()
        val resultCode = apiAvailability.isGooglePlayServicesAvailable(this)
        return resultCode == ConnectionResult.SUCCESS
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
    fun showBottomNavigation(view: Boolean) {
        if (view) {
            binding.bottomNavigationMenu.visibility = View.VISIBLE
        } else {
            binding.bottomNavigationMenu.visibility = View.GONE
        }
    }

}

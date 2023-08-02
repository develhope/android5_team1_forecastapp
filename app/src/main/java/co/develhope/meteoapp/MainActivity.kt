package co.develhope.meteoapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import co.develhope.meteoapp.databinding.ActivityMainBinding
import co.develhope.meteoapp.network.service.geopermission.Geolocalization
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bottomNavView = binding.bottomNavigationMenu
        Geolocalization.getCurrentPosition(this)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        bottomNavView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.homeScreenNavigation -> {
                    navController.navigate(R.id.homeScreen)
                }
                R.id.todayScreenNavigation -> {
                    navController.navigate(R.id.todayScreen)
                }
                R.id.tomorrowScreenNavigation -> {
                    navController.navigate(R.id.tomorrowScreen)
                }
                R.id.searchScreenNavigation -> {
                    navController.navigate(R.id.searchScreen)
                }
            }
            return@setOnItemSelectedListener true
        }
    }
}
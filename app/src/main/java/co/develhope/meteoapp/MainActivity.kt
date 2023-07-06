package co.develhope.meteoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import co.develhope.meteoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit  var binding : ActivityMainBinding
    private lateinit var bottomNavView : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bottomNavView = binding.bottomNavigationMenu


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        bottomNavView.setOnItemSelectedListener {
            when(it.itemId) {
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
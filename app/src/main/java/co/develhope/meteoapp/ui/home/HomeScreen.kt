package co.develhope.meteoapp.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.local.Place
import co.develhope.meteoapp.data.local.WeatherSummary
import co.develhope.meteoapp.databinding.HomeScreenBinding
import co.develhope.meteoapp.network.remote.WeeklySummary
import co.develhope.meteoapp.ui.today.TodayResult
import org.threeten.bp.OffsetDateTime


class HomeScreen : Fragment() {
    private lateinit var binding : HomeScreenBinding
    private var viewModel = HomeScreenViewModel()
    private lateinit var adapter : HomeScreenAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeScreenBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[HomeScreenViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getWeeklyWeather()
        getMeteo()
        getNext5Days()
    }

    fun getNext5Days(){
        Log.d("fun-next5days","function called")
        viewModel.weeklyWeatherData.observe(viewLifecycleOwner) {
            when (it) {
                is WeeklyResult -> {
                    Log.d("fun-next5days","viewmodel call")
                    binding.homeList.layoutManager = LinearLayoutManager(context)
                    adapter = HomeScreenAdapter(it)
                    binding.homeList.adapter = adapter

                }
            }
        }
    }
    fun getMeteo() {
        viewModel.weeklyWeatherData.observe(viewLifecycleOwner) {
            when (it) {
                is WeeklyResult -> {
                    binding.cityName.text = it.place.city.plus(", ").plus(it.place.region)
                    binding.homeScreenTempMin.text = it.list[0].tempMin.toString().plus("°")
                    binding.homeScreenTempMax.text = it.list[0].tempMax.toString().plus("°")
                    binding.homeScreenRainSum.text = it.list[0].rain.toString().plus("mm")
                    binding.homeScreenWindSpeed.text = it.list[0].wind.toString().plus("km/h")
                    binding.weathercodeIcon.setImageResource(it.list[0].weatherType.imageWeatherType())
                    binding.homeScreenDate.text =
                        it.list[0].date.dayOfMonth.toString().plus("/").plus(it.list[0].date.month.value.toString())
                }
            }
        }
    }
}
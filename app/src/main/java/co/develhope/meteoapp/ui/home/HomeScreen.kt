package co.develhope.meteoapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.HomeScreenBinding
import co.develhope.meteoapp.network.remote.WeeklySummary


class HomeScreen : Fragment() {
    private lateinit var binding : HomeScreenBinding
    private lateinit var viewModel : HomeScreenViewModel
    private lateinit var adapter : HomeScreenAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

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



        viewModel.weeklyWeatherData.observe(viewLifecycleOwner){
            getNext5Days(it)
            getMeteo(it)
        }





    }
    fun getNext5Days(item : WeeklySummary){
        binding.homeList.layoutManager = LinearLayoutManager(context)
        binding.homeList.adapter = HomeScreenAdapter(item)
    }
    fun getMeteo(item : WeeklySummary){
        val tempMin = item.daily.temperature2mMin
        binding.homeScreenTempMin.text = tempMin[0].toInt().toString().plus("°")
        val tempMax = item.daily.temperature2mMax
        binding.homeScreenTempMax.text = tempMax[0].toInt().toString().plus("°")
        val windSpeed = item.daily.windspeed10mMax
        binding.homeScreenWindSpeed.text = windSpeed[0].toString().plus("km/h")
        val rainSum = item.daily.rainSum
        binding.homeScreenRainSum.text = rainSum[0].toString().plus("mm")
        val weatherCondition = item.daily.weathercode
        when (weatherCondition[0]){
            0 -> binding.weathercodeIcon.setImageResource(R.drawable.sun)
            1,2,3 -> binding.weathercodeIcon.setImageResource(R.drawable.sun_cloud)
            else -> binding.weathercodeIcon.setImageResource(R.drawable.rain)
        }
        val date = item.daily.time[0]
        binding.homeScreenDate.text = date.drop(8).plus("/").plus(date.drop(5).dropLast(3))
    }
}
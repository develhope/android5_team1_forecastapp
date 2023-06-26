package co.develhope.meteoapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.network.WeatherForecast
import co.develhope.meteoapp.databinding.HomeScreenBinding
import co.develhope.meteoapp.ui.adapter.HomeScreenAdapter
import kotlinx.coroutines.launch


class HomeScreen : Fragment() {
    private lateinit var binding: HomeScreenBinding
    private lateinit var adapter : HomeScreenAdapter
    private val api = WeatherForecast.api


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

        lifecycleScope.launch {

            val response = api.getWeatherInfo()
            binding.temperatureMin.text = response.body()?.daily?.temperature_2m_min.toString()
        }


        binding.recyclerHomeView.layoutManager = LinearLayoutManager(context)
        adapter = HomeScreenAdapter()
        binding.recyclerHomeView.adapter = adapter




        return binding.root
    }
}
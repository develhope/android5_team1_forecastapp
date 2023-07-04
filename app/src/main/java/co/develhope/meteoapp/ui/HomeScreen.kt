package co.develhope.meteoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import co.develhope.meteoapp.databinding.HomeScreenBinding
import co.develhope.meteoapp.network.NetworkProvider
import kotlinx.coroutines.launch


class HomeScreen : Fragment() {
    private lateinit var binding : HomeScreenBinding

    private var weatherApi = NetworkProvider()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = HomeScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
                val response = weatherApi.api
                val temp = response.getWeeklyWeather(38.13, 13.34, "temperature_2m_min", false, "GMT")
                binding.homeScreenTempMin.text = temp.daily.temperature2mMin[0].toString()
        }

//        binding.homeList.layoutManager = LinearLayoutManager(context)
//        binding.homeList.adapter = HomeScreenAdapter(weatherInfoList)
    }
}
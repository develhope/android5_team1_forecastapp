package co.develhope.meteoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.databinding.HomeScreenBinding

class HomeScreen : Fragment() {
    private lateinit  var binding : HomeScreenBinding


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

        val weatherInfoList = listOf(
            WeatherInfoItem("Giorno 1" ),
            WeatherInfoItem("Giorno 2" ),
            WeatherInfoItem("Giorno 3" ),
            WeatherInfoItem("Giorno 4" ),
            WeatherInfoItem("Giorno 5" )
        )
        binding.homeList.layoutManager = LinearLayoutManager(context)
        binding.homeList.adapter = HomeScreenAdapter(weatherInfoList)

    }


}
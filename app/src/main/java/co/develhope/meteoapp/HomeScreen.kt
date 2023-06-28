package co.develhope.meteoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.databinding.HomeScreenBinding



class HomeScreen : Fragment() {
    private lateinit var binding : HomeScreenBinding
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

        val weatherInfoList = listOf(
            WeatherInfoItem("Domani", "29/06", "23°","32°", "11km", "0mm" ),
            WeatherInfoItem("Venerdì", "30/06", "23°", "31°", "8km","0mm" ),
            WeatherInfoItem("Sabato", "01/07","20°", "29°", "7km", "0mm" ),
            WeatherInfoItem("Domenica", "02/07", "21°", "30°", "12km", "0mm"),
            WeatherInfoItem("Lunedì", "03/07", "19°", "26°","14km", "0mm" )
        )
        binding.homeList.layoutManager = LinearLayoutManager(context)
        binding.homeList.adapter = HomeScreenAdapter(weatherInfoList)
    }
}
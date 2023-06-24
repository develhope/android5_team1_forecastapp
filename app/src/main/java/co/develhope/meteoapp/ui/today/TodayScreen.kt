package co.develhope.meteoapp.ui.today

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.R
import co.develhope.meteoapp.TodayInfoAdapter
import co.develhope.meteoapp.data.WeatherConditions
import co.develhope.meteoapp.databinding.TodayScreenBinding


class TodayScreen : Fragment() {
    private lateinit var binding: TodayScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TodayScreenBinding.inflate(inflater, container, false)
        val todayInfoList : ArrayList<WeatherConditions> = arrayListOf(
            WeatherConditions("11:00",
                R.drawable.sun_image,"24°","33%","45°","5/10","23%","SSE 7km/h","30%","0cm"),
            WeatherConditions("12:00",
                R.drawable.sun_image,"26°","13%","55°","5/10","13%","SSE 7km/h","30%","0cm"),
            WeatherConditions("13:00",
                R.drawable.sun_image,"27°","13%","50°","5/10","23%","SSE 7km/h","30%","0cm"),
            WeatherConditions("14:00",
                R.drawable.sun_image,"25°","16%","50°","5/10","33%","SSE 7km/h","30%","0cm"),
            WeatherConditions("15:00",
                R.drawable.sun_image,"26°","17%","47°","5/10","13%","SSE 7km/h","30%","0cm"),
            WeatherConditions("16:00",
                R.drawable.sun_image,"24°","15%","45°","5/10","12%","SSE 7km/h","30%","0cm"),
            WeatherConditions("17:00",
                R.drawable.sun_image,"23°","13%","43°","5/10","25%","SSE 7km/h","30%","0cm"),
            WeatherConditions("18:00",
                R.drawable.sun_image,"28°","33%","42°","5/10","hHo","SSE 7km/h","30%","0cm"),
            WeatherConditions("19:00",
                R.drawable.sun_image,"30°","22%","43°","5/10","12%","SSE 7km/h","30%","0cm"),
            WeatherConditions("20:00",
                R.drawable.sun_image,"34°","13%","39°","5/10","15%","SSE 7km/h","30%","0cm"),
            WeatherConditions("21:00",
                R.drawable.sun_image,"33°","17%","28°","5/10","16%","SSE 7km/h","30%","0cm"),
            WeatherConditions("22:00",
                R.drawable.sun_image,"37°","19%","68°","5/10","17%","SSE 7km/h","30%","0cm"),
            WeatherConditions("23:00",
                R.drawable.sun_image,"36°","10%","47°","5/10","18%","SSE 7km/h","30%","0cm"),
            WeatherConditions("00:00",
                R.drawable.sun_image,"35°","18%","45°","5/10","20%","SSE 7km/h","30%","0cm")

        )
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = TodayInfoAdapter(todayInfoList)


        return binding.root
    }
}
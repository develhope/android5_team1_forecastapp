package co.develhope.meteoapp.today

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.databinding.TodayScreenBinding
import co.develhope.meteoapp.network.dto.ForecastData


class TodayScreen : Fragment() {
    private lateinit var binding: TodayScreenBinding
    private var viewModel = TodayScreenViewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TodayScreenBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[TodayScreenViewModel::class.java]

        viewModel.getTodayWeather()

        viewModel.dailyWeatherLiveData.observe(viewLifecycleOwner) {
            getHourlyInfo(it)
        }
    }
    private fun getHourlyInfo(item: ForecastData) {
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = TodayInfoAdapter(item)
    }
}
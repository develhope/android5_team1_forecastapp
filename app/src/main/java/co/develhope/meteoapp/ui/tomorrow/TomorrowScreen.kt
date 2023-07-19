package co.develhope.meteoapp.ui.tomorrow

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.databinding.TodayScreenBinding
import co.develhope.meteoapp.databinding.TomorrowScreenBinding
import co.develhope.meteoapp.network.local.HourlyForecast
import co.develhope.meteoapp.network.local.Place
import co.develhope.meteoapp.network.local.TodayInfo
import co.develhope.meteoapp.remote.ForecastData
import co.develhope.meteoapp.ui.today.TodayTomorrowInfoAdapter
import org.threeten.bp.OffsetDateTime

class TomorrowScreen : Fragment() {

    private lateinit var binding: TodayScreenBinding
    private lateinit var viewModel: TomorrowScreenViewModel
    private lateinit var adapter: TodayTomorrowInfoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TodayScreenBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[TomorrowScreenViewModel::class.java]

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)
        adapter = TodayTomorrowInfoAdapter(emptyList())
        binding.recyclerView.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        viewModel.getTomorrowWeather()
        val tomorrowDateString = "tomorrow"
        tomorrowWeather(tomorrowDateString)
    }

    private fun tomorrowWeather(date : String) {
        viewModel.tomorrowWeatherLiveData.observe(viewLifecycleOwner) {
            when(it) {
                is TomorrowResult.Result -> {
                    val specificDayItems =
                        createListToShowSpecificDay(it.list,it.place, selectDate(date))
                    adapter = TodayTomorrowInfoAdapter(specificDayItems)
                    binding.recyclerView.adapter = adapter
                }
            }
        }

    }
    private fun createListToShowSpecificDay(
        list: List<HourlyForecast>,
        place: Place,
        date: OffsetDateTime

    ): List<TodayInfo> {
        val returnList = mutableListOf<TodayInfo>()

        returnList.add(TodayInfo.ResultDayTitle(place, date))
        val hours: List<TodayInfo.ResultDayHourly> = list.map {
            TodayInfo.ResultDayHourly(it)
        }
        returnList.addAll(hours)

        return returnList
    }
    private fun selectDate(date: String): OffsetDateTime {
        return if (date == "tomorrow") {
            OffsetDateTime.now().plusDays(1)
        } else {
            OffsetDateTime.parse(date)
        }
    }
}

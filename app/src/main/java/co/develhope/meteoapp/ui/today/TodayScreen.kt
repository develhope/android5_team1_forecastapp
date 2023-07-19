package co.develhope.meteoapp.ui.today

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.databinding.TodayScreenBinding
import co.develhope.meteoapp.network.local.HourlyForecast
import co.develhope.meteoapp.network.local.Place
import co.develhope.meteoapp.network.local.TodayInfo
import co.develhope.meteoapp.remote.ForecastData
import org.threeten.bp.OffsetDateTime


class TodayScreen : Fragment() {

    private lateinit var binding: TodayScreenBinding
    private var viewModel = TodayScreenViewModel()
    private lateinit var adapter: TodayTomorrowInfoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TodayScreenBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[TodayScreenViewModel::class.java]

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)
        adapter = TodayTomorrowInfoAdapter(emptyList())
        binding.recyclerView.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        viewModel.getTodayWeather()
        getHourlyInfo()
    }


    private fun getHourlyInfo() {
        viewModel.todayResult.observe(viewLifecycleOwner) {
            when (it) {
                is TodayResult.Result -> {
                    val filteredList = it.list.filter { hourlyForecast ->
                        hourlyForecast.hourlySpecificDay.time.isAfter(OffsetDateTime.now())
                    }

                    val specificDayItems =
                        createListToShowSpecificDay(filteredList, it.place, it.date)
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
}

package co.develhope.meteoapp.ui.today

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.MainActivity
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.TodayScreenBinding
import co.develhope.meteoapp.data.local.HourlyForecast
import co.develhope.meteoapp.data.local.Place
import co.develhope.meteoapp.data.local.TodayInfo
import co.develhope.meteoapp.network.remote.ForecastData
import kotlinx.coroutines.launch
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
        val window = activity?.window
        if (window != null) {
            (activity as MainActivity).showBottomNavigation(true)
            window.statusBarColor = context?.getColor(R.color.app_background) ?: 0

        }

        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)
        adapter = TodayTomorrowInfoAdapter(emptyList())
        binding.recyclerView.adapter = adapter
        getHourlyInfo()
        viewModel.getTodayWeather()
    }

    override fun onStart() {
        super.onStart()
    }


    private fun getHourlyInfo() {
        lifecycleScope.launch {
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

                    is TodayResult.Error -> view?.let {it1 -> co.develhope.meteoapp.utils.error(it1) }
                }
            }
        }
    }
    private fun createListToShowSpecificDay(
        list: List<HourlyForecast>,
        place: Place,
        date: OffsetDateTime
    ): List<TodayInfo> {
        return mutableListOf<TodayInfo>().apply {
            add(TodayInfo.ResultDayTitle(place, date))
            addAll(list.map { TodayInfo.ResultDayHourly(it) })
        }
    }
}

package co.develhope.meteoapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.network.WeatherForecast
import co.develhope.meteoapp.databinding.HomeScreenBinding
import co.develhope.meteoapp.network.data.WeeklySummary
import co.develhope.meteoapp.ui.adapter.HomeScreenAdapter
import co.develhope.meteoapp.viewmodel.HomeScreenViewModel
import kotlinx.coroutines.launch


class HomeScreen : Fragment() {
    private lateinit var binding: HomeScreenBinding
    private lateinit var viewModel: HomeScreenViewModel
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
    ): View {
        binding = HomeScreenBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[HomeScreenViewModel::class.java]


        return binding.root
    }

    fun OnViewCreated(view : View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        lifecycleScope.launch() {
            val temperatures :

            binding.recyclerHomeView.layoutManager = LinearLayoutManager(context)
           binding.recyclerHomeView.adapter = HomeScreenAdapter(temperatures)

        }

    }
}
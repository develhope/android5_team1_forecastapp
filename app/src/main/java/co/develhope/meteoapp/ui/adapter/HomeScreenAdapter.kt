package co.develhope.meteoapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.databinding.WeatherInfoHomeBinding
import co.develhope.meteoapp.network.data.WeeklySummary

class HomeScreenAdapter(private val items: WeeklySummary) : RecyclerView.Adapter<HomeScreenAdapter.ViewHolder>() {

    inner class ViewHolder(private var binding : WeatherInfoHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : WeeklySummary, position: Int) {

        /*    val currentPosition = position +1
           val date = item.daily.time
           val temperatureMin = item.daily.temperature2mMin
           val temperatureMax = item.daily.windspeed10mMax
           val precip = item.daily.precipitationSum
           val windSpeed = item.daily.windspeed10mMax*/

            val currentPosition = position +1
            val temperature = item.daily.temperature2mMin[currentPosition]
            binding.tempmin.text = temperature.toString()


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            WeatherInfoHomeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    override fun getItemCount() : Int = 1

     override fun onBindViewHolder(holder : ViewHolder, position: Int) {
         holder.bind(items[position])

     }
}



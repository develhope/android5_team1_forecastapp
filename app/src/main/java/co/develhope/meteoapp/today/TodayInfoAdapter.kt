package co.develhope.meteoapp.today

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import co.develhope.meteoapp.databinding.ItemTodayScreenBinding
import co.develhope.meteoapp.network.dto.ForecastData

class TodayInfoAdapter(private val todayInfo : ForecastData) : RecyclerView.Adapter<TodayInfoAdapter.HourlyInfoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyInfoViewHolder {
        return HourlyInfoViewHolder(
            ItemTodayScreenBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: HourlyInfoViewHolder, position: Int) {
        holder.bind(todayInfo, position)
    }

    override fun getItemCount(): Int = 24

    inner class HourlyInfoViewHolder(private val binding: ItemTodayScreenBinding) :
        ViewHolder(binding.root) {
        fun bind(hourlyInfo: ForecastData, position: Int) {
            binding.temperatureToday.text =
                hourlyInfo.hourly.temperature[position].toInt().toString()
            binding.pioggia.text = hourlyInfo.hourly.dewPoint[position].toInt().toString()
            binding.percepitaTextView.text =
                hourlyInfo.hourly.apparentTemperature[position].toInt().toString()
            binding.indiceTextView.text = hourlyInfo.hourly.uvIndex[position].toString()
            binding.humidityPercentage.text =
                hourlyInfo.hourly.humidity[position].toInt().toString()
            binding.ventoTextView.text = hourlyInfo.hourly.windspeed10m[position].toString()
            binding.coperturaTextView.text = hourlyInfo.hourly.cloudcover[position].toString()
            binding.pioggiaTextView.text = hourlyInfo.hourly.rain[position].toInt().toString()

            binding.hourlyInfoBar.setOnClickListener {
                if (binding.cardView.visibility == View.GONE) {
                    binding.cardView.visibility = View.VISIBLE
                    binding.arrow.rotation = 360F

                } else {
                    binding.cardView.visibility = View.GONE
                    binding.arrow.rotation = 180F
                }
            }
        }
    }
}


/* binding.linearLayout.setOnClickListener {
                val expanded = hourlyInfo.isExpanded
                hourlyInfo.isExpanded = !expanded
            }*/


/*val isExpandable = hourlyInfo.isExpanded
            binding.cardView.visibility = if (isExpandable) View.VISIBLE else View.GONE
            binding.bottomLine.visibility = if (isExpandable) View.GONE else View.VISIBLE

            binding.linearLayout.setOnClickListener {
                val expanded = hourlyInfo.isExpanded
                hourlyInfo.isExpanded = !expanded

            }*/



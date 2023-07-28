package co.develhope.meteoapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.WeatherInfoHomeBinding
import co.develhope.meteoapp.remote.WeeklySummary
import org.threeten.bp.DayOfWeek
import org.threeten.bp.LocalDate
import org.threeten.bp.format.TextStyle
import java.util.Locale

class HomeScreenAdapter(val list: WeeklySummary) : RecyclerView.Adapter<HomeScreenAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: WeatherInfoHomeBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(item: WeeklySummary, position: Int){
            binding.weatherInfoTempMin.text = item.daily.temperature2mMin[position + 1].toInt().toString().plus("°")
            binding.weatherInfoTempMax.text = item.daily.temperature2mMax[position + 1].toInt().toString().plus("°")
            binding.weatherInfoWindSpeed.text = item.daily.windspeed10mMax[position + 1].toString().plus("Km/h")
            binding.weatherInfoRain.text = item.daily.rainSum[position + 1].toString().plus("mm")
            when (item.daily.weathercode[position + 1]){
                0 -> binding.weatherInfoIcon.setImageResource(R.drawable.sun)
                1,2,3 -> binding.weatherInfoIcon.setImageResource(R.drawable.sun_cloud)
                else -> binding.weatherInfoIcon.setImageResource(R.drawable.rain)
            }
            binding.weatherInfoDate.text = item.daily.time[position + 1].drop(8).plus("/").plus(item.daily.time[position + 1].drop(5).dropLast(3))
            if(position + 1 == 1){
                binding.weatherInfoWeekday.setText(R.string.tomorrow)
            } else binding.weatherInfoWeekday.text = DayOfWeek.from(LocalDate.parse(item.daily.time[position + 1])).getDisplayName(TextStyle.FULL, Locale.ITALY).replaceFirstChar { it.uppercase() }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(WeatherInfoHomeBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int = 5

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list, position)
    }
}
package co.develhope.meteoapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.data.local.WeatherSummary
import co.develhope.meteoapp.data.local.WeatherType
import co.develhope.meteoapp.databinding.WeatherInfoHomeBinding
import co.develhope.meteoapp.network.remote.WeeklySummary
import org.threeten.bp.DayOfWeek
import org.threeten.bp.LocalDate
import org.threeten.bp.format.TextStyle
import java.util.Locale

class HomeScreenAdapter(val list: WeeklyResult) : RecyclerView.Adapter<HomeScreenAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: WeatherInfoHomeBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(item: WeeklyResult, position: Int){
            binding.weatherInfoTempMin.text = item.list[position + 1].tempMin.toString().plus("°")
            binding.weatherInfoTempMax.text = item.list[position + 1].tempMax.toString().plus("°")
            binding.weatherInfoWindSpeed.text = item.list[position + 1].wind.toString().plus("km/h")
            binding.weatherInfoRain.text = item.list[position + 1].rain.toString().plus("mm")
            binding.weatherInfoIcon.setImageResource(item.list[position + 1].weatherType.imageWeatherType())
            binding.weatherInfoDate.text = item.list[position + 1].date.dayOfMonth.toString().plus("/").plus(item.list[position + 1].date.monthValue.toString())
            if(position == 0) { binding.weatherInfoWeekday.text = itemView.context.getString(R.string.Domani)
            } else binding.weatherInfoWeekday.text = item.list[position + 1].date.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ITALY).replaceFirstChar { it.uppercase() }
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
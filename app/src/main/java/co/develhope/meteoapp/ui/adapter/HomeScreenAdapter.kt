package co.develhope.meteoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.databinding.WeatherInfoHomeBinding

class HomeScreenAdapter(val list: List<WeatherInfoItem>) : RecyclerView.Adapter<HomeScreenAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: WeatherInfoHomeBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(item: WeatherInfoItem){
            binding.weatherInfoWeekday.text = item.weekday
            binding.weatherInfoDate.text = item.date
            binding.weatherInfoTempMin.text = item.min_temp
            binding.weatherInfoTempMax.text = item.max_temp
            binding.weatherInfoWindSpeed.text = item.wind_speed
            binding.weatherInfoRain.text = item.rain
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(WeatherInfoHomeBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }
}
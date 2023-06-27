package co.develhope.meteoapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.network.data.WeatherData
import co.develhope.meteoapp.databinding.WeatherInfoHomeBinding

class HomeScreenAdapter(private val items : WeatherData) : RecyclerView.Adapter<HomeScreenAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: WeatherInfoHomeBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(item: WeatherData, position: Int) {
            val temperatureMax = item.daily.temperature2mMax[position]
            val temperatureMin = item.daily.temperature2mMin[position]

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(WeatherInfoHomeBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(items[position])
    }
}
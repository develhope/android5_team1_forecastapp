package co.develhope.meteoapp.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.network.data.WeatherData
import co.develhope.meteoapp.databinding.WeatherInfoHomeBinding

class HomeScreenAdapter(private val dataset: List<HomeScreenItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            CARD -> CardViewHolder(
                WeatherInfoHomeBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            else -> throw java.lang.IllegalArgumentException("error")
        }
    }
    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun getItemViewType(position: Int) : Int {
        return when (dataset[position]) {
            is HomeScreenItem.CardItem -> CARD
            is HomeScreenItem.Title -> CURRENTCITY
            is HomeScreenItem.Subtitle -> NEXTFIVEDAY
        }
    }

     override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CardViewHolder -> holder.bind(dataset[position] as HomeScreenItem.CardItem)
        }
    }

    class CardViewHolder(private val binding: WeatherInfoHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(cardItem: HomeScreenItem.CardItem) {
            binding.day.text = itemView.context.getString(
                R.string.oggi,
                getLocalizedDay(cardItem.dailyForecast.date.dayOfWeek.name)
            )
            binding.data.text = itemView.context.getString(
                R.string.data,
                cardItem.dailyForecast.date.dayOfMonth.toString(),
                cardItem.dailyForecast.date.month.value.toString()
            )
            binding.tempmin.text = itemView.context.getString(
                R.string.tempmin,
                cardItem.dailyForecast.tempMin.toString()
            )
            binding.tempmax.text = itemView.context.getString(
                R.string.tempmax,
                cardItem.dailyForecast.tempMax.toString()
            )
            binding.kmh.text =
                itemView.context.getString(R.string.kmh, cardItem.dailyForecast.wind.toString())
            binding.umidity.text =
                itemView.context.getString(R.string.rain, cardItem.dailyForecast.rain.toString())
            binding.imageHome.setImageResource(cardItem.dailyForecast.weatherType.setIconWeatherType())

// add a method with setOnClickListener
        }
    }

    companion object {
        const val CARD = 0
        const val CURRENTCITY = 1
        const val NEXTFIVEDAY = 2
    }
}


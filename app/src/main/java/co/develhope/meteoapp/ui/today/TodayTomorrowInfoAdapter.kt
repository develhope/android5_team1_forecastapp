package co.develhope.meteoapp.ui.today


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.ItemTodayScreenBinding
import co.develhope.meteoapp.databinding.SpecificDayBinding
import co.develhope.meteoapp.network.local.TodayInfo
import co.develhope.meteoapp.utils.getLocalizedDay
import co.develhope.meteoapp.utils.getLocalizedMonth

class TodayTomorrowInfoAdapter(private val todayInfo : List<TodayInfo>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemViewType(position: Int): Int {
        return when (todayInfo[position]) {
            is TodayInfo.ResultDayTitle -> TITLE
            is TodayInfo.ResultDayHourly -> HOURLY
        }
    }
    class TitleViewHolder(private val binding: SpecificDayBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(info: TodayInfo.ResultDayTitle) {
            binding.specificDay.text = itemView.context.getString(
                R.string.city_region,
                info.place.city,
                info.place.region
            )
            binding.dateSpecificDay.text = itemView.context.getString(
                R.string.today_details, getLocalizedDay(
                    info.date.dayOfWeek.name
                ),
                info.date.dayOfMonth.toString(),
                getLocalizedMonth(info.date.month.name)
            )

        }
    }
class HourlyInfoViewHolder(private val binding: ItemTodayScreenBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(hourlyInfo: TodayInfo.ResultDayHourly) {
        val specificHourlyInfo = hourlyInfo.hourlyForecast.hourlySpecificDay
        val specificHourlyCardInfo = hourlyInfo.hourlyForecast.cardSpecificDay

        binding.hourTextView.text= itemView.context.getString(
            R.string.time,
            specificHourlyInfo.time.hour.toString()
        )
        binding.weatherImageView.setImageResource( specificHourlyInfo.weatherType.imageWeatherType())

        binding.temperatureToday.text = itemView.context.getString(
            R.string.temp,
            specificHourlyInfo.temp.toString()
        )
        binding.humidityPercentage.text = itemView.context.getString(
            R.string.umidity,
            specificHourlyInfo.humidity.toString()
        )
        binding.percepitaTextView.text = itemView.context.getString(
            R.string.percepitaCard,
            specificHourlyCardInfo.tempPerceived.toString()
        )
        binding.indiceTextView.text = itemView.context.getString(
            R.string.uvCard,
            specificHourlyCardInfo.uvIndex
        )

        binding.humidityTextView.text = itemView.context.getString(
            R.string.umiditaCard,
            specificHourlyCardInfo.humidityCard.toString()
        )
        binding.coperturaTextView.text = itemView.context.getString(
            R.string.coperturaCard,
            specificHourlyCardInfo.coverage.toString()
        )
        binding.pioggiaTextView.text = itemView.context.getString(
            R.string.pioggiaCard,
            specificHourlyCardInfo.rain.toString()
        )
        binding.ventoTextView.text = itemView.context.getString(
            R.string.ventoCard,
            specificHourlyCardInfo.windspeed.toString()
        )

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
    companion object {
        const val TITLE = 0
        const val HOURLY = 1
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TITLE -> {
                TitleViewHolder(
                    SpecificDayBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            HOURLY -> {
                HourlyInfoViewHolder(
                    ItemTodayScreenBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            else ->throw java.lang.IllegalArgumentException("errore")
        }
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is HourlyInfoViewHolder -> holder.bind(todayInfo[position] as TodayInfo.ResultDayHourly)
            is TitleViewHolder -> holder.bind(todayInfo[position] as TodayInfo.ResultDayTitle)
        }
    }

    override fun getItemCount(): Int {
        return todayInfo.size
    }
}







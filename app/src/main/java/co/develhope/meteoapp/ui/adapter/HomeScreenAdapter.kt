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


        }
    }
    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun getItemViewType(position: Int) : Int {
        return when (dataset[position]) {


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



// add a method with setOnClickListener
        }
    }

}


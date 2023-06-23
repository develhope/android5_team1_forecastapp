package co.develhope.meteoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class TodayInfoAdapter(private val todayInfo: ArrayList<TodayInfo>) : RecyclerView.Adapter<TodayInfoAdapter.TodayInfoViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayInfoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_today_screen, parent, false)

        return TodayInfoViewHolder(itemView)

        }

    override fun getItemCount(): Int = todayInfo.size

    override fun onBindViewHolder(holder: TodayInfoViewHolder, position: Int) {
        val item = todayInfo[position]
        holder.bind(item){
            isAnyItemExpanded(position)
            item.isExpanded = !item.isExpanded
            notifyItemChanged(position, Unit)
        }
    }




    private fun isAnyItemExpanded(position: Int){
        val temp = todayInfo.indexOfFirst {
            it.isExpanded
        }
        if (temp >= 0 && temp != position){
            todayInfo[temp].isExpanded = false
            notifyItemChanged(temp,0)
        }
    }

    override fun onBindViewHolder(
        holder: TodayInfoViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isNotEmpty() && payloads[0] == 0){
            holder.expandableCardView.visibility = View.GONE
        }else {
            super.onBindViewHolder(holder, position, payloads)
        }
    }

    inner class TodayInfoViewHolder(itemView : View):ViewHolder(itemView){

        val expandableCardView: CardView = itemView.findViewById<CardView>(R.id.cardView)
        fun bind(todayInfo: TodayInfo, clickListener : (TodayInfo) -> Unit) {
            val hourTextView = itemView.findViewById<TextView>(R.id.hourTextView)
            val weatherImageView = itemView.findViewById<ImageView>(R.id.weatherImageView)
            val temperatureTextView = itemView.findViewById<TextView>(R.id.temperatureTextView)
            val humidityTextView = itemView.findViewById<TextView>(R.id.humidityTextView)
            val bottomLine = itemView.findViewById<ImageView>(R.id.bottomLine)
            val linearLayout = itemView.findViewById<LinearLayout>(R.id.linearLayout)
            val percepitaTextView = itemView.findViewById<TextView>(R.id.percepitaTextView)
            val indiceTextView = itemView.findViewById<TextView>(R.id.indiceTextView)
            val percentualeUmiTextView = itemView.findViewById<TextView>(R.id.percentualeUmiTextView)
            val ventoTextView = itemView.findViewById<TextView>(R.id.ventoTextView)
            val coperturaTextView = itemView.findViewById<TextView>(R.id.coperturaTextView)
            val pioggiaTextView = itemView.findViewById<TextView>(R.id.pioggiaTextView)
            hourTextView.text = todayInfo.hour
            weatherImageView.setImageResource(todayInfo.weather)
            temperatureTextView.text = todayInfo.temperature
            humidityTextView.text = todayInfo.humidity

            val isExpandable = todayInfo.isExpanded
            expandableCardView.visibility = if (isExpandable) View.VISIBLE else View.GONE
            bottomLine.visibility = if (isExpandable) View.GONE else View.VISIBLE

            percepitaTextView.text = todayInfo.percepita
            indiceTextView.text = todayInfo.indice
            percentualeUmiTextView.text = todayInfo.umidita
            ventoTextView.text = todayInfo.vento
            coperturaTextView.text = todayInfo.copertura
            pioggiaTextView.text = todayInfo.pioggia

            linearLayout.setOnClickListener {
            clickListener(todayInfo)
            }


        }



    }

    class HeaderViewHolder(itemView: View) :ViewHolder(itemView){
        val homeScreenFirstPart = itemView.findViewById<LinearLayout>(R.id.home_screen_first_part)
    }
}

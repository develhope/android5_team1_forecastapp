package co.develhope.meteoapp.ui.search

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.MyApplicationMeteo
import co.develhope.meteoapp.databinding.SearchScreenItemBinding
import co.develhope.meteoapp.network.local.Place


class SearchScreenAdapter(private var list: List<Place>) : RecyclerView.Adapter<SearchScreenAdapter.ViewHolder>() {

    inner class ViewHolder(private var binding: SearchScreenItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(item: Place){
            binding.searchItemCity.text = item.city.plus(",").plus(item.region)

        }

        fun saveCity(item: Place){
            binding.searchItem.setOnClickListener{
                MyApplicationMeteo.preferences?.savePrefPlace(item)
                Log.d("pref-place","${MyApplicationMeteo.preferences?.getPrefPlace()}")
                if(MyApplicationMeteo.recentSearchesList.size >= 10) MyApplicationMeteo.recentSearchesList.removeLast()
                if(!MyApplicationMeteo.recentSearchesList.contains(item)){
                    MyApplicationMeteo.recentSearchesList.add(item)
                } else {MyApplicationMeteo.recentSearchesList.remove(item)
                    MyApplicationMeteo.recentSearchesList.add(item)}
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(SearchScreenItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
        holder.saveCity(list[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<Place>) {
        this.list = list
        notifyDataSetChanged()
    }
}
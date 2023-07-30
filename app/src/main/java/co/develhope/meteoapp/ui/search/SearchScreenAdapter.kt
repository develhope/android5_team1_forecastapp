package co.develhope.meteoapp.ui.search

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.MyApplicationMeteo
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.SearchScreenItemBinding
import co.develhope.meteoapp.network.local.Place
import co.develhope.meteoapp.ui.home.HomeScreen


class SearchScreenAdapter(private var list: List<Place>) : RecyclerView.Adapter<SearchScreenAdapter.ViewHolder>() {

    inner class ViewHolder(private var binding: SearchScreenItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(item: Place){
            binding.searchItemCity.text = item.city.plus(",").plus(item.region)
            binding.searchItem.setOnClickListener{
                SearchScreenViewModel().onCityClicked(item)
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
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<Place>) {
        this.list = list
        notifyDataSetChanged()
    }
}
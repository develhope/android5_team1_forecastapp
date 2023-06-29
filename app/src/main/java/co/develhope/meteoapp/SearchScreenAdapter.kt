package co.develhope.meteoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.databinding.SearchScreenBinding
import co.develhope.meteoapp.databinding.SearchScreenItemBinding


class SearchScreenAdapter(private var list: List<String>) : RecyclerView.Adapter<SearchScreenAdapter.ViewHolder>() {

    inner class ViewHolder(private var binding: SearchScreenItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(item: String){
            binding.prova.text = item

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
}
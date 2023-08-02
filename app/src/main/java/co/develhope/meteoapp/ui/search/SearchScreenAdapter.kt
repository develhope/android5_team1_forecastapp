package co.develhope.meteoapp.ui.search

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.RecyclerView
import co.develhope.meteoapp.MyApplicationMeteo
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.SearchScreenItemBinding
import co.develhope.meteoapp.data.local.Place
import co.develhope.meteoapp.ui.home.HomeScreen
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarItemView


class SearchScreenAdapter(private var list: List<Place>) : RecyclerView.Adapter<SearchScreenAdapter.ViewHolder>() {

    inner class ViewHolder(private var binding: SearchScreenItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(item: Place){
            binding.searchItemCity.text = item.city.plus(",").plus(item.region)
            binding.searchItem.setOnClickListener{
                  MyApplicationMeteo.preferences?.saveRecentSearch(item)
                SearchScreenViewModel().onCityClicked(item)
                it.findNavController().navigate(R.id.action_search_screen_to_home_screen)
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
//        holder.itemView.setOnClickListener{ view ->
//            view.findNavController().navigate(R.id.action_fromAdapter_searchScreen_to_homeScreen)
//        }


//             fun onClick (view : View ){
//                val activity = view.context as AppCompatActivity
//                 val searchFragment = SearchScreen()
//                 activity.supportFragmentManager.beginTransaction().replace(R.id.activity_main, searchFragment).addToBackStack(null).commit()
//            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
//    fun updateList(list: List<Place>) {
//        this.list = list
//        notifyDataSetChanged()
//    }

    fun goHome() {
        findNavController(SearchScreen()).navigate(R.id.action_search_screen_to_home_screen)
    }

package co.develhope.meteoapp.ui.search

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import co.develhope.meteoapp.MyApplicationMeteo
import co.develhope.meteoapp.databinding.SearchScreenBinding


class SearchScreen : Fragment() {
    private lateinit var binding: SearchScreenBinding
    private lateinit var viewModel : SearchScreenViewModel
    private lateinit var adapter: SearchScreenAdapter
    var recentSearches = MyApplicationMeteo.preferences?.getRecentSearch()!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = SearchScreenBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recentSearches = recentSearches

        viewModel = ViewModelProvider(this)[SearchScreenViewModel::class.java]

        adapter = SearchScreenAdapter(recentSearches)
        binding.cityList.layoutManager = LinearLayoutManager(context)
        binding.cityList.adapter = adapter

        viewModel._cityListLiveData.observe(viewLifecycleOwner){
            Log.d("livedata","$it")
            adapter.updateList(it)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d("Change","$newText")
                if(newText != null && newText.length >= 2 ) {viewModel.searchCity(newText)
                } else {Log.d("rec-searchers","Testing else")
                adapter.updateList(MyApplicationMeteo.recentSearchesList.asReversed())
                MyApplicationMeteo.preferences!!.saveRecentSearch(MyApplicationMeteo.recentSearchesList)}
                return true
            }
        })
    }
}
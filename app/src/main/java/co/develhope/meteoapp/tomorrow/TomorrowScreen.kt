package co.develhope.meteoapp.tomorrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.develhope.meteoapp.databinding.TomorrowScreenBinding

class TomorrowScreen : Fragment() {

    class TomorrowScreen : Fragment() {
        private lateinit var binding: TomorrowScreenBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            arguments?.let {
            }
        }

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            binding = TomorrowScreenBinding.inflate(inflater, container, false)

            return binding.root
        }
    }
}
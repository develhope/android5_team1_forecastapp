package co.develhope.meteoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.develhope.meteoapp.databinding.ErrorScreenBinding


class ErrorScreen: Fragment() {

private lateinit var binding : ErrorScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ErrorScreenBinding.inflate(inflater, container, false)
        return binding.root
    }
}
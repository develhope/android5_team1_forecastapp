package co.develhope.meteoapp.ui.error

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import co.develhope.meteoapp.MainActivity
import co.develhope.meteoapp.R
import co.develhope.meteoapp.databinding.ErrorScreenBinding


class ErrorScreen: Fragment() {

    private lateinit var binding: ErrorScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ErrorScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val screen = activity?.window
        if (screen != null) {
            (activity as MainActivity).showBottomNavigation(false)
            screen.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
            screen.statusBarColor = context?.getColor(R.color.app_background)!!

        }
        binding.retryButton.setOnClickListener {
            findNavController().popBackStack()
        }
        /* if (!isInternetConnected()) {

            binding.errorImage.visibility = View.VISIBLE
            binding.errorMessage.visibility = View.VISIBLE
            binding.retryButton.visibility = View.VISIBLE
        } else {

            binding.errorImage.visibility = View.GONE
            binding.errorMessage.visibility = View.GONE
            binding.retryButton.visibility = View.GONE
        }
    }*/
        /*private fun isInternetConnected(): Boolean {
        val connectivityManager =
            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
        return connectivityManager?.activeNetworkInfo?.isConnectedOrConnecting ?: false
    }*/
    }
}
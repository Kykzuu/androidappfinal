package dev.kykzuu.laby7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson

class MainFragment : Fragment() {

    private val gson = Gson()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false) // twój layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.buttonWroclaw).setOnClickListener {
            fetchAndNavigate("https://api.gios.gov.pl/pjp-api/rest/aqindex/getIndex/129")
        }

        view.findViewById<Button>(R.id.buttonKrakow).setOnClickListener {
            fetchAndNavigate("https://api.gios.gov.pl/pjp-api/rest/aqindex/getIndex/400")
        }

        view.findViewById<Button>(R.id.buttonWarszawa).setOnClickListener {
            fetchAndNavigate("https://api.gios.gov.pl/pjp-api/rest/aqindex/getIndex/550")
        }

        view.findViewById<Button>(R.id.buttonAutor).setOnClickListener {
            Toast.makeText(requireContext(), "Autor: Jakub Kawa", Toast.LENGTH_SHORT).show()
        }
    }

    private fun fetchAndNavigate(url: String) {
        ApiClient.fetchAirQualityData(url) { dataItem ->
            activity?.runOnUiThread {
                if (dataItem != null) {
                    val jsonString = gson.toJson(dataItem)
                    val bundle = Bundle().apply {
                        putString("airQualityData", jsonString)
                    }
                    findNavController().navigate(
                        R.id.action_mainFragment_to_airQualityFragment,
                        bundle
                    )
                } else {
                    Toast.makeText(requireContext(), "Brak danych lub błąd pobierania", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

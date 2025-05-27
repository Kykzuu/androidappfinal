package dev.kykzuu.laby7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson

class AirQualityFragment : Fragment() {

    private val gson = Gson()
    private var airQualityItem: AirQualityItem? = null  // zapisujemy dla użycia w onClick

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_air_quality, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val jsonString = arguments?.getString("airQualityData")

        if (jsonString != null) {
            airQualityItem = gson.fromJson(jsonString, AirQualityItem::class.java)
            populateData(view, airQualityItem!!)
        } else {
            // Brak danych - wracamy do poprzedniego fragmentu
            requireActivity().onBackPressed()
        }

        view.findViewById<Button>(R.id.buttonBack).setOnClickListener {
            requireActivity().onBackPressed()
        }



    }

    private fun populateData(view: View, item: AirQualityItem) {
        view.findViewById<TextView>(R.id.textViewId).text = "ID: ${item.id}"
        view.findViewById<TextView>(R.id.textViewStCalcDate).text = "Data pomiaru (stCalcDate): ${item.stCalcDate}"
        view.findViewById<TextView>(R.id.textViewStIndexLevel).text = "Stan jakości powietrza: ${item.stIndexLevel?.indexLevelName ?: "brak danych"}"
        view.findViewById<TextView>(R.id.textViewNo2IndexLevel).text = "NO2 poziom: ${item.no2IndexLevel?.indexLevelName ?: "brak danych"}"
        view.findViewById<TextView>(R.id.textViewPm25IndexLevel).text = "PM2.5 poziom: ${item.pm25IndexLevel?.indexLevelName ?: "brak danych"}"
        view.findViewById<TextView>(R.id.textViewStIndexStatus).text = "Status indeksu: ${if (item.stIndexStatus == true) "OK" else "Nie OK"}"
    }
}

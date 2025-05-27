package dev.kykzuu.laby7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class StationDetailsFragment : Fragment() {

    companion object {
        private const val ARG_STATION_ID = "station_id"

        fun newInstance(stationId: Int): StationDetailsFragment {
            val fragment = StationDetailsFragment()
            val args = Bundle()
            args.putInt(ARG_STATION_ID, stationId)
            fragment.arguments = args
            return fragment
        }
    }

    private var stationId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        stationId = arguments?.getInt(ARG_STATION_ID) ?: 0
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_station_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fetchStationDetails()
    }

    private fun fetchStationDetails() {
        val url = "https://api.gios.gov.pl/pjp-api/v1/rest/station/sensors/$stationId"
        StationApiClient.fetchStationData(url) { stationData ->
            activity?.runOnUiThread {
                if (stationData != null) {
                    displayStationDetails(stationData)
                } else {
                    Toast.makeText(requireContext(), "Błąd pobierania danych", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun displayStationDetails(stationData: AirQualityStation) {
        val textView = view?.findViewById<TextView>(R.id.textViewStationDetails)
        val details = stationData.sensorsList?.joinToString(separator = "\n\n") { sensor ->
            "Id stanowiska: ${sensor.sensorId}\n" +
                    "Id stacji: ${sensor.stationId}\n" +
                    "Wskaźnik: ${sensor.indicator}\n" +
                    "Wzór: ${sensor.indicatorFormula}\n" +
                    "Kod: ${sensor.indicatorCode}\n" +
                    "Id wskaźnika: ${sensor.indicatorId}"
        } ?: "Brak danych o sensorach"

        textView?.text = details
    }
}

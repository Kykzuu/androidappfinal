package dev.kykzuu.laby7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.openapitools.client.apis.ItemsApi
import org.openapitools.client.models.ItemsUrlNameOrdersGet200Response
import org.openapitools.client.models.ItemsUrlNameOrdersGet200ResponsePayloadOrdersInner
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val selectedItem = arguments?.getString("selectedItem")
        val urlName = arguments?.getString("url_name")

        val textView = view.findViewById<TextView>(R.id.textViewSelectedItem)
        textView.text = "Wybrano: ${selectedItem ?: "Brak danych"}"

        if (urlName == null) {
            Toast.makeText(requireContext(), "Brak url_name!", Toast.LENGTH_SHORT).show()
            return
        }

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .add(OffsetDateTimeAdapter())  // Jeśli masz ten adapter, jeśli nie to usuń tę linię
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.warframe.market/v1/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        val apiService = retrofit.create(ItemsApi::class.java)

        val call: Call<ItemsUrlNameOrdersGet200Response> = apiService.itemsUrlNameOrdersGet(
            urlName = urlName
        )

        call.enqueue(object : Callback<ItemsUrlNameOrdersGet200Response> {
            override fun onResponse(
                call: Call<ItemsUrlNameOrdersGet200Response>,
                response: Response<ItemsUrlNameOrdersGet200Response>
            ) {
                if (response.isSuccessful) {
                    val orders: List<ItemsUrlNameOrdersGet200ResponsePayloadOrdersInner>? =
                        response.body()?.payload?.orders

                    if (orders.isNullOrEmpty()) {
                        textView.text = "${textView.text}\n\nBrak dostępnych ofert."
                        return
                    }

                    // Oferty sprzedaży (sell), posortowane rosnąco po cenie
                    val sellOrders = orders
                        .filter { it.platinum != null && it.orderType == ItemsUrlNameOrdersGet200ResponsePayloadOrdersInner.OrderType.sell }
                        .sortedBy { it.platinum }

                    // Oferty kupna (buy), posortowane malejąco po cenie
                    val buyOrders = orders
                        .filter { it.platinum != null && it.orderType == ItemsUrlNameOrdersGet200ResponsePayloadOrdersInner.OrderType.buy }
                        .sortedByDescending { it.platinum }

                    val displayText = buildString {
                        append("\n\nNajtańsze oferty sprzedaży:\n")
                        if (sellOrders.isEmpty()) {
                            append("Brak ofert sprzedaży.\n")
                        } else {
                            sellOrders.take(5).forEach { order ->
                                append("- ${order.user?.ingameName ?: "Anon"}: ${order.platinum} plat\n")
                            }
                        }

                        append("\nNajwyższe oferty kupna:\n")
                        if (buyOrders.isEmpty()) {
                            append("Brak ofert kupna.\n")
                        } else {
                            buyOrders.take(5).forEach { order ->
                                append("- ${order.user?.ingameName ?: "Anon"}: ${order.platinum} plat\n")
                            }
                        }
                    }

                    textView.text = "${textView.text}$displayText"
                } else {
                    textView.text = "${textView.text}\n\nBłąd HTTP: ${response.code()}"
                }
            }

            override fun onFailure(call: Call<ItemsUrlNameOrdersGet200Response>, t: Throwable) {
                textView.text = "${textView.text}\n\nBłąd: ${t.message}"
                t.printStackTrace()
            }
        })
    }
}

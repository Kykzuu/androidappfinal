package dev.kykzuu.laby7.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dev.kykzuu.laby7.R
import org.openapitools.client.apis.ItemsApi
import org.openapitools.client.models.ItemsGet200Response
import org.openapitools.client.models.ItemShort
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainFragment : Fragment() {

    private lateinit var autoCompleteTextView: AutoCompleteTextView
    private lateinit var itemNamesAdapter: ArrayAdapter<String>
    private val itemNamesList = mutableListOf<String>()
    private val itemsMap = mutableMapOf<String, ItemShort>() // itemName -> ItemShort

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        autoCompleteTextView = view.findViewById(R.id.autoCompleteTextView)

        itemNamesAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_dropdown_item_1line,
            itemNamesList
        )
        autoCompleteTextView.setAdapter(itemNamesAdapter)

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.warframe.market/v1/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        val apiService = retrofit.create(ItemsApi::class.java)
        val call: Call<ItemsGet200Response> =
            apiService.itemsGet(language = ItemsApi.LanguageItemsGet.en)

        call.enqueue(object : Callback<ItemsGet200Response> {
            override fun onResponse(
                call: Call<ItemsGet200Response>,
                response: Response<ItemsGet200Response>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()
                    data?.payload?.items?.let { items ->
                        itemNamesList.clear()
                        itemsMap.clear()
                        items.forEach { item ->
                            val name = item.itemName
                            if (name != null) {
                                itemNamesList.add(name)
                                itemsMap[name] = item
                            }
                        }
                        activity?.runOnUiThread {
                            itemNamesAdapter.notifyDataSetChanged()
                        }
                    }
                } else {
                    println("Error HTTP ${response.code()}")
                }
            }

            override fun onFailure(call: Call<ItemsGet200Response>, t: Throwable) {
                t.printStackTrace()
            }
        })

        autoCompleteTextView.setOnItemClickListener { parent, _, position, _ ->
            val selectedItem = parent.getItemAtPosition(position) as String
            val item = itemsMap[selectedItem]
            if (item != null) {
                val bundle = Bundle().apply {
                    putString("selectedItem", selectedItem)
                    putString("url_name", item.urlName)
                    putString("thumb", item.thumb) // <- przekazujemy miniaturkę
                }
                findNavController().navigate(R.id.action_mainFragment_to_detailsFragment, bundle)
            } else {
                Toast.makeText(
                    requireContext(),
                    "Nie znaleziono danych dla: $selectedItem",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        arguments?.getString("selectedItem")?.let { selectedItem ->
            Toast.makeText(
                requireContext(),
                "Wybrano: $selectedItem",
                Toast.LENGTH_SHORT
            ).show()
        }

        view.findViewById<Button>(R.id.buttonAutor).setOnClickListener {
            Toast.makeText(requireContext(), "Autor: Jakub Kawa", Toast.LENGTH_SHORT).show()
        }
    }
}

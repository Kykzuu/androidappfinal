package dev.kykzuu.laby7

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
import com.google.gson.Gson
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.openapitools.client.apis.ItemsApi
import org.openapitools.client.models.ItemsGet200Response
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainFragment : Fragment() {

    private val gson = Gson()
    private lateinit var autoCompleteTextView: AutoCompleteTextView
    private lateinit var itemNamesAdapter: ArrayAdapter<String>
    private val itemNamesList = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        autoCompleteTextView = view.findViewById(R.id.autoCompleteTextView)

        // Adapter do AutoCompleteTextView (na razie pusty)
        itemNamesAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, itemNamesList)
        autoCompleteTextView.setAdapter(itemNamesAdapter)

        // Budujemy Moshi z KotlinJsonAdapterFactory
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        // Retrofit z Moshi
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.warframe.market/v1/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        val apiService = retrofit.create(ItemsApi::class.java)

        val call: Call<ItemsGet200Response> = apiService.itemsGet(language = ItemsApi.LanguageItemsGet.en)

        call.enqueue(object : retrofit2.Callback<ItemsGet200Response> {
            override fun onResponse(call: Call<ItemsGet200Response>, response: retrofit2.Response<ItemsGet200Response>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    data?.payload?.items?.let { items ->
                        // Wypełniamy listę nazw przedmiotów
                        itemNamesList.clear()
                        itemNamesList.addAll(items.mapNotNull { it.itemName })
                        // Odświeżamy adapter na UI thread
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

        // Obsługa wyboru elementu z listy
        autoCompleteTextView.setOnItemClickListener { parent, _, position, _ ->
            val selectedItem = parent.getItemAtPosition(position) as String

            // Przekierowanie na ten sam fragment z przekazaniem danych
            val bundle = Bundle().apply {
                putString("selectedItem", selectedItem)
            }
            findNavController().navigate(R.id.action_mainFragment_self, bundle)
        }

        // Odczyt przekazanej wartości (jeśli jest)
        arguments?.getString("selectedItem")?.let { selectedItem ->
            Toast.makeText(requireContext(), "Wybrano: $selectedItem", Toast.LENGTH_SHORT).show()
            // Tutaj możesz zrobić coś więcej np. załadować szczegóły itp.
        }

        // Przycisk autor
        view.findViewById<Button>(R.id.buttonAutor).setOnClickListener {
            Toast.makeText(requireContext(), "Autor: Jakub Kawa", Toast.LENGTH_SHORT).show()
        }
    }
}

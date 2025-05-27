package dev.kykzuu.laby7

import okhttp3.*
import com.google.gson.Gson
import java.io.IOException

object StationApiClient {
    private val client = OkHttpClient()
    private val gson = Gson()

    fun fetchStationData(url: String, onResult: (AirQualityStation?) -> Unit) {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
                onResult(null)
            }

            override fun onResponse(call: Call, response: Response) {
                val jsonString = response.body?.string()
                if (jsonString != null) {
                    try {
                        val data = gson.fromJson(jsonString, AirQualityStation::class.java)
                        onResult(data)
                    } catch (e: Exception) {
                        e.printStackTrace()
                        onResult(null)
                    }
                } else {
                    onResult(null)
                }
            }
        })
    }
}

    package dev.kykzuu.laby7

    import okhttp3.*
    import com.google.gson.Gson
    import dev.kykzuu.laby7.AirQualityItem
    import java.io.IOException

    object ApiClient {
        private val client = OkHttpClient()

        fun fetchAirQualityData(url: String, onResult: (AirQualityItem?) -> Unit) {
            val request = Request.Builder().url(url).build()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                    onResult(null)
                }

                override fun onResponse(call: Call, response: Response) {
                    response.body?.string()?.let { jsonString ->
                        try {
                            val gson = Gson()
                            val data: AirQualityItem = gson.fromJson(jsonString, AirQualityItem::class.java)
                            onResult(data)
                        } catch (e: Exception) {
                            e.printStackTrace()
                            onResult(null)
                        }
                    } ?: onResult(null)
                }
            })
        }
    }

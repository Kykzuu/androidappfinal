package org.openapitools.client.apis

import org.openapitools.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Call
import okhttp3.RequestBody
import com.squareup.moshi.Json

import org.openapitools.client.models.ProfileOrdersPost200Response
import org.openapitools.client.models.ProfileOrdersPostRequest

interface ProfileApi {

    /**
    * enum for parameter language
    */
    enum class LanguageProfileOrdersPost(val value: kotlin.String) {
        @Json(name = "en") en("en"),
        @Json(name = "ru") ru("ru"),
        @Json(name = "ko") ko("ko"),
        @Json(name = "de") de("de"),
        @Json(name = "fr") fr("fr"),
        @Json(name = "pt") pt("pt"),
        @Json(name = "zh-hans") zhMinusHans("zh-hans"),
        @Json(name = "zh-hant") zhMinusHant("zh-hant"),
        @Json(name = "es") es("es"),
        @Json(name = "it") `it`("it"),
        @Json(name = "pl") pl("pl")
    }

    /**
     * Create an order
     * 
     * Responses:
     *  - 200: created
     *
     * @param profileOrdersPostRequest 
     * @param language Asks the server to return content translated into the specified language, default: &#x60;en&#x60;.  (optional)
     * @return [Call]<[ProfileOrdersPost200Response]>
     */
    @POST("profile/orders")
    fun profileOrdersPost(@Body profileOrdersPostRequest: ProfileOrdersPostRequest, @Header("Language") language: LanguageProfileOrdersPost? = null): Call<ProfileOrdersPost200Response>

}

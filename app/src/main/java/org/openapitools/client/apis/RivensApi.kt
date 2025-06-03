package org.openapitools.client.apis

import org.openapitools.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Call
import okhttp3.RequestBody
import com.squareup.moshi.Json

import org.openapitools.client.models.RivenAttributesGet200Response
import org.openapitools.client.models.RivenItemsGet200Response

interface RivensApi {

    /**
    * enum for parameter language
    */
    enum class LanguageRivenAttributesGet(val value: kotlin.String) {
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
     * Get a list of riven attributes.
     * 
     * Responses:
     *  - 200: Successful operation
     *
     * @param language Asks the server to return content translated into the specified language, default: &#x60;en&#x60;.  (optional)
     * @return [Call]<[RivenAttributesGet200Response]>
     */
    @GET("riven/attributes")
    fun rivenAttributesGet(@Header("Language") language: LanguageRivenAttributesGet? = null): Call<RivenAttributesGet200Response>


    /**
    * enum for parameter language
    */
    enum class LanguageRivenItemsGet(val value: kotlin.String) {
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
     * Get a list of riven items.
     * 
     * Responses:
     *  - 200: Successful operation
     *
     * @param language Asks the server to return content translated into the specified language, default: &#x60;en&#x60;.  (optional)
     * @return [Call]<[RivenItemsGet200Response]>
     */
    @GET("riven/items")
    fun rivenItemsGet(@Header("Language") language: LanguageRivenItemsGet? = null): Call<RivenItemsGet200Response>

}

package org.openapitools.client.apis

import org.openapitools.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Call
import okhttp3.RequestBody
import com.squareup.moshi.Json

import org.openapitools.client.models.LichEphemerasGet200Response
import org.openapitools.client.models.LichQuirksGet200Response
import org.openapitools.client.models.LichWeaponsGet200Response

interface SistersApi {

    /**
    * enum for parameter language
    */
    enum class LanguageSisterEphermerasGet(val value: kotlin.String) {
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
     * Get a list of sister ephemras.
     * 
     * Responses:
     *  - 200: Successful operation
     *
     * @param language Asks the server to return content translated into the specified language, default: &#x60;en&#x60;.  (optional)
     * @return [Call]<[LichEphemerasGet200Response]>
     */
    @GET("sister/ephermeras")
    fun sisterEphermerasGet(@Header("Language") language: LanguageSisterEphermerasGet? = null): Call<LichEphemerasGet200Response>


    /**
    * enum for parameter language
    */
    enum class LanguageSisterQuirksGet(val value: kotlin.String) {
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
     * Get a list of sister quirks.
     * 
     * Responses:
     *  - 200: Successful operation
     *
     * @param language Asks the server to return content translated into the specified language, default: &#x60;en&#x60;.  (optional)
     * @return [Call]<[LichQuirksGet200Response]>
     */
    @GET("sister/quirks")
    fun sisterQuirksGet(@Header("Language") language: LanguageSisterQuirksGet? = null): Call<LichQuirksGet200Response>


    /**
    * enum for parameter language
    */
    enum class LanguageSisterWeaponsGet(val value: kotlin.String) {
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
     * Get a list of sister weapons.
     * 
     * Responses:
     *  - 200: Successful operation
     *
     * @param language Asks the server to return content translated into the specified language, default: &#x60;en&#x60;.  (optional)
     * @return [Call]<[LichWeaponsGet200Response]>
     */
    @GET("sister/weapons")
    fun sisterWeaponsGet(@Header("Language") language: LanguageSisterWeaponsGet? = null): Call<LichWeaponsGet200Response>

}

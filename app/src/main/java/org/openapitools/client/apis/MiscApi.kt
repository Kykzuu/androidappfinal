package org.openapitools.client.apis

import org.openapitools.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Call
import okhttp3.RequestBody
import com.squareup.moshi.Json

import org.openapitools.client.models.LocationsGet200Response
import org.openapitools.client.models.MissionsGet200Response
import org.openapitools.client.models.NpcGet200Response

interface MiscApi {

    /**
    * enum for parameter language
    */
    enum class LanguageLocationsGet(val value: kotlin.String) {
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
     * Get a list of known game locations.
     * 
     * Responses:
     *  - 200: Successful operation
     *
     * @param language Asks the server to return content translated into the specified language, default: &#x60;en&#x60;.  (optional)
     * @return [Call]<[LocationsGet200Response]>
     */
    @GET("locations")
    fun locationsGet(@Header("Language") language: LanguageLocationsGet? = null): Call<LocationsGet200Response>


    /**
    * enum for parameter language
    */
    enum class LanguageMissionsGet(val value: kotlin.String) {
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
     * Get a list of known NPCs.
     * 
     * Responses:
     *  - 200: Successful operation
     *
     * @param language Asks the server to return content translated into the specified language, default: &#x60;en&#x60;.  (optional)
     * @return [Call]<[MissionsGet200Response]>
     */
    @GET("missions")
    fun missionsGet(@Header("Language") language: LanguageMissionsGet? = null): Call<MissionsGet200Response>


    /**
    * enum for parameter language
    */
    enum class LanguageNpcGet(val value: kotlin.String) {
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
     * Get a list of known NPCs.
     * 
     * Responses:
     *  - 200: Successful operation
     *
     * @param language Asks the server to return content translated into the specified language, default: &#x60;en&#x60;.  (optional)
     * @return [Call]<[NpcGet200Response]>
     */
    @GET("npc")
    fun npcGet(@Header("Language") language: LanguageNpcGet? = null): Call<NpcGet200Response>

}

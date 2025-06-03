package org.openapitools.client.apis

import org.openapitools.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Call
import okhttp3.RequestBody
import com.squareup.moshi.Json

import org.openapitools.client.models.GetItemInfo200Response
import org.openapitools.client.models.ItemsGet200Response
import org.openapitools.client.models.ItemsUrlNameDropsourcesGet200Response
import org.openapitools.client.models.ItemsUrlNameOrdersGet200Response

interface ItemsApi {

    /**
    * enum for parameter platform
    */
    enum class PlatformGetItemInfo(val value: kotlin.String) {
        @Json(name = "xbox") xbox("xbox"),
        @Json(name = "pc") pc("pc"),
        @Json(name = "ps4") ps4("ps4"),
        @Json(name = "switch") switch("switch")
    }

    /**
     * Gets information about an item
     * 
     * Responses:
     *  - 200: Successful operation
     *
     * @param urlName url_name of an item
     * @param platform Asks the server to return content for specified platform, default: &#x60;pc&#x60;.  (optional)
     * @return [Call]<[GetItemInfo200Response]>
     */
    @GET("items/{url_name}")
    fun getItemInfo(@Path("url_name") urlName: kotlin.String, @Header("Platform") platform: PlatformGetItemInfo? = null): Call<GetItemInfo200Response>


    /**
    * enum for parameter language
    */
    enum class LanguageItemsGet(val value: kotlin.String) {
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
     * Get list of all tradable items.
     * 
     * Responses:
     *  - 200: Succesfull
     *
     * @param language Asks the server to return content translated into the specified language, default: &#x60;en&#x60;.  (optional)
     * @return [Call]<[ItemsGet200Response]>
     */
    @GET("items")
    fun itemsGet(@Header("Language") language: LanguageItemsGet? = null): Call<ItemsGet200Response>


    /**
    * enum for parameter language
    */
    enum class LanguageItemsUrlNameDropsourcesGet(val value: kotlin.String) {
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
    * enum for parameter include
    */
    enum class IncludeItemsUrlNameDropsourcesGet(val value: kotlin.String) {
        @Json(name = "item") item("item")
    }

    /**
     * Get dropsources for a given item
     * 
     * Responses:
     *  - 200: Successful operation
     *
     * @param urlName url_name of an item
     * @param language Asks the server to return content translated into the specified language, default: &#x60;en&#x60;.  (optional)
     * @param include Include additional information.   Will add a new response section with all information about requested model.  (optional)
     * @return [Call]<[ItemsUrlNameDropsourcesGet200Response]>
     */
    @GET("items/{url_name}/dropsources")
    fun itemsUrlNameDropsourcesGet(@Path("url_name") urlName: kotlin.String, @Header("Language") language: LanguageItemsUrlNameDropsourcesGet? = null, @Query("include") include: IncludeItemsUrlNameDropsourcesGet? = null): Call<ItemsUrlNameDropsourcesGet200Response>


    /**
    * enum for parameter platform
    */
    enum class PlatformItemsUrlNameOrdersGet(val value: kotlin.String) {
        @Json(name = "xbox") xbox("xbox"),
        @Json(name = "pc") pc("pc"),
        @Json(name = "ps4") ps4("ps4"),
        @Json(name = "switch") switch("switch")
    }


    /**
    * enum for parameter include
    */
    enum class IncludeItemsUrlNameOrdersGet(val value: kotlin.String) {
        @Json(name = "item") item("item")
    }

    /**
     * Get list of orders for a given item_id
     * 
     * Responses:
     *  - 200: Successful operation, with `?include=item`
     *
     * @param urlName url_name of an item
     * @param platform Asks the server to return content for specified platform, default: &#x60;pc&#x60;.  (optional)
     * @param include Include additional information.   Will add a new response section with all information about requested model.  (optional)
     * @return [Call]<[ItemsUrlNameOrdersGet200Response]>
     */
    @GET("items/{url_name}/orders")
    fun itemsUrlNameOrdersGet(@Path("url_name") urlName: kotlin.String, @Header("Platform") platform: PlatformItemsUrlNameOrdersGet? = null, @Query("include") include: IncludeItemsUrlNameOrdersGet? = null): Call<ItemsUrlNameOrdersGet200Response>

}

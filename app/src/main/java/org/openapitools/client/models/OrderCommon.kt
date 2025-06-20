/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package org.openapitools.client.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param id 
 * @param platinum 
 * @param quantity 
 * @param orderType 
 * @param platform 
 * @param region will be deprecated eventually
 * @param creationDate 
 * @param lastUpdate 
 * @param subtype subtyppe oof an item, all valid subtypes defined inside Item model `subtypes` field
 * @param visible Is this order visible? All public orders will be visible, and only orders in your profile could be invisible. 
 */


data class OrderCommon (

    @Json(name = "id")
    val id: kotlin.String? = null,

    @Json(name = "platinum")
    val platinum: kotlin.Int? = null,

    @Json(name = "quantity")
    val quantity: kotlin.Int? = null,

    @Json(name = "order_type")
    val orderType: OrderCommon.OrderType? = null,

    @Json(name = "platform")
    val platform: OrderCommon.Platform? = null,

    /* will be deprecated eventually */
    @Json(name = "region")
    val region: kotlin.String? = null,

    @Json(name = "creation_date")
    val creationDate: java.time.OffsetDateTime? = null,

    @Json(name = "last_update")
    val lastUpdate: java.time.OffsetDateTime? = null,

    /* subtyppe oof an item, all valid subtypes defined inside Item model `subtypes` field */
    @Json(name = "subtype")
    val subtype: kotlin.String? = null,

    /* Is this order visible? All public orders will be visible, and only orders in your profile could be invisible.  */
    @Json(name = "visible")
    val visible: kotlin.Boolean? = null

) {

    /**
     * 
     *
     * Values: sell,buy
     */
    @JsonClass(generateAdapter = false)
    enum class OrderType(val value: kotlin.String) {
        @Json(name = "sell") sell("sell"),
        @Json(name = "buy") buy("buy");
    }
    /**
     * 
     *
     * Values: xbox,pc,ps4,switch
     */
    @JsonClass(generateAdapter = false)
    enum class Platform(val value: kotlin.String) {
        @Json(name = "xbox") xbox("xbox"),
        @Json(name = "pc") pc("pc"),
        @Json(name = "ps4") ps4("ps4"),
        @Json(name = "switch") switch("switch");
    }
}


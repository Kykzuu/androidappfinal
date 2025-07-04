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
 * @param missionId 
 * @param nodeId 
 * @param rarity How rare item is
 * @param rate 
 * @param itemSubtype 
 * @param rotation 
 * @param stage openworld missions only
 */


data class DropsourceMissionsInner (

    @Json(name = "mission_id")
    val missionId: kotlin.String? = null,

    @Json(name = "node_id")
    val nodeId: kotlin.String? = null,

    /* How rare item is */
    @Json(name = "rarity")
    val rarity: DropsourceMissionsInner.Rarity? = null,

    @Json(name = "rate")
    val rate: java.math.BigDecimal? = null,

    @Json(name = "item_subtype")
    val itemSubtype: DropsourceMissionsInner.ItemSubtype? = null,

    @Json(name = "rotation")
    val rotation: DropsourceMissionsInner.Rotation? = null,

    /* openworld missions only */
    @Json(name = "stage")
    val stage: DropsourceMissionsInner.Stage? = null

) {

    /**
     * How rare item is
     *
     * Values: very_common,common,uncommon,rare,legendary
     */
    @JsonClass(generateAdapter = false)
    enum class Rarity(val value: kotlin.String) {
        @Json(name = "very_common") very_common("very_common"),
        @Json(name = "common") common("common"),
        @Json(name = "uncommon") uncommon("uncommon"),
        @Json(name = "rare") rare("rare"),
        @Json(name = "legendary") legendary("legendary");
    }
    /**
     * 
     *
     * Values: intact,exceptional,flawless,radiant,small,medium,large,basic,adorned,magnificent
     */
    @JsonClass(generateAdapter = false)
    enum class ItemSubtype(val value: kotlin.String) {
        @Json(name = "intact") intact("intact"),
        @Json(name = "exceptional") exceptional("exceptional"),
        @Json(name = "flawless") flawless("flawless"),
        @Json(name = "radiant") radiant("radiant"),
        @Json(name = "small") small("small"),
        @Json(name = "medium") medium("medium"),
        @Json(name = "large") large("large"),
        @Json(name = "basic") basic("basic"),
        @Json(name = "adorned") adorned("adorned"),
        @Json(name = "magnificent") magnificent("magnificent");
    }
    /**
     * 
     *
     * Values: a,b,c
     */
    @JsonClass(generateAdapter = false)
    enum class Rotation(val value: kotlin.String) {
        @Json(name = "a") a("a"),
        @Json(name = "b") b("b"),
        @Json(name = "c") c("c");
    }
    /**
     * openworld missions only
     *
     * Values: _1,_2,_3,_4,`final`
     */
    @JsonClass(generateAdapter = false)
    enum class Stage(val value: kotlin.String) {
        @Json(name = "1") _1("1"),
        @Json(name = "2") _2("2"),
        @Json(name = "3") _3("3"),
        @Json(name = "4") _4("4"),
        @Json(name = "final") `final`("final");
    }
}


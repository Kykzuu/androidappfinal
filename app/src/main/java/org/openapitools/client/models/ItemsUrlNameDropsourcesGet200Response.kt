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

import org.openapitools.client.models.GetItemInfo200ResponsePayload
import org.openapitools.client.models.ItemsUrlNameDropsourcesGet200ResponsePayload

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param payload 
 * @param include 
 */


data class ItemsUrlNameDropsourcesGet200Response (

    @Json(name = "payload")
    val payload: ItemsUrlNameDropsourcesGet200ResponsePayload,

    @Json(name = "include")
    val include: GetItemInfo200ResponsePayload? = null

)


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

import org.openapitools.client.models.SettingsNotificationsPushPostRequestOneOf1Subscription

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param device 
 * @param subscription 
 */


data class SettingsNotificationsPushPostRequestOneOf1 (

    @Json(name = "device")
    val device: SettingsNotificationsPushPostRequestOneOf1.Device,

    @Json(name = "subscription")
    val subscription: SettingsNotificationsPushPostRequestOneOf1Subscription

) {

    /**
     * 
     *
     * Values: android
     */
    @JsonClass(generateAdapter = false)
    enum class Device(val value: kotlin.String) {
        @Json(name = "android") android("android");
    }
}


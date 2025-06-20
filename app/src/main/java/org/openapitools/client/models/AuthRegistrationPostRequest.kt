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
 * @param email
 * @param password
 * @param passwordSecond
 * @param authType
 * @param region
 * @param deviceId Optional device_id, defined on client side. This param help us to keep push subscription between login and logout. And clearer identify your device.
 * @param recaptcha Google reCaptcha, required if you are not using special device auth.
 */

data class AuthRegistrationPostRequest(

    @Json(name = "email")
    val email: String,

    @Json(name = "password")
    val password: String,

    @Json(name = "password_second")
    val passwordSecond: String,

    @Json(name = "auth_type")
    val authType: AuthType? = AuthType.COOKIE,

    @Json(name = "region")
    val region: String? = "en",

    @Json(name = "device_id")
    val deviceId: String? = null,

    @Json(name = "recaptcha")
    val recaptcha: String? = null

) {
    @JsonClass(generateAdapter = true)
    enum class AuthType(val value: String) {
        @Json(name = "cookie") COOKIE("cookie"),
        @Json(name = "header") HEADER("header")
    }
}


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

import org.openapitools.client.models.NemesisEphemera

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param ephemeras 
 */


data class LichEphemerasGet200ResponsePayload (

    @Json(name = "ephemeras")
    val ephemeras: kotlin.collections.List<NemesisEphemera>? = null

)


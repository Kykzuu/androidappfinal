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

import org.openapitools.client.models.CurrentUserLinkedAccounts
import org.openapitools.client.models.CurrentUserPatreonProfile

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param id 
 * @param anonymous 
 * @param verification 
 * @param ingameName 
 * @param checkCode 
 * @param role 
 * @param patreonProfile 
 * @param platform 
 * @param region 
 * @param banned 
 * @param banReason 
 * @param avatar Path to user avatar in static folder.
 * @param background Path to user background in static folder.
 * @param linkedAccounts 
 * @param hasEmail 
 * @param writtenReviews how much reviews user wrote today.
 * @param unreadMessages 
 */


data class CurrentUser (

    @Json(name = "id")
    val id: kotlin.String? = null,

    @Json(name = "anonymous")
    val anonymous: kotlin.Boolean? = null,

    @Json(name = "verification")
    val verification: kotlin.Boolean? = null,

    @Json(name = "ingame_name")
    val ingameName: kotlin.String? = null,

    @Json(name = "check_code")
    val checkCode: kotlin.String? = null,

    @Json(name = "role")
    val role: CurrentUser.Role? = null,

    @Json(name = "patreon_profile")
    val patreonProfile: CurrentUserPatreonProfile? = null,

    @Json(name = "platform")
    val platform: CurrentUser.Platform? = null,

    @Json(name = "region")
    val region: kotlin.String? = null,

    @Json(name = "banned")
    val banned: kotlin.Boolean? = null,

    @Json(name = "ban_reason")
    val banReason: kotlin.String? = null,

    /* Path to user avatar in static folder. */
    @Json(name = "avatar")
    val avatar: kotlin.String? = null,

    /* Path to user background in static folder. */
    @Json(name = "background")
    val background: kotlin.String? = null,

    @Json(name = "linked_accounts")
    val linkedAccounts: CurrentUserLinkedAccounts? = null,

    @Json(name = "has_email")
    val hasEmail: kotlin.Boolean? = null,

    /* how much reviews user wrote today. */
    @Json(name = "written_reviews")
    val writtenReviews: kotlin.Int? = null,

    @Json(name = "unread_messages")
    val unreadMessages: kotlin.Int? = null

) {

    /**
     * 
     *
     * Values: anonymous,user,moderator,admin
     */
    @JsonClass(generateAdapter = false)
    enum class Role(val value: kotlin.String) {
        @Json(name = "anonymous") anonymous("anonymous"),
        @Json(name = "user") user("user"),
        @Json(name = "moderator") moderator("moderator"),
        @Json(name = "admin") admin("admin");
    }
    /**
     * 
     *
     * Values: ps4,pc,xbox
     */
    @JsonClass(generateAdapter = false)
    enum class Platform(val value: kotlin.String) {
        @Json(name = "ps4") ps4("ps4"),
        @Json(name = "pc") pc("pc"),
        @Json(name = "xbox") xbox("xbox");
    }
}


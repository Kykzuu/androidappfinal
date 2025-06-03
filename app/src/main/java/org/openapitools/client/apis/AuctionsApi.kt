package org.openapitools.client.apis

import org.openapitools.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Call
import okhttp3.RequestBody
import com.squareup.moshi.Json

import org.openapitools.client.models.AuctionsCreatePost200Response
import org.openapitools.client.models.AuctionsCreatePostRequest
import org.openapitools.client.models.AuctionsSearchTypeRivenGet200Response
import org.openapitools.client.models.Element

interface AuctionsApi {
    /**
     * ⚠ Auction creation.
     * Create auction, for riven or lich item types.
     * Responses:
     *  - 200: Successful operation
     *
     * @param auctionsCreatePostRequest Info about auction and item
     * @return [Call]<[AuctionsCreatePost200Response]>
     */
    @POST("auctions/create")
    fun auctionsCreatePost(@Body auctionsCreatePostRequest: AuctionsCreatePostRequest): Call<AuctionsCreatePost200Response>


    /**
    * enum for parameter platform
    */
    enum class PlatformAuctionsSearchtypelichGet(val value: kotlin.String) {
        @Json(name = "xbox") xbox("xbox"),
        @Json(name = "pc") pc("pc"),
        @Json(name = "ps4") ps4("ps4"),
        @Json(name = "switch") switch("switch")
    }


    /**
    * enum for parameter buyoutPolicy
    */
    enum class BuyoutPolicyAuctionsSearchtypelichGet(val value: kotlin.String) {
        @Json(name = "with") with("with"),
        @Json(name = "direct") direct("direct")
    }


    /**
    * enum for parameter sortBy
    */
    enum class SortByAuctionsSearchtypelichGet(val value: kotlin.String) {
        @Json(name = "price_desc") price_desc("price_desc"),
        @Json(name = "price_asc") price_asc("price_asc"),
        @Json(name = "damage_desc") damage_desc("damage_desc"),
        @Json(name = "damage_asc") damage_asc("damage_asc")
    }

    /**
     * Get a list of lich auctions by given search params.
     * Auctions from banned users will be excluded. 
     * Responses:
     *  - 200: Successful operation
     *
     * @param platform Asks the server to return content for specified platform, default: &#x60;pc&#x60;.  (optional)
     * @param buyoutPolicy auction type, if not specified implied: all (optional)
     * @param weaponUrlName lich weapon &#x60;url_name&#x60; property (optional)
     * @param element lich element (optional)
     * @param ephemera lich is having ephemera   ephemera is based on lich element.  (optional)
     * @param damageMin Minimum bonus damage value of desirable lich (optional)
     * @param damageMax Minimum bonus damage value of desirable lich (optional)
     * @param quirk Lich quirk &#x60;url_name&#x60; property (optional)
     * @param sortBy Sorting, by prices or by weapon damage bonus value, ascending and descending. (optional)
     * @return [Call]<[AuctionsSearchTypeRivenGet200Response]>
     */
    @GET("auctions/search?type=lich")
    fun auctionsSearchtypelichGet(@Header("Platform") platform: PlatformAuctionsSearchtypelichGet? = null, @Query("buyout_policy") buyoutPolicy: BuyoutPolicyAuctionsSearchtypelichGet? = null, @Query("weapon_url_name") weaponUrlName: kotlin.String? = null, @Query("element") element: Element? = null, @Query("ephemera") ephemera: kotlin.Boolean? = null, @Query("damage_min") damageMin: kotlin.Int? = null, @Query("damage_max") damageMax: kotlin.Int? = null, @Query("quirk") quirk: kotlin.String? = null, @Query("sort_by") sortBy: SortByAuctionsSearchtypelichGet? = null): Call<AuctionsSearchTypeRivenGet200Response>


    /**
    * enum for parameter platform
    */
    enum class PlatformAuctionsSearchtyperivenGet(val value: kotlin.String) {
        @Json(name = "xbox") xbox("xbox"),
        @Json(name = "pc") pc("pc"),
        @Json(name = "ps4") ps4("ps4"),
        @Json(name = "switch") switch("switch")
    }


    /**
    * enum for parameter buyoutPolicy
    */
    enum class BuyoutPolicyAuctionsSearchtyperivenGet(val value: kotlin.String) {
        @Json(name = "with") with("with"),
        @Json(name = "direct") direct("direct")
    }


    /**
    * enum for parameter operation
    */
    enum class OperationAuctionsSearchtyperivenGet(val value: kotlin.String) {
        @Json(name = "anyOf") anyOf("anyOf"),
        @Json(name = "allOf") allOf("allOf")
    }


    /**
    * enum for parameter modRank
    */
    enum class ModRankAuctionsSearchtyperivenGet(val value: kotlin.String) {
        @Json(name = "any") any("any"),
        @Json(name = "maxed") maxed("maxed")
    }


    /**
    * enum for parameter polarity
    */
    enum class PolarityAuctionsSearchtyperivenGet(val value: kotlin.String) {
        @Json(name = "madurai") madurai("madurai"),
        @Json(name = "vazarin") vazarin("vazarin"),
        @Json(name = "naramon") naramon("naramon"),
        @Json(name = "zenurik") zenurik("zenurik"),
        @Json(name = "any") any("any")
    }


    /**
    * enum for parameter sortBy
    */
    enum class SortByAuctionsSearchtyperivenGet(val value: kotlin.String) {
        @Json(name = "price_desc") price_desc("price_desc"),
        @Json(name = "price_asc") price_asc("price_asc"),
        @Json(name = "positive_attr_desc") positive_attr_desc("positive_attr_desc"),
        @Json(name = "positive_attr_asc") positive_attr_asc("positive_attr_asc")
    }

    /**
     * Get a list of riven auctions by given search params.
     * Auctions from banned users will be excluded.   You must specify weapon or one positive atttribute, at least. 
     * Responses:
     *  - 200: Successful operation
     *
     * @param platform Asks the server to return content for specified platform, default: &#x60;pc&#x60;.  (optional)
     * @param buyoutPolicy auction type, if not specified implied: all (optional)
     * @param weaponUrlName riven weapon &#x60;url_name&#x60; property (optional)
     * @param positiveStats Positive attributes in for of string: &#x60;attr1,attr2,attr3&#x60;  (optional)
     * @param negativeStats Negative attributes in for of string: &#x60;attr1,attr2,attr3&#x60; For None use the string: &#x60;None&#x60;  (optional)
     * @param operation Not used on the frontend right now, becuse this is not a very usefull flag. Used in conjuction with positive stats, like:  - &#x60;allOf&#x60; will get riven auction that contains all of defined positive attributes - &#x60;anyOf&#x60; will get riven auction that contains any of defined positive attributes  Default value is &#x60;allOf&#x60;  (optional)
     * @param masteryRankMin Minimum rank value of riven mod (optional)
     * @param masteryRankMax Maximum rank value of riven mod (optional)
     * @param reRollsMin Minimum amount of rolls (optional)
     * @param reRollsMax Maximum amount of rolls (optional)
     * @param modRank Should mod be maxed or whatever. (optional)
     * @param polarity  (optional)
     * @param sortBy Sorting, by prices or by attributes value, ascending and descending. (optional)
     * @return [Call]<[AuctionsSearchTypeRivenGet200Response]>
     */
    @GET("auctions/search?type=riven")
    fun auctionsSearchtyperivenGet(@Header("Platform") platform: PlatformAuctionsSearchtyperivenGet? = null, @Query("buyout_policy") buyoutPolicy: BuyoutPolicyAuctionsSearchtyperivenGet? = null, @Query("weapon_url_name") weaponUrlName: kotlin.String? = null, @Query("positive_stats") positiveStats: kotlin.String? = null, @Query("negative_stats") negativeStats: kotlin.String? = null, @Query("operation") operation: OperationAuctionsSearchtyperivenGet? = null, @Query("mastery_rank_min") masteryRankMin: kotlin.Int? = null, @Query("mastery_rank_max") masteryRankMax: kotlin.Int? = null, @Query("re_rolls_min") reRollsMin: kotlin.Int? = null, @Query("re_rolls_max") reRollsMax: kotlin.Int? = null, @Query("mod_rank") modRank: ModRankAuctionsSearchtyperivenGet? = null, @Query("polarity") polarity: PolarityAuctionsSearchtyperivenGet? = null, @Query("sort_by") sortBy: SortByAuctionsSearchtyperivenGet? = null): Call<AuctionsSearchTypeRivenGet200Response>

}

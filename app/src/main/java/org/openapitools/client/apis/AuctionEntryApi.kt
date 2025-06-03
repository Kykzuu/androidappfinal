package org.openapitools.client.apis

import org.openapitools.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Call
import okhttp3.RequestBody
import com.squareup.moshi.Json

import org.openapitools.client.models.AuctionsEntryAuctionIdBidsGet200Response
import org.openapitools.client.models.AuctionsEntryAuctionIdGet200Response

interface AuctionEntryApi {

    /**
    * enum for parameter include
    */
    enum class IncludeAuctionsEntryAuctionIdBidsGet(val value: kotlin.String) {
        @Json(name = "auction") auction("auction")
    }

    /**
     * Gets auction bids by auction Id
     * 
     * Responses:
     *  - 200: Successful operation
     *
     * @param auctionId ObjectId of auction
     * @param include Include additional information.   Will add a new response section with all information about requested model.  (optional)
     * @return [Call]<[AuctionsEntryAuctionIdBidsGet200Response]>
     */
    @GET("auctions/entry/{auction_id}/bids")
    fun auctionsEntryAuctionIdBidsGet(@Path("auction_id") auctionId: kotlin.String, @Query("include") include: IncludeAuctionsEntryAuctionIdBidsGet? = null): Call<AuctionsEntryAuctionIdBidsGet200Response>

    /**
     * Gets information about auction by auction Id
     * 
     * Responses:
     *  - 200: Successful operation
     *
     * @param auctionId ObjectId of auction
     * @return [Call]<[AuctionsEntryAuctionIdGet200Response]>
     */
    @GET("auctions/entry/{auction_id}")
    fun auctionsEntryAuctionIdGet(@Path("auction_id") auctionId: kotlin.String): Call<AuctionsEntryAuctionIdGet200Response>

}

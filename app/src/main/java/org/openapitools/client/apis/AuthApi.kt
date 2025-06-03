package org.openapitools.client.apis

import org.openapitools.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Call
import okhttp3.RequestBody
import com.squareup.moshi.Json

import org.openapitools.client.models.AuthRegistrationPostRequest
import org.openapitools.client.models.AuthRestorePostRequest
import org.openapitools.client.models.AuthSigninPostRequest
import org.openapitools.client.models.CurrentUser

interface AuthApi {
    /**
     * Registration of new user and their device.
     * There is 2 types of registration, for web browser and for Android device. Android device could avoid to include reCaptha toke by using secret DeviceKey in the request headers.
     * Responses:
     *  - 200: A JSON representation of currentUser
     *
     * @param authRegistrationPostRequest 
     * @return [Call]<[CurrentUser]>
     */
    @POST("auth/registration")
    fun authRegistrationPost(@Body authRegistrationPostRequest: AuthRegistrationPostRequest): Call<CurrentUser>

    /**
     * Password restoration.
     * You will recieve mail with the new password, short after api call.
     * Responses:
     *  - 200: Empty object
     *
     * @param authRestorePostRequest 
     * @return [Call]<[kotlin.Any]>
     */
    @POST("auth/restore")
    fun authRestorePost(@Body authRestorePostRequest: AuthRestorePostRequest): Call<kotlin.Any>

    /**
     * Simple login.
     * There is 2 ways to maintain authorization: - Through Cookie for Web browsers. - Through Header for other devices. 
     * Responses:
     *  - 200: A JSON representation of currentUser
     *
     * @param authSigninPostRequest 
     * @return [Call]<[CurrentUser]>
     */
    @POST("auth/signin")
    fun authSigninPost(@Body authSigninPostRequest: AuthSigninPostRequest): Call<CurrentUser>

}

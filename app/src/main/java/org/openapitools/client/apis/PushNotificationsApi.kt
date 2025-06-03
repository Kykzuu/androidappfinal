package org.openapitools.client.apis

import org.openapitools.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Call
import okhttp3.RequestBody
import com.squareup.moshi.Json

import org.openapitools.client.models.SettingsNotificationsPushPost200Response
import org.openapitools.client.models.SettingsNotificationsPushPostRequest

interface PushNotificationsApi {
    /**
     * Push Unsubscribe
     * Unflag &#x60;subscribed&#x60; in our DB from currentUser.
     * Responses:
     *  - 200: Successful operation
     *
     * @return [Call]<[SettingsNotificationsPushPost200Response]>
     */
    @DELETE("settings/notifications/push")
    fun settingsNotificationsPushDelete(): Call<SettingsNotificationsPushPost200Response>

    /**
     * Get subscription
     * Not implemented
     * Responses:
     *  - 200: Nothing
     *
     * @return [Call]<[Unit]>
     */
    @GET("settings/notifications/push")
    fun settingsNotificationsPushGet(): Call<Unit>

    /**
     * Push subscribe
     * There is 3 formats, for web for android   Web usage: --------- &#x60;&#x60;&#x60; {     &#39;device&#39;: &#39;web&#39;     &#39;subscription&#39;:         {         \&quot;endpointeger\&quot;:\&quot;https://fcm.googleapis.com/fcm/send/...\&quot;,         \&quot;keys\&quot;:{             \&quot;p256dh\&quot;:\&quot;BBya_RhGe...\&quot;,             \&quot;auth\&quot;:\&quot;2PFoLO3K...\&quot;             }         } } &#x60;&#x60;&#x60;  Android usage: --------- &#x60;&#x60;&#x60;   {     &#39;device&#39;: &#39;android&#39;     &#39;subscription&#39;:         {         \&quot;push_token\&quot;:\&quot;asdnOIHSD2134...\&quot;         } } &#x60;&#x60;&#x60; 
     * Responses:
     *  - 200: Ok
     *
     * @param settingsNotificationsPushPostRequest  (optional)
     * @return [Call]<[SettingsNotificationsPushPost200Response]>
     */
    @POST("settings/notifications/push")
    fun settingsNotificationsPushPost(@Body settingsNotificationsPushPostRequest: SettingsNotificationsPushPostRequest? = null): Call<SettingsNotificationsPushPost200Response>

}

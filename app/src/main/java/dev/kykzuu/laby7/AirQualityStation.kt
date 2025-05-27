package dev.kykzuu.laby7

import com.google.gson.annotations.SerializedName

data class AirQualityStation(
    @SerializedName("@context")
    val context: ContextInfo? = null,

    @SerializedName("Lista stanowisk pomiarowych dla podanej stacji")
    val sensorsList: List<SensorItem>? = null,

    val meta: Meta? = null,

    val links: Links? = null,

    val totalPages: Int? = null
)

data class ContextInfo(
    @SerializedName("Lista stanowisk pomiarowych dla podanej stacji")
    val sensorsListUrl: String? = null,

    val links: String? = null,

    val totalPages: String? = null
)

data class SensorItem(
    @SerializedName("Identyfikator stanowiska")
    val sensorId: Int? = null,

    @SerializedName("Identyfikator stacji")
    val stationId: Int? = null,

    @SerializedName("Wskaźnik")
    val indicator: String? = null,

    @SerializedName("Wskaźnik - wzór")
    val indicatorFormula: String? = null,

    @SerializedName("Wskaźnik - kod")
    val indicatorCode: String? = null,

    @SerializedName("Id wskaźnika")
    val indicatorId: Int? = null
)

data class Meta(
    @SerializedName("dc:description")
    val description: String? = null,

    @SerializedName("sy:updateFrequency")
    val updateFrequency: String? = null,

    @SerializedName("dc:language")
    val language: String? = null,

    @SerializedName("schema:contentType")
    val contentType: String? = null,

    @SerializedName("schema:provider")
    val provider: Provider? = null,

    @SerializedName("schema:dateModified")
    val dateModified: String? = null,

    @SerializedName("dc:title")
    val title: String? = null,

    @SerializedName("schema:datePublished")
    val datePublished: String? = null,

    @SerializedName("schema:keywords")
    val keywords: String? = null,

    @SerializedName("sy:updatePeriod")
    val updatePeriod: String? = null,

    @SerializedName("schema:isPartOf")
    val isPartOf: String? = null
)

data class Provider(
    @SerializedName("@context")
    val context: String? = null,

    @SerializedName("@type")
    val type: String? = null,

    val address: Address? = null,

    val email: String? = null,

    val name: String? = null
)

data class Address(
    @SerializedName("@type")
    val type: String? = null,

    val addressLocality: String? = null,

    val postalCode: String? = null,

    val streetAddress: String? = null
)

data class Links(
    val next: String? = null,
    val last: String? = null,
    val prev: String? = null,
    val self: String? = null,
    val first: String? = null
)

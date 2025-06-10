package dev.kykzuu.laby7.utils

import com.squareup.moshi.*
import java.time.OffsetDateTime

class OffsetDateTimeAdapter {
    @ToJson
    fun toJson(value: OffsetDateTime?): String? = value?.toString()

    @FromJson
    fun fromJson(value: String?): OffsetDateTime? = value?.let { OffsetDateTime.parse(it) }
}
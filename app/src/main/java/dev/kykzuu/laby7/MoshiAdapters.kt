package dev.kykzuu.laby7

import com.squareup.moshi.*
import okio.BufferedSource
import okio.BufferedSink
import java.time.OffsetDateTime

class OffsetDateTimeAdapter {
    @ToJson
    fun toJson(value: OffsetDateTime?): String? = value?.toString()

    @FromJson
    fun fromJson(value: String?): OffsetDateTime? = value?.let { OffsetDateTime.parse(it) }
}
package com.practice.realtimeweather.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Location(
    val name: String,
    val region: String,
    val country: String,
    @Json(name = "tz_id")
    val tzId: String,
    @Json(name = "localtime_epoch")
    val localtimeEpoch: Int,
    val localtime: String,
)

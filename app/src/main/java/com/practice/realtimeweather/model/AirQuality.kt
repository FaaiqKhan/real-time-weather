package com.practice.realtimeweather.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AirQuality(
    val co: Double,
    val no2: Double,
    val o3: Double,
    val so2: Double,
    @Json(name = "pm2_5")
    val pm25: Double,
    val pm10: Double,
    @Json(name = "us-epa-index")
    val usEpaIndex: Int,
    @Json(name = "gb-defra-index")
    val gbDefraIndex: Int,
)

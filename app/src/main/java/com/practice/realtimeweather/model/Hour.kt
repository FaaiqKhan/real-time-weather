package com.practice.realtimeweather.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Hour(
    @Json(name = "time_epoch")
    val timeEpoch: Long,
    val time: String,
    @Json(name = "temp_c")
    val temperatureInCelsius: Double,
    @Json(name = "temp_f")
    val temperatureInFahrenheit: Double,
    val condition: Condition,
    @Json(name = "precip_mm")
    val precipitationInMM: Double,
    @Json(name = "precip_in")
    val precipitationInInch: Double,
    val humidity: Int
)

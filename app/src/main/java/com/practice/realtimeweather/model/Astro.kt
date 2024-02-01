package com.practice.realtimeweather.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Astro(
    val sunrise: String,
    val sunset: String,
    val moonrise: String,
    val moonset: String,
)

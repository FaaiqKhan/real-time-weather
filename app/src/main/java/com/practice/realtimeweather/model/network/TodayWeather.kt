package com.practice.realtimeweather.model.network

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TodayWeather(
    val location: Location,
    val current: Current
)

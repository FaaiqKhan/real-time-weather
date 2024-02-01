package com.practice.realtimeweather.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TodayWeather(
    val location: Location,
    val current: Current
)

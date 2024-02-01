package com.practice.realtimeweather.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Json(name = "forecastday")
@JsonClass(generateAdapter = true)
data class ForecastDay(
    val date: String,
    @Json(name = "date_epoch")
    val dateEpoch: Long,
    val day: Day,
    val astro: Astro,
    val hour: List<Hour>
)

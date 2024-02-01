package com.practice.realtimeweather.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeeklyWeather(
    val location: Location,
    val forecast: Forecast,
)

@JsonClass(generateAdapter = true)
data class Forecast(
    val forecastday: List<ForecastDay>
)

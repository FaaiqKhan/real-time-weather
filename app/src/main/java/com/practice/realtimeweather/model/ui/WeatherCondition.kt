package com.practice.realtimeweather.model.ui

data class WeatherCondition(
    val weather: String,
    private val image: String,
) {

    fun getImage(): String = "https:${image}"
}
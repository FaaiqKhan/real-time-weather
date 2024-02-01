package com.practice.realtimeweather.model.ui

data class TodayWeatherUIData(
    val currentWeather: CurrentWeather
)

data class CurrentWeather(
    val date: String,
    val temperature: String,
    val weatherCondition: WeatherCondition,
    val feelsLike: String,
    val windSpeed: String,
    val details: Map<String, String>,
    val rainDetails: Map<String, String>,
    val windDetails: Map<String, String>,
)
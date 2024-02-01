package com.practice.realtimeweather.model.ui

data class WeeklyWeatherUIData(
    val forecast: List<WeatherUIData>
)

data class WeatherUIData(
    val date: String,
    val weatherCondition: WeatherCondition,
    val highTemperature: String,
    val lowTemperature: String,
    val details: Map<String, String>,
    val hourlyWeather: List<HourUIData>
)

data class HourUIData(
    val temperature: String,
    val weatherCondition: WeatherCondition,
    val time: String
)

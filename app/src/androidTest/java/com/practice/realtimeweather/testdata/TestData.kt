package com.practice.realtimeweather.testdata

import com.practice.realtimeweather.model.ui.*

object TestData {

    const val errorMessage = "Something went wrong, try again later"

    private val weatherCondition = WeatherCondition(
        weather = "Sunny",
        image = "//cdn.weatherapi.com/weather/64x64/day/113.png",
    )

    private val currentWeather = CurrentWeather(
        date = "29 January, 02:45",
        temperature = "10.0",
        weatherCondition = weatherCondition,
        feelsLike = "8.2",
        windSpeed = "15.1",
        details = mapOf(
            "Humidity" to "43.0%",
            "Visibility" to "10.0 Km",
            "UVIndex" to "2.0",
        ),
        rainDetails = mapOf("Volume" to "0.0 mm"),
        windDetails = mapOf(
            "Wind Guest" to "15.1 Km/h",
            "Wind Direction" to "SSW"
        ),
    )

    val todayWeatherUIData = TodayWeatherUIData(
        currentWeather = currentWeather
    )

    private val weatherUIData = WeatherUIData(
        date = "Monday, 29 Jan",
        weatherCondition = weatherCondition,
        highTemperature = "7.2",
        lowTemperature = "3.5",
        details = mapOf(
            "Wind" to "28.1 km/h",
            "Humidity" to "77%",
            "UV Index" to "1.0",
            "Sunrise/Sunset" to "07:49 AM/04:51 PM"
        ),
        hourlyWeather = listOf(
            HourUIData(
                temperature = "3.6",
                weatherCondition = weatherCondition,
                time = "02:45"
            )
        )
    )

    val weeklyWeatherUIData = WeeklyWeatherUIData(
        forecast = listOf(weatherUIData)
    )
}
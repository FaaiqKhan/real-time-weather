package com.practice.realtimeweather.testData

import com.practice.realtimeweather.model.*
import com.practice.realtimeweather.model.network.*
import com.practice.realtimeweather.model.ui.*

object TestData {

    const val days = "7"
    const val country = "Berlin"
    const val endDate = "2024-02-1"
    const val startDate = "2024-01-18"
    const val errorMessage = "Oops something went wrong, try again later"

    private val location = Location(
        name = "Berlin",
        region = "Berlin",
        country = "Germany",
        tzId = "Europe/Berlin",
        localtimeEpoch = 1706795124,
        localtime = "2024-02-01 14:45",
    )

    private val condition = Condition(
        text = "Sunny",
        icon = "//cdn.weatherapi.com/weather/64x64/day/113.png",
        code = 1000
    )

    private val current = Current(
        lastUpdatedEpoch = 1706535900,
        lastUpdated = "2024-01-29 14:45",
        tempCelsius = 10.0,
        tempFahrenheit = 50.0,
        condition = condition,
        windMph = 9.4,
        windKph = 15.1,
        windDegree = 200,
        windDirection = "SSW",
        pressureMb = 1028.0,
        pressureIn = 30.36,
        precipitationMm = 0.0,
        precipitationIn = 0.0,
        humidity = 43.0,
        feelsLikeCelsius = 8.2,
        feelsLikeFahrenheit = 46.8,
        visibilityKm = 10.0,
        visibilityMiles = 6.0,
        uVIndex = 2.0,
        gustMph = 12.6,
        gustKph = 20.3
    )

    val todayWeather = TodayWeather(
        location = location,
        current = current
    )

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

    private val day = Day(
        maxTemperatureInCelsius = 7.2,
        maxTemperatureInFahrenheit = 45.0,
        minTemperatureInCelsius = 3.5,
        minTemperatureInFahrenheit = 38.3,
        avgTemperatureInCelsius = 5.3,
        avgTemperatureInFahrenheit = 41.6,
        maxWindMph = 17.4,
        maxWindKph = 28.1,
        totalPrecipitationInMM = 1.68,
        totalPrecipitationInInch = 0.07,
        avgVisibilityInKm = 9.3,
        avgVisibilityInMiles = 5.0,
        avgHumidity = 77,
        condition = condition,
        uvIndex = 1.0
    )

    private val astro = Astro(
        sunrise = "07:49 AM",
        sunset = "04:51 PM",
        moonrise = "No moonrise",
        moonset = "09:57 AM"
    )

    private val hour = listOf(
        Hour(
            timeEpoch = 1706535900,
            time = "2024-01-29 14:45",
            temperatureInCelsius = 3.6,
            temperatureInFahrenheit = 38.5,
            condition = condition,
            precipitationInMM = 0.0,
            precipitationInInch = 0.0,
            humidity = 80,
        )
    )

    private val forecastDay = ForecastDay(
        date = "2024-01-29",
        dateEpoch = 1706535900,
        day = day,
        astro = astro,
        hour = hour,
    )

    val weeklyWeather = WeeklyWeather(
        location = location,
        forecast = Forecast(forecastday = listOf(forecastDay))
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

    val todayWeatherDataResultSuccess = TodayWeatherDataResult.Success(
        todayWeatherUIData = todayWeatherUIData
    )

    val todayWeatherDataResultError = TodayWeatherDataResult.Error(
        errorMessage = errorMessage
    )

    val weeklyWeatherDataResultSuccess = WeeklyWeatherDataResult.Success(
        weeklyWeatherUIData = weeklyWeatherUIData
    )

    val weeklyWeatherDataResultError = WeeklyWeatherDataResult.Error(
        errorMessage = errorMessage
    )

}
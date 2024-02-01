package com.practice.realtimeweather.extension

import com.practice.realtimeweather.model.*
import com.practice.realtimeweather.model.ui.*
import com.practice.realtimeweather.utils.Utils
import java.time.format.DateTimeFormatter

fun TodayWeather.toTodayWeatherUIData(): TodayWeatherUIData {
    val formatter = DateTimeFormatter.ofPattern("d MMMM, hh:mm")
    return TodayWeatherUIData(
        currentWeather = CurrentWeather(
            date = Utils.getDateTimeFromEpoch(this.current.lastUpdatedEpoch).format(formatter),
            temperature = this.current.tempCelsius.toString(),
            weatherCondition = WeatherCondition(
                weather = this.current.condition.text,
                image = this.current.condition.icon
            ),
            feelsLike = this.current.feelsLikeCelsius.toString(),
            windSpeed = this.current.windKph.toString(),
            details = mapOf(
                "Humidity" to "${this.current.humidity}%",
                "Visibility" to "${this.current.visibilityKm} Km",
                "UVIndex" to this.current.uVIndex.toString(),
            ),
            rainDetails = mapOf(
                "Volume" to "${this.current.precipitationMm} mm",
            ),
            windDetails = mapOf(
                "Wind Guest" to "${this.current.windKph} Km/h",
                "Wind Direction" to this.current.windDirection
            )
        )
    )
}

fun TodayWeather.toTodayWeatherDataResult(): TodayWeatherDataResult = TodayWeatherDataResult
    .Success(todayWeatherUIData = this.toTodayWeatherUIData())

fun WeeklyWeather.toWeeklyWeatherUIData(): WeeklyWeatherUIData {
    val formatter = DateTimeFormatter.ofPattern("EEEE, d MMM")
    val timeFormatter = DateTimeFormatter.ofPattern("hh:mm")
    return WeeklyWeatherUIData(
        forecast = this.forecast.forecastday.map { forecast ->
            val date = Utils.getDateTimeFromEpoch(forecast.dateEpoch)
            WeatherUIData(
                date = if (Utils.isToday(date)) "Today" else date.format(formatter),
                weatherCondition = WeatherCondition(
                    weather = forecast.day.condition.text,
                    image = forecast.day.condition.icon
                ),
                highTemperature = forecast.day.maxTemperatureInCelsius.toString(),
                lowTemperature = forecast.day.minTemperatureInCelsius.toString(),
                details = mapOf(
                    "Wind" to "${forecast.day.maxWindKph} km/h",
                    "Humidity" to "${forecast.day.avgHumidity}%",
                    "UV Index" to forecast.day.uvIndex.toString(),
                    "Sunrise/Sunset" to "${forecast.astro.sunrise}/${forecast.astro.sunset}"
                ),
                hourlyWeather = forecast.hour.map {
                    HourUIData(
                        temperature = it.temperatureInCelsius.toString(),
                        weatherCondition = WeatherCondition(
                            weather = it.condition.text,
                            image = it.condition.icon
                        ),
                        time = Utils.getDateTimeFromEpoch(it.timeEpoch).format(timeFormatter)
                    )
                }
            )
        }.reversed()
    )
}

fun WeeklyWeather.toWeeklyWeatherDataResult(): WeeklyWeatherDataResult =
    WeeklyWeatherDataResult.Success(weeklyWeatherUIData = this.toWeeklyWeatherUIData())
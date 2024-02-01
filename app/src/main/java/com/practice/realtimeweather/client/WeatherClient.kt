package com.practice.realtimeweather.client

import com.practice.realtimeweather.model.TodayWeatherDataResult
import com.practice.realtimeweather.model.WeeklyWeatherDataResult

interface WeatherClient {

    suspend fun getTodayWeather(country: String): TodayWeatherDataResult

    suspend fun getWeeklyWeatherForecast(country: String, days: String): WeeklyWeatherDataResult

    suspend fun getWeatherHistory(
        country: String,
        startDate: String,
        endDate: String
    ): WeeklyWeatherDataResult
}
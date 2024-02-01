package com.practice.realtimeweather.repository

import com.practice.realtimeweather.model.TodayWeatherDataResult
import com.practice.realtimeweather.model.WeeklyWeatherDataResult

interface WeatherDataRepository {

    suspend fun getTodayWeatherData(country: String): TodayWeatherDataResult

    suspend fun getWeeklyWeatherForecast(country: String, days: String): WeeklyWeatherDataResult

    suspend fun get2WeeksWeatherHistory(
        country: String,
        startDate: String,
        endDate: String
    ): WeeklyWeatherDataResult
}
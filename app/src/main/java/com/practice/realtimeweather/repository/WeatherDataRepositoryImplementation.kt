package com.practice.realtimeweather.repository

import com.practice.realtimeweather.client.WeatherClient
import com.practice.realtimeweather.model.TodayWeatherDataResult
import com.practice.realtimeweather.model.WeeklyWeatherDataResult
import javax.inject.Inject

class WeatherDataRepositoryImplementation @Inject constructor(
    private val weatherClient: WeatherClient
) : WeatherDataRepository {

    override suspend fun getTodayWeatherData(country: String): TodayWeatherDataResult =
        weatherClient.getTodayWeather(country)

    override suspend fun getWeeklyWeatherForecast(
        country: String,
        days: String
    ): WeeklyWeatherDataResult =
        weatherClient.getWeeklyWeatherForecast(country, days)

    override suspend fun getWeatherHistory(
        country: String,
        startDate: String,
        endDate: String
    ): WeeklyWeatherDataResult =
        weatherClient.getWeatherHistory(country, startDate, endDate)
}
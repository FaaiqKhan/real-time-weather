package com.practice.realtimeweather.client

import com.practice.realtimeweather.extension.toTodayWeatherDataResult
import com.practice.realtimeweather.extension.toWeeklyWeatherDataResult
import com.practice.realtimeweather.model.TodayWeatherDataResult
import com.practice.realtimeweather.model.WeeklyWeatherDataResult
import javax.inject.Inject

class WeatherClientImplementation @Inject constructor(
    private val weatherAPIClient: WeatherAPIClient
) : WeatherClient {

    override suspend fun getTodayWeather(country: String): TodayWeatherDataResult =
        try {
            weatherAPIClient.getTodayWeather(country).toTodayWeatherDataResult()
        } catch (throwable: Throwable) {
            TodayWeatherDataResult.Error(errorMessage = throwable.message)
        }

    override suspend fun getWeeklyWeatherForecast(
        country: String,
        days: String
    ): WeeklyWeatherDataResult =
        try {
            weatherAPIClient.getNextWeekWeather(country, days).toWeeklyWeatherDataResult()
        } catch (throwable: Throwable) {
            WeeklyWeatherDataResult.Error(throwable.message)
        }

    override suspend fun getWeatherHistory(
        country: String,
        startDate: String,
        endDate: String
    ): WeeklyWeatherDataResult =
        try {
            weatherAPIClient.getWeatherHistory(country, startDate, endDate)
                .toWeeklyWeatherDataResult()
        } catch (throwable: Throwable) {
            WeeklyWeatherDataResult.Error(throwable.message)
        }
}
package com.practice.realtimeweather.client

import com.practice.realtimeweather.model.network.TodayWeather
import com.practice.realtimeweather.model.network.WeeklyWeather
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPIClient {

    @GET("current.json")
    suspend fun getTodayWeather(@Query("q") country: String): TodayWeather

    @GET("forecast.json")
    suspend fun getNextWeekWeather(
        @Query("q") country: String,
        @Query("days") days: String
    ): WeeklyWeather

    @GET("history.json")
    suspend fun getWeatherHistory(
        @Query("q") country: String,
        @Query("dt") startDate: String,
        @Query("end_dt") endDate: String
    ): WeeklyWeather
}
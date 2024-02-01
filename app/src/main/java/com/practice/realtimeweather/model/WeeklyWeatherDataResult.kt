package com.practice.realtimeweather.model

import com.practice.realtimeweather.model.ui.WeeklyWeatherUIData

sealed class WeeklyWeatherDataResult {
    data class Success(val weeklyWeatherUIData: WeeklyWeatherUIData) : WeeklyWeatherDataResult()
    data class Error(val errorMessage: String?) : WeeklyWeatherDataResult()
}

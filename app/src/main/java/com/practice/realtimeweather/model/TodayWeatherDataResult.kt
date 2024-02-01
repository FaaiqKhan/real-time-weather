package com.practice.realtimeweather.model

import com.practice.realtimeweather.model.ui.TodayWeatherUIData

sealed class TodayWeatherDataResult {
    data class Success(val todayWeatherUIData: TodayWeatherUIData): TodayWeatherDataResult()
    data class Error(val errorMessage: String?): TodayWeatherDataResult()
}
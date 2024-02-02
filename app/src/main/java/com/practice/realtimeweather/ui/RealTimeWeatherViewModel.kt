package com.practice.realtimeweather.ui

import androidx.annotation.OpenForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.realtimeweather.model.TodayWeatherDataResult
import com.practice.realtimeweather.model.WeeklyWeatherDataResult
import com.practice.realtimeweather.model.ui.TodayWeatherUIData
import com.practice.realtimeweather.model.ui.WeeklyWeatherUIData
import com.practice.realtimeweather.repository.WeatherDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

private const val COUNTRY = "Berlin"
private const val DAYS = "7"
private const val DATE_FORMAT = "yyyy-MM-dd"

@HiltViewModel
open class RealTimeWeatherViewModel @Inject constructor(
    private val realtimeweatherRepository: WeatherDataRepository
) : ViewModel() {

    private val todayWeatherViewState = MutableStateFlow<ViewState>(ViewState.Loading)
    fun getTodayWeatherViewState() = todayWeatherViewState.asStateFlow()

    private val weeklyWeatherForecastViewState = MutableStateFlow<ViewState>(ViewState.Loading)
    fun getWeeklyWeatherForecastViewState() = weeklyWeatherForecastViewState.asStateFlow()

    private val weeklyWeatherHistoryViewState = MutableStateFlow<ViewState>(ViewState.Loading)
    fun getWeeklyWeatherHistoryViewState() = weeklyWeatherHistoryViewState.asStateFlow()

    init {
        getTodayWeatherStatus()
        getNextWeekWeatherData()
        getWeatherHistoryData()
    }

    private fun getTodayWeatherStatus() {
        viewModelScope.launch {
            val result = realtimeweatherRepository.getTodayWeatherData(COUNTRY)
            todayWeatherViewState.value = when (result) {
                is TodayWeatherDataResult.Error -> {
                    ViewState.Error(result.errorMessage)
                }

                is TodayWeatherDataResult.Success -> {
                    ViewState.TodayWeatherDataLoaded(weatherData = result.todayWeatherUIData)
                }
            }
        }
    }

    private fun getNextWeekWeatherData() {
        viewModelScope.launch {
            val result = realtimeweatherRepository.getWeeklyWeatherForecast(COUNTRY, DAYS)
            weeklyWeatherForecastViewState.value = when (result) {
                is WeeklyWeatherDataResult.Error -> {
                    ViewState.Error(result.errorMessage)
                }

                is WeeklyWeatherDataResult.Success -> {
                    ViewState.WeeklyWeatherDataLoaded(weeklyWeatherData = result.weeklyWeatherUIData)
                }
            }
        }
    }

    private fun getWeatherHistoryData() {
        val formatter = DateTimeFormatter.ofPattern(DATE_FORMAT)
        val currentData = LocalDate.now()
        val last2Weeks = currentData.minusWeeks(2)

        viewModelScope.launch {
            val result = realtimeweatherRepository.getWeatherHistory(
                country = COUNTRY,
                startDate = last2Weeks.format(formatter),
                endDate = currentData.format(formatter),
            )
            weeklyWeatherHistoryViewState.value = when (result) {
                is WeeklyWeatherDataResult.Error -> {
                    ViewState.Error(result.errorMessage)
                }

                is WeeklyWeatherDataResult.Success -> {
                    ViewState.WeeklyWeatherDataLoaded(
                        weeklyWeatherData = result.weeklyWeatherUIData
                    )
                }
            }
        }
    }

    sealed interface ViewState {
        data object Loading : ViewState
        data class TodayWeatherDataLoaded(val weatherData: TodayWeatherUIData) : ViewState
        data class WeeklyWeatherDataLoaded(val weeklyWeatherData: WeeklyWeatherUIData) : ViewState
        data class Error(val errorMessage: String?) : ViewState
    }
}
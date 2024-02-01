package com.practice.realtimeweather.ui

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

@HiltViewModel
class RealTimeWeatherViewModel @Inject constructor(
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
        getLast2WeeksWeatherData()
    }

    private fun getTodayWeatherStatus() {
        viewModelScope.launch {
            val result = realtimeweatherRepository.getTodayWeatherData("Berlin")
            todayWeatherViewState.value = when (result) {
                is TodayWeatherDataResult.Error -> {
                    ViewState.Error(result.errorMessage ?: "Error")
                }

                is TodayWeatherDataResult.Success -> {
                    ViewState.TodayWeatherDataLoaded(weatherData = result.todayWeatherUIData)
                }
            }
        }
    }

    private fun getNextWeekWeatherData() {
        viewModelScope.launch {
            val result = realtimeweatherRepository.getWeeklyWeatherForecast("Berlin", "7")
            weeklyWeatherForecastViewState.value = when (result) {
                is WeeklyWeatherDataResult.Error -> {
                    ViewState.Error(result.errorMessage ?: "Error")
                }

                is WeeklyWeatherDataResult.Success -> {
                    ViewState.WeeklyWeatherDataLoaded(weeklyWeatherData = result.weeklyWeatherUIData)
                }
            }
        }
    }

    private fun getLast2WeeksWeatherData() {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val currentData = LocalDate.now()
        val last2Weeks = currentData.minusWeeks(2)

        viewModelScope.launch {
            val result = realtimeweatherRepository.get2WeeksWeatherHistory(
                country = "Berlin",
                startDate = last2Weeks.format(formatter),
                endDate = currentData.format(formatter),
            )
            weeklyWeatherHistoryViewState.value = when (result) {
                is WeeklyWeatherDataResult.Error -> {
                    ViewState.Error(result.errorMessage ?: "Error")
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
        data class Error(val errorMessage: String) : ViewState
    }
}
package com.practice.realtimeweather.ui

import com.practice.realtimeweather.repository.WeatherDataRepository
import com.practice.realtimeweather.testData.TestData
import io.mockk.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import java.time.LocalDate
import java.time.format.DateTimeFormatter

abstract class RealTimeWeatherViewModelBaseTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val dispatcher: TestDispatcher = UnconfinedTestDispatcher()

    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    private val currentData = LocalDate.now()
    private val last2Weeks = currentData.minusWeeks(2)

    protected val startDate : String = last2Weeks.format(formatter)
    protected val endDate : String = currentData.format(formatter)

    protected val weatherRepository: WeatherDataRepository = mockk {
        coEvery { getTodayWeatherData(TestData.country) } just awaits
        coEvery { getWeeklyWeatherForecast(TestData.country, TestData.days) } just awaits
        coEvery { getWeatherHistory(TestData.country, startDate, endDate) } just awaits
    }

    protected val viewModel by lazy { RealTimeWeatherViewModel(weatherRepository) }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun start() {
        Dispatchers.setMain(dispatcher)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun end() {
        Dispatchers.resetMain()
    }
}
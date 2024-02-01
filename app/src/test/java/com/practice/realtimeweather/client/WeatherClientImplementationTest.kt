package com.practice.realtimeweather.client

import com.practice.realtimeweather.model.TodayWeatherDataResult
import com.practice.realtimeweather.model.WeeklyWeatherDataResult
import com.practice.realtimeweather.testData.TestData
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test

class WeatherClientImplementationTest {

    private val apiClient: WeatherAPIClient = mockk()

    private val weatherClient = WeatherClientImplementation(apiClient)

    @Test
    fun `getTodayWeather should return success when api succeeds`() = runTest {
        // given
        val country = "Berlin"
        coEvery { apiClient.getTodayWeather(country) } returns TestData.todayWeather

        // when
        val result = weatherClient.getTodayWeather(country)

        // then
        result shouldBe TodayWeatherDataResult.Success(
            todayWeatherUIData = TestData.todayWeatherUIData
        )
    }

    @Test
    fun `getTodayWeather should return error when api fails`() = runTest {
        // given
        val country = "Berlin"
        val errorMessage = "Invalid api key"
        coEvery { apiClient.getTodayWeather(country) } throws Exception(errorMessage)

        // when
        val result = weatherClient.getTodayWeather(country)

        // then
        result shouldBe TodayWeatherDataResult.Error(
            errorMessage = errorMessage
        )
    }

    @Test
    fun `getWeeklyWeatherForecast should return success when api succeeds`() = runTest {
        // given
        val country = "Berlin"
        val days = "7"
        coEvery { apiClient.getNextWeekWeather(country, days) } returns TestData.weeklyWeather

        // when
        val result = weatherClient.getWeeklyWeatherForecast(country, days)

        // then
        result shouldBe WeeklyWeatherDataResult.Success(
            weeklyWeatherUIData = TestData.weeklyWeatherUIData
        )
    }

    @Test
    fun `getWeeklyWeatherForecast should return error when api fails`() = runTest {
        // given
        val country = "Berlin"
        val days = "7"
        val errorMessage = "Invalid api key"
        coEvery { apiClient.getNextWeekWeather(country, days) } throws Exception(errorMessage)

        // when
        val result = weatherClient.getWeeklyWeatherForecast(country, days)

        // then
        result shouldBe WeeklyWeatherDataResult.Error(
            errorMessage = errorMessage
        )
    }

    @Test
    fun `getWeatherHistory should return success when api succeeds`() = runTest {
        // given
        val country = "Berlin"
        val endDate = "2024-02-1"
        val startDate = "2024-01-18"
        coEvery {
            apiClient.getWeatherHistory(country, startDate, endDate)
        } returns TestData.weeklyWeather

        // when
        val result = weatherClient.getWeatherHistory(country, startDate, endDate)

        // then
        result shouldBe WeeklyWeatherDataResult.Success(
            weeklyWeatherUIData = TestData.weeklyWeatherUIData
        )
    }

    @Test
    fun `getWeatherHistory should return error when api fails`() = runTest {
        // given
        val country = "Berlin"
        val endDate = "2024-02-1"
        val startDate = "2024-01-18"
        val errorMessage = "Invalid api key"
        coEvery {
            apiClient.getWeatherHistory(country, startDate, endDate)
        } throws Exception(errorMessage)

        // when
        val result = weatherClient.getWeatherHistory(country, startDate, endDate)

        // then
        result shouldBe WeeklyWeatherDataResult.Error(
            errorMessage = errorMessage
        )
    }

}
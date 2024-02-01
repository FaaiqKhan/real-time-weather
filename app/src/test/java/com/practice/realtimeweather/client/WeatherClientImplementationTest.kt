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
        coEvery { apiClient.getTodayWeather(TestData.country) } returns TestData.todayWeather

        // when
        val result = weatherClient.getTodayWeather(TestData.country)

        // then
        result shouldBe TodayWeatherDataResult.Success(
            todayWeatherUIData = TestData.todayWeatherUIData
        )
    }

    @Test
    fun `getTodayWeather should return error when api fails`() = runTest {
        // given
        coEvery { apiClient.getTodayWeather(TestData.country) } throws Exception(TestData.errorMessage)

        // when
        val result = weatherClient.getTodayWeather(TestData.country)

        // then
        result shouldBe TodayWeatherDataResult.Error(
            errorMessage = TestData.errorMessage
        )
    }

    @Test
    fun `getWeeklyWeatherForecast should return success when api succeeds`() = runTest {
        // given
        coEvery {
            apiClient.getNextWeekWeather(
                TestData.country,
                TestData.days
            )
        } returns TestData.weeklyWeather

        // when
        val result = weatherClient.getWeeklyWeatherForecast(TestData.country, TestData.days)

        // then
        result shouldBe WeeklyWeatherDataResult.Success(
            weeklyWeatherUIData = TestData.weeklyWeatherUIData
        )
    }

    @Test
    fun `getWeeklyWeatherForecast should return error when api fails`() = runTest {
        // given
        coEvery {
            apiClient.getNextWeekWeather(
                TestData.country,
                TestData.days
            )
        } throws Exception(TestData.errorMessage)

        // when
        val result = weatherClient.getWeeklyWeatherForecast(TestData.country, TestData.days)

        // then
        result shouldBe WeeklyWeatherDataResult.Error(
            errorMessage = TestData.errorMessage
        )
    }

    @Test
    fun `getWeatherHistory should return success when api succeeds`() = runTest {
        // given
        coEvery {
            apiClient.getWeatherHistory(TestData.country, TestData.startDate, TestData.endDate)
        } returns TestData.weeklyWeather

        // when
        val result =
            weatherClient.getWeatherHistory(TestData.country, TestData.startDate, TestData.endDate)

        // then
        result shouldBe WeeklyWeatherDataResult.Success(
            weeklyWeatherUIData = TestData.weeklyWeatherUIData
        )
    }

    @Test
    fun `getWeatherHistory should return error when api fails`() = runTest {
        // given
        coEvery {
            apiClient.getWeatherHistory(TestData.country, TestData.startDate, TestData.endDate)
        } throws Exception(TestData.errorMessage)

        // when
        val result =
            weatherClient.getWeatherHistory(TestData.country, TestData.startDate, TestData.endDate)

        // then
        result shouldBe WeeklyWeatherDataResult.Error(
            errorMessage = TestData.errorMessage
        )
    }

}
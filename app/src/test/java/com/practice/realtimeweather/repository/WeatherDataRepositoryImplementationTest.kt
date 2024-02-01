package com.practice.realtimeweather.repository

import com.practice.realtimeweather.client.WeatherClient
import com.practice.realtimeweather.testData.TestData
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test

class WeatherDataRepositoryImplementationTest {

    private val weatherClient: WeatherClient = mockk()

    private val weatherDataRepository = WeatherDataRepositoryImplementation(weatherClient)

    @Test
    fun `getTodayWeatherData should return success when client return success`() = runTest {
        // given
        coEvery {
            weatherClient.getTodayWeather(TestData.country)
        } returns TestData.todayWeatherDataResultSuccess

        // when
        val result = weatherDataRepository.getTodayWeatherData(TestData.country)

        // then
        result shouldBe TestData.todayWeatherDataResultSuccess
    }

    @Test
    fun `getTodayWeatherData should return error when client return error`() = runTest {
        // given
        coEvery {
            weatherClient.getTodayWeather(TestData.country)
        } returns TestData.todayWeatherDataResultError

        // when
        val result = weatherDataRepository.getTodayWeatherData(TestData.country)

        // then
        result shouldBe TestData.todayWeatherDataResultError
    }

    @Test
    fun `getWeeklyWeatherForecast should return success when client return success`() = runTest {
        // given
        coEvery {
            weatherClient.getWeeklyWeatherForecast(TestData.country, TestData.days)
        } returns TestData.weeklyWeatherDataResultSuccess

        // when
        val result = weatherDataRepository.getWeeklyWeatherForecast(TestData.country, TestData.days)

        // then
        result shouldBe TestData.weeklyWeatherDataResultSuccess
    }

    @Test
    fun `getWeeklyWeatherForecast should return error when client return error`() = runTest {
        // given
        coEvery {
            weatherClient.getWeeklyWeatherForecast(TestData.country, TestData.days)
        } returns TestData.weeklyWeatherDataResultError

        // when
        val result = weatherDataRepository.getWeeklyWeatherForecast(TestData.country, TestData.days)

        // then
        result shouldBe TestData.weeklyWeatherDataResultError
    }

    @Test
    fun `getWeatherHistory should return success when client return success`() = runTest {
        // given
        coEvery {
            weatherClient.getWeatherHistory(TestData.country, TestData.startDate, TestData.endDate)
        } returns TestData.weeklyWeatherDataResultSuccess

        // when
        val result = weatherDataRepository.getWeatherHistory(
            TestData.country,
            TestData.startDate,
            TestData.endDate
        )

        // then
        result shouldBe TestData.weeklyWeatherDataResultSuccess
    }

    @Test
    fun `getWeatherHistory should return error when client return error`() = runTest {
        // given
        coEvery {
            weatherClient.getWeatherHistory(TestData.country, TestData.startDate, TestData.endDate)
        } returns TestData.weeklyWeatherDataResultError

        // when
        val result = weatherDataRepository.getWeatherHistory(
            TestData.country,
            TestData.startDate,
            TestData.endDate
        )

        // then
        result shouldBe TestData.weeklyWeatherDataResultError
    }

}
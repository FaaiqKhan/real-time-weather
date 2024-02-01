package com.practice.realtimeweather.ui

import app.cash.turbine.test
import com.practice.realtimeweather.testData.TestData
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import kotlinx.coroutines.test.runTest
import org.junit.Test

class RealTimeWeatherViewModelWeeklyWeatherForecastViewStateTest :
    RealTimeWeatherViewModelBaseTest() {

    @Test
    fun `weeklyWeatherForecastViewState should emit ViewState#Loading initially`() = runTest {
        // when
        viewModel.getWeeklyWeatherForecastViewState().test {

            // then
            awaitItem() shouldBe RealTimeWeatherViewModel.ViewState.Loading
        }
    }

    @Test
    fun `weeklyWeatherForecastViewState should emit ViewState#WeeklyWeatherDataLoaded when getWeeklyWeatherForecast return success`() =
        runTest {
            // given
            coEvery {
                weatherRepository.getWeeklyWeatherForecast(TestData.country, TestData.days)
            } returns TestData.weeklyWeatherDataResultSuccess

            // when
            viewModel.getWeeklyWeatherForecastViewState().test {

                // then
                awaitItem() shouldBe RealTimeWeatherViewModel.ViewState.WeeklyWeatherDataLoaded(
                    weeklyWeatherData = TestData.weeklyWeatherUIData
                )
            }
        }

    @Test
    fun `weeklyWeatherForecastViewState should emit ViewState#Error when getWeeklyWeatherForecast return error`() =
        runTest {
            // given
            coEvery {
                weatherRepository.getWeeklyWeatherForecast(TestData.country, TestData.days)
            } returns TestData.weeklyWeatherDataResultError

            // when
            viewModel.getWeeklyWeatherForecastViewState().test {

                // then
                awaitItem() shouldBe RealTimeWeatherViewModel.ViewState.Error(
                    errorMessage = TestData.errorMessage
                )
            }
        }
}
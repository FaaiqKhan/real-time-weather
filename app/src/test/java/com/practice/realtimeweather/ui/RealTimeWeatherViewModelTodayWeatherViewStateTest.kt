package com.practice.realtimeweather.ui

import app.cash.turbine.test
import com.practice.realtimeweather.testData.TestData
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import kotlinx.coroutines.test.runTest
import org.junit.Test

class RealTimeWeatherViewModelTodayWeatherViewStateTest : RealTimeWeatherViewModelBaseTest() {

    @Test
    fun `todayWeatherViewState should emit ViewState#Loading initially`() = runTest {
        // when
        viewModel.getTodayWeatherViewState().test {

            // then
            awaitItem() shouldBe RealTimeWeatherViewModel.ViewState.Loading
        }
    }

    @Test
    fun `todayWeatherViewState should emit ViewState#TodayWeatherDataLoaded when getTodayWeatherData return success`() =
        runTest {
            // given
            coEvery {
                weatherRepository.getTodayWeatherData(TestData.country)
            } returns TestData.todayWeatherDataResultSuccess

            // when
            viewModel.getTodayWeatherViewState().test {

                // then
                awaitItem() shouldBe RealTimeWeatherViewModel.ViewState.TodayWeatherDataLoaded(
                    weatherData = TestData.todayWeatherUIData
                )
            }
        }

    @Test
    fun `todayWeatherViewState should emit ViewState#Error when getTodayWeatherData return error`() =
        runTest {
            // given
            coEvery {
                weatherRepository.getTodayWeatherData(TestData.country)
            } returns TestData.todayWeatherDataResultError

            // when
            viewModel.getTodayWeatherViewState().test {

                // then
                awaitItem() shouldBe RealTimeWeatherViewModel.ViewState.Error(
                    errorMessage = TestData.errorMessage
                )
            }
        }
}
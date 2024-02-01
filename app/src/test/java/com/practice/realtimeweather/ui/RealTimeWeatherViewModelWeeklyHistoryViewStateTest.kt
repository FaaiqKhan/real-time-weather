package com.practice.realtimeweather.ui

import app.cash.turbine.test
import com.practice.realtimeweather.testData.TestData
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import kotlinx.coroutines.test.runTest
import org.junit.Test

class RealTimeWeatherViewModelWeeklyHistoryViewStateTest : RealTimeWeatherViewModelBaseTest() {

    @Test
    fun `weeklyWeatherHistoryViewState should emit ViewState#Loading initially`() = runTest {
        // when
        viewModel.getWeeklyWeatherHistoryViewState().test {

            // then
            awaitItem() shouldBe RealTimeWeatherViewModel.ViewState.Loading
        }
    }

    @Test
    fun `weeklyWeatherHistoryViewState should emit ViewState#WeeklyWeatherDataLoaded when getWeatherHistory return success`() =
        runTest {
            // given
            coEvery {
                weatherRepository.getWeatherHistory(
                    TestData.country,
                    TestData.startDate,
                    TestData.endDate,
                )
            } returns TestData.weeklyWeatherDataResultSuccess

            // when
            viewModel.getWeeklyWeatherHistoryViewState().test {

                // then
                awaitItem() shouldBe RealTimeWeatherViewModel.ViewState.WeeklyWeatherDataLoaded(
                    weeklyWeatherData = TestData.weeklyWeatherUIData
                )
            }
        }

    @Test
    fun `weeklyWeatherHistoryViewState should emit ViewState#Error when getWeatherHistory return error`() =
        runTest {
            // given

            coEvery {
                weatherRepository.getWeatherHistory(
                    TestData.country,
                    startDate,
                    endDate,
                )
            } returns TestData.weeklyWeatherDataResultError

            // when
            viewModel.getWeeklyWeatherHistoryViewState().test {

                // then
                awaitItem() shouldBe RealTimeWeatherViewModel.ViewState.Error(
                    errorMessage = TestData.errorMessage
                )
            }
        }
}
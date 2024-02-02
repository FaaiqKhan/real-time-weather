package com.practice.realtimeweather.ui

import com.practice.realtimeweather.extension.assertHasTestTagIsDisplayed
import com.practice.realtimeweather.extension.assertHasTextIsDisplayed
import com.practice.realtimeweather.R
import com.practice.realtimeweather.testdata.TestData
import com.practice.realtimeweather.ui.common.TestTag
import com.practice.realtimeweather.ui.theme.RealTimeWeatherTheme
import com.practice.realtimeweather.ui.todayweatherview.TodayWeatherView
import org.junit.Test

class TodayWeatherViewTest : RealTimeWeatherViewBaseTest() {

    @Test
    fun shouldShowLoadingState() {
        composeTestRule.setContent {
            RealTimeWeatherTheme {
                TodayWeatherView(viewState = RealTimeWeatherViewModel.ViewState.Loading)
            }
        }

        composeTestRule.assertHasTestTagIsDisplayed(TestTag.loaderTag)
    }

    @Test
    fun shouldShowLoadedState() {
        composeTestRule.setContent {
            RealTimeWeatherTheme {
                TodayWeatherView(
                    viewState = RealTimeWeatherViewModel.ViewState.TodayWeatherDataLoaded(
                        weatherData = TestData.todayWeatherUIData
                    )
                )
            }
        }

        with(composeTestRule) {
            assertHasTextIsDisplayed(TestData.todayWeatherUIData.currentWeather.date)
            assertHasTextIsDisplayed(TestData.todayWeatherUIData.currentWeather.temperature + context.getString(R.string.celsius_symbol))
            assertHasTextIsDisplayed(context.getString(R.string.feels_like, TestData.todayWeatherUIData.currentWeather.feelsLike))
            assertHasTextIsDisplayed(TestData.todayWeatherUIData.currentWeather.windSpeed)
        }
    }

    @Test
    fun shouldShowErrorState() {
        composeTestRule.setContent {
            RealTimeWeatherTheme {
                TodayWeatherView(
                    viewState = RealTimeWeatherViewModel.ViewState.Error(
                        errorMessage = TestData.errorMessage
                    )
                )
            }
        }

        composeTestRule.assertHasTextIsDisplayed(TestData.errorMessage)
    }
}
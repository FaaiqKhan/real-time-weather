package com.practice.realtimeweather.ui

import com.practice.realtimeweather.R
import com.practice.realtimeweather.extension.assertHasTestTagIsDisplayed
import com.practice.realtimeweather.extension.assertHasTextIsDisplayed
import com.practice.realtimeweather.testdata.TestData
import com.practice.realtimeweather.ui.common.TestTag
import com.practice.realtimeweather.ui.theme.RealTimeWeatherTheme
import com.practice.realtimeweather.ui.weeklyweatherview.WeeklyWeatherView
import org.junit.Test

class WeeklyWeatherViewTest: RealTimeWeatherViewBaseTest() {

    @Test
    fun shouldShowLoadingState() {
        composeTestRule.setContent {
            RealTimeWeatherTheme {
                WeeklyWeatherView(viewState = RealTimeWeatherViewModel.ViewState.Loading)
            }
        }

        composeTestRule.assertHasTestTagIsDisplayed(TestTag.loaderTag)
    }

    @Test
    fun shouldShowLoadedState() {
        composeTestRule.setContent {
            RealTimeWeatherTheme {
                WeeklyWeatherView(
                    viewState = RealTimeWeatherViewModel.ViewState.WeeklyWeatherDataLoaded(
                        weeklyWeatherData = TestData.weeklyWeatherUIData
                    )
                )
            }
        }

        with(composeTestRule) {
            assertHasTextIsDisplayed(TestData.weeklyWeatherUIData.forecast[0].date)
            assertHasTextIsDisplayed(TestData.weeklyWeatherUIData.forecast[0].weatherCondition.weather)
            assertHasTextIsDisplayed(TestData.weeklyWeatherUIData.forecast[0].highTemperature
                + context.getString(R.string.degree_symbol))
            assertHasTextIsDisplayed(TestData.weeklyWeatherUIData.forecast[0].lowTemperature
                + context.getString(R.string.degree_symbol))
        }
    }

    @Test
    fun shouldShowErrorState() {
        composeTestRule.setContent {
            RealTimeWeatherTheme {
                WeeklyWeatherView(
                    viewState = RealTimeWeatherViewModel.ViewState.Error(
                        errorMessage = TestData.errorMessage
                    )
                )
            }
        }

        composeTestRule.assertHasTextIsDisplayed(TestData.errorMessage)
    }
}
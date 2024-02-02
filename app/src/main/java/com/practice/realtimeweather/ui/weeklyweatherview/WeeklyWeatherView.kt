package com.practice.realtimeweather.ui.weeklyweatherview

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.practice.realtimeweather.R
import com.practice.realtimeweather.model.ui.*
import com.practice.realtimeweather.ui.RealTimeWeatherViewModel
import com.practice.realtimeweather.ui.common.FullScreenLoader
import com.practice.realtimeweather.ui.theme.RealTimeWeatherTheme

@Composable
fun WeeklyWeatherView(
    modifier: Modifier = Modifier,
    viewState: RealTimeWeatherViewModel.ViewState
) {
    when (viewState) {
        RealTimeWeatherViewModel.ViewState.Loading -> FullScreenLoader(modifier = modifier)

        is RealTimeWeatherViewModel.ViewState.WeeklyWeatherDataLoaded -> WeeklyWeatherLoadedView(
            modifier = modifier,
            weeklyWeatherData = viewState.weeklyWeatherData
        )

        is RealTimeWeatherViewModel.ViewState.Error ->
            Text(text = viewState.errorMessage
                ?: stringResource(id = R.string.common_error)
            )

        else -> Text(text = "Error Invalid State")
    }
}

@Composable
private fun WeeklyWeatherLoadedView(modifier: Modifier, weeklyWeatherData: WeeklyWeatherUIData) {
    LazyColumn(modifier = modifier) {
        items(weeklyWeatherData.forecast) { DetailedWeatherView(it) }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewWeeklyWeatherView() {
    RealTimeWeatherTheme {
        WeeklyWeatherView(
            viewState = RealTimeWeatherViewModel.ViewState.WeeklyWeatherDataLoaded(
                weeklyWeatherData = WeeklyWeatherUIData(
                    forecast = listOf(
                        WeatherUIData(
                            date = "Today",
                            weatherCondition = WeatherCondition(
                                weather = "Sunny",
                                image = "",
                            ),
                            highTemperature = "8",
                            lowTemperature = "5",
                            details = mapOf(
                                "Humidity" to "10%",
                                "Visibility" to "10Km",
                                "UVIndex" to "12",
                            ),
                            hourlyWeather = listOf(
                                HourUIData(
                                    temperature = "7",
                                    weatherCondition = WeatherCondition(
                                        weather = "Rain",
                                        image = ""
                                    ),
                                    time = "11:00"
                                ),
                                HourUIData(
                                    temperature = "7",
                                    weatherCondition = WeatherCondition(
                                        weather = "Rain",
                                        image = ""
                                    ),
                                    time = "11:00"
                                ),
                                HourUIData(
                                    temperature = "7",
                                    weatherCondition = WeatherCondition(
                                        weather = "Rain",
                                        image = ""
                                    ),
                                    time = "11:00"
                                ),
                                HourUIData(
                                    temperature = "7",
                                    weatherCondition = WeatherCondition(
                                        weather = "Rain",
                                        image = ""
                                    ),
                                    time = "11:00"
                                )
                            )
                        )
                    )
                )
            )
        )
    }
}
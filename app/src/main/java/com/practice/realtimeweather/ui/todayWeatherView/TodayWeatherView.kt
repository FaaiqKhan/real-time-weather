package com.practice.realtimeweather.ui.todayWeatherView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.practice.realtimeweather.R
import com.practice.realtimeweather.model.ui.*
import com.practice.realtimeweather.ui.RealTimeWeatherViewModel
import com.practice.realtimeweather.ui.theme.RealTimeWeatherTheme
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@Composable
fun TodayWeatherView(modifier: Modifier = Modifier, viewState: RealTimeWeatherViewModel.ViewState) {
    when (viewState) {
        RealTimeWeatherViewModel.ViewState.Loading -> Box(
            modifier = modifier,
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }

        is RealTimeWeatherViewModel.ViewState.TodayWeatherDataLoaded -> TodayWeatherLoadedView(
            modifier = modifier,
            weatherData = viewState.weatherData
        )

        is RealTimeWeatherViewModel.ViewState.Error -> Text(text = viewState.errorMessage)
        else -> Text(text = "Error Invalid State")
    }
}

@Composable
private fun TodayWeatherLoadedView(modifier: Modifier, weatherData: TodayWeatherUIData) {
    val data = weatherData.currentWeather

    Column(modifier = modifier.background(color = Color.Blue.copy(alpha = 0.2f))) {
        Column(
            modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.screen_horizontal_padding))
        ) {
            Text(
                text = data.date,
                style = MaterialTheme.typography.headlineSmall
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.weather_details_height)),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = data.temperature + stringResource(id = R.string.celsius_symbol),
                        style = MaterialTheme.typography.displayLarge
                    )
                    Text(
                        text = stringResource(R.string.feels_like, data.feelsLike) + stringResource(
                            id = R.string.degree_symbol
                        ),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    AsyncImage(
                        model = data.weatherCondition.getImage(),
                        contentScale = ContentScale.Fit,
                        contentDescription = stringResource(id = R.string.weather_condition_icon),
                        modifier = Modifier.size(dimensionResource(id = R.dimen.weather_icon_size)),
                    )
                    Text(
                        text = data.weatherCondition.weather,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.LightGray.copy(alpha = 0.4f))
        ) {
            Column(
                modifier = Modifier.padding(
                    vertical = dimensionResource(id = R.dimen.content_padding_large),
                    horizontal = dimensionResource(id = R.dimen.screen_horizontal_padding)
                )
            ) {
                Text(
                    text = stringResource(id = R.string.current_details),
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.content_padding_large))
                )
                for (entry in data.details.entries.iterator()) {
                    TableView(title = entry.key, description = entry.value)
                }
            }
            Divider()
            Column(
                modifier = Modifier.padding(
                    vertical = dimensionResource(id = R.dimen.content_padding_large),
                    horizontal = dimensionResource(id = R.dimen.screen_horizontal_padding)
                )
            ) {
                Text(
                    text = stringResource(id = R.string.precipitation),
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.content_padding_large))
                )
                for (entry in data.rainDetails.entries.iterator()) {
                    TableView(title = entry.key, description = entry.value)
                }
            }
            Divider()
            Column(
                modifier = Modifier.padding(
                    vertical = dimensionResource(id = R.dimen.content_padding_large),
                    horizontal = dimensionResource(id = R.dimen.screen_horizontal_padding)
                )
            ) {
                Text(
                    text = stringResource(id = R.string.wind),
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.content_padding_large))
                )
                Row(
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(text = data.windSpeed, style = MaterialTheme.typography.displayMedium)
                    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.content_padding_small)))
                    Text(
                        stringResource(R.string.km_h),
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(
                            bottom = dimensionResource(id = R.dimen.font_padding)
                        )
                    )
                }
                for (entry in data.windDetails.entries.iterator()) {
                    TableView(title = entry.key, description = entry.value)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewTodayWeatherViewLoaded() {
    val date = Instant
        .ofEpochMilli(1706535900)
        .atZone(ZoneId.systemDefault())
        .toLocalDateTime()
    val formatter = DateTimeFormatter.ofPattern("d MMMM, hh:mm")
    RealTimeWeatherTheme {
        TodayWeatherView(
            modifier = Modifier.fillMaxSize(),
            viewState = RealTimeWeatherViewModel.ViewState.TodayWeatherDataLoaded(
                weatherData = TodayWeatherUIData(
                    currentWeather = CurrentWeather(
                        date = date.format(formatter),
                        temperature = "10",
                        weatherCondition = WeatherCondition(
                            weather = "Sunny",
                            image = ""
                        ),
                        feelsLike = "5",
                        windSpeed = "11",
                        details = mapOf(
                            "Humidity" to "10%",
                            "Visibility" to "10Km",
                            "UVIndex" to "12",
                        ),
                        rainDetails = mapOf(
                            "Volume" to "30mm"
                        ),
                        windDetails = mapOf(
                            "Wind Guest" to "10Km/h",
                            "Wind Direction" to "SSW"
                        )
                    )
                )
            )
        )
    }
}
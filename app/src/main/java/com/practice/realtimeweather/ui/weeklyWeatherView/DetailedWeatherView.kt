package com.practice.realtimeweather.ui.weeklyWeatherView

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.practice.realtimeweather.R
import com.practice.realtimeweather.model.ui.*
import com.practice.realtimeweather.ui.common.HourlyWeatherView
import com.practice.realtimeweather.ui.theme.RealTimeWeatherTheme

@Composable
fun DetailedWeatherView(dayWeatherDetails: WeatherUIData) {
    var showDetails by remember { mutableStateOf(false) }

    Column {
        TextButton(
            onClick = { showDetails = !showDetails },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(0),
        ) {
            Column {
                Text(
                    text = dayWeatherDetails.date,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black
                )
                Text(
                    text = dayWeatherDetails.weatherCondition.weather,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(verticalAlignment = Alignment.CenterVertically) {
                AsyncImage(
                    model = dayWeatherDetails.weatherCondition.getImage(),
                    contentScale = ContentScale.Fit,
                    contentDescription = stringResource(id = R.string.weather_condition_icon),
                    modifier = Modifier.size(dimensionResource(id = R.dimen.weather_icon_small)),
                )
                Column(verticalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        text = dayWeatherDetails.highTemperature + stringResource(id = R.string.degree_symbol),
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.content_padding_small)))
                    Text(
                        text = dayWeatherDetails.lowTemperature + stringResource(id = R.string.degree_symbol),
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                }
            }
        }
        AnimatedVisibility(
            visible = showDetails,
            modifier = Modifier.padding(
                vertical = dimensionResource(id = R.dimen.content_padding_medium),
                horizontal = dimensionResource(id = R.dimen.content_padding_medium)
            )
        ) {
            Column {
                for (detail in dayWeatherDetails.details.iterator()) {
                    TableView(title = detail.key, description = detail.value)
                }
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.content_padding_medium)))
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    state = rememberLazyListState()
                ) {
                    items(dayWeatherDetails.hourlyWeather) { HourlyWeatherView(it) }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDetailedWeatherView() {
    RealTimeWeatherTheme {
        DetailedWeatherView(
            dayWeatherDetails = WeatherUIData(
                date = "Today",
                weatherCondition = WeatherCondition(
                    weather = "Sunny",
                    image = "",
                ),
                highTemperature = "8",
                lowTemperature = "5",
                details = mapOf(
                    "Wind" to "29km/h",
                    "Humidity" to "72%",
                    "UV index" to "1",
                    "Sunrise/sunset" to "07:49/16:52"
                ),
                hourlyWeather = listOf(
                    HourUIData(
                        temperature = "7",
                        weatherCondition = WeatherCondition(weather = "Rain", image = ""),
                        time = "11:00"
                    )
                )
            )
        )
    }
}
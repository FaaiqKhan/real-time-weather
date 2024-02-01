package com.practice.realtimeweather.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.practice.realtimeweather.R
import com.practice.realtimeweather.model.ui.HourUIData
import com.practice.realtimeweather.model.ui.WeatherCondition
import com.practice.realtimeweather.ui.theme.RealTimeWeatherTheme

@Composable
fun HourlyWeatherView(hourlyDetail: HourUIData) {
    Card(
        shape = RoundedCornerShape(0),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        modifier = Modifier.size(
            width = dimensionResource(id = R.dimen.weather_icon_small),
            height = dimensionResource(id = R.dimen.hourly_weather_card_height)
        ),
    ) {
        Text(
            text = hourlyDetail.temperature + stringResource(id = R.string.degree_symbol),
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
        )
        AsyncImage(
            model = hourlyDetail.weatherCondition.getImage(),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(id = R.string.weather_condition_icon),
            modifier = Modifier.size(dimensionResource(id = R.dimen.weather_icon_small)),
        )
        Text(
            text = hourlyDetail.time,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHourlyWeatherBriefView() {
    RealTimeWeatherTheme {
        HourlyWeatherView(
            hourlyDetail = HourUIData(
                temperature = "8",
                weatherCondition = WeatherCondition(
                    weather = "Sunny",
                    image = "",
                ),
                time = "12:00"
            )
        )
    }
}
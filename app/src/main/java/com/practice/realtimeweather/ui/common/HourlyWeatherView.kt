package com.practice.realtimeweather.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.practice.realtimeweather.R
import com.practice.realtimeweather.ui.theme.RealTimeWeatherTheme

@Composable
fun HourlyWeatherView() {
    Card(
        shape = RoundedCornerShape(0),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        modifier = Modifier.size(
            width = dimensionResource(id = R.dimen.weather_icon_small),
            height = dimensionResource(id = R.dimen.hourly_weather_card_height)
        ),
    ) {
        Text(
            text = "8" + stringResource(id = R.string.degree_symbol),
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
        )
        Image(
            painter = painterResource(id = R.drawable.sun_image),
            contentDescription = stringResource(
                id = R.string.weather_condition_icon
            ),
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(dimensionResource(id = R.dimen.weather_icon_small))
        )
        Text(
            text = "12:00",
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
        HourlyWeatherView()
    }
}
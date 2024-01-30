package com.practice.realtimeweather.ui.weeklyWeatherView

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.practice.realtimeweather.ui.theme.RealTimeWeatherTheme

@Composable
fun WeeklyWeatherView() {
    LazyColumn {
        items(count = 7) { DetailedWeatherView() }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewWeeklyWeatherView() {
    RealTimeWeatherTheme {
        WeeklyWeatherView()
    }
}
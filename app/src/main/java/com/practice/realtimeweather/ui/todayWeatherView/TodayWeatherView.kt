package com.practice.realtimeweather.ui.todayWeatherView

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.Preview
import com.practice.realtimeweather.R
import com.practice.realtimeweather.ui.theme.RealTimeWeatherTheme

@Composable
fun TodayWeatherView(modifier: Modifier = Modifier) {
    Column(modifier = modifier.background(color = Color.Blue.copy(alpha = 0.2f))) {
        Column(
            modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.screen_horizontal_padding))
        ) {
            Text(text = "30 January, 11:05", style = MaterialTheme.typography.headlineSmall)
            Text(
                text = "Day 9" + stringResource(id = R.string.degree_symbol) + stringResource(id = R.string.up_arrow_symbol) + " " + stringResource(
                    id = R.string.dot_symbol
                ) + " Night 5" + stringResource(id = R.string.degree_symbol) + stringResource(
                    id = R.string.down_arrow_symbol
                ),
                style = MaterialTheme.typography.bodySmall
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
                        text = "7" + stringResource(id = R.string.celsius_symbol),
                        style = MaterialTheme.typography.displayLarge
                    )
                    Text(
                        text = "Feels like 5" + stringResource(id = R.string.degree_symbol),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
//                AsyncImage(
//                    model = "https://cdn.weatherapi.com/weather/64x64/day/113.png",
//                    contentScale = ContentScale.Fit,
//                    contentDescription = "",
//                    modifier = Modifier.size(90.dp)
//                )
                    Image(
                        painter = painterResource(id = R.drawable.sun_image),
                        contentDescription = stringResource(
                            id = R.string.weather_condition_icon
                        ),
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(dimensionResource(id = R.dimen.weather_icon_size))
                    )
                    Text(text = "Sunny", style = MaterialTheme.typography.bodySmall)
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
                for (i in 0..5) {
                    Row(modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.content_padding_extra_small))) {
                        Text(
                            text = "Humidity",
                            modifier = Modifier.weight(1f),
                            style = MaterialTheme.typography.bodySmall
                        )
                        Text(
                            text = "value",
                            modifier = Modifier.weight(1f),
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
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
                Text(text = "Volume (mm): 30", style = MaterialTheme.typography.bodySmall)
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
                    Text(text = "11", style = MaterialTheme.typography.displayMedium)
                    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.content_padding_small)))
                    Text(
                        "km/h",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(
                            bottom = dimensionResource(id = R.dimen.font_padding)
                        )
                    )
                }
                Text(text = "Direction: SSW", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewTodayWeatherView() {
    RealTimeWeatherTheme {
        TodayWeatherView(modifier = Modifier.fillMaxSize())
    }
}
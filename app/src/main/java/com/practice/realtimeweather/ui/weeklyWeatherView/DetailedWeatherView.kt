package com.practice.realtimeweather.ui.weeklyWeatherView

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.practice.realtimeweather.R
import com.practice.realtimeweather.ui.common.HourlyWeatherView
import com.practice.realtimeweather.ui.theme.RealTimeWeatherTheme

@Composable
fun DetailedWeatherView() {
    var showDetails by remember { mutableStateOf(false) }

    Column {
        TextButton(
            onClick = { showDetails = !showDetails },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(0),
        ) {
            Column {
                Text(
                    text = "Today",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black
                )
                Text(
                    text = "Cloudy",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.sun_image),
                    contentDescription = stringResource(
                        id = R.string.weather_condition_icon
                    ),
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(dimensionResource(id = R.dimen.weather_icon_small))
                )
                Column(verticalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        text = "8" + stringResource(id = R.string.degree_symbol),
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                    )
                    Spacer(
                        modifier = Modifier
                            .height(dimensionResource(id = R.dimen.content_padding_small))
                    )
                    Text(
                        text = "5" + stringResource(id = R.string.degree_symbol),
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
                repeat(5) {
                    Row {
                        Text(
                            text = stringResource(id = R.string.wind),
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray,
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            text = stringResource(id = R.string.wind),
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(
                    dimensionResource(id = R.dimen.content_padding_medium))
                )
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    state = rememberLazyListState()
                ) {
                    items(count = 24) {
                        HourlyWeatherView()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDetailedWeatherView() {
    RealTimeWeatherTheme {
        DetailedWeatherView()
    }
}
package com.practice.realtimeweather.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.pager.*
import com.practice.realtimeweather.R
import com.practice.realtimeweather.ui.todayWeatherView.TodayWeatherView
import com.practice.realtimeweather.ui.weeklyWeatherView.WeeklyWeatherView
import com.practice.realtimeweather.utils.Utils
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun RealTimeWeather(
    weatherViewModel: RealTimeWeatherViewModel = viewModel()
) {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(initialPage = 1)

    val weatherHistoryUIState by weatherViewModel
        .getWeeklyWeatherHistoryViewState()
        .collectAsState()
    val weatherUIState by weatherViewModel
        .getTodayWeatherViewState()
        .collectAsState()
    val weatherForecastUIState by weatherViewModel
        .getWeeklyWeatherForecastViewState()
        .collectAsState()

    Scaffold {
        Column(modifier = Modifier.padding(it)) {
            TabRow(
                selectedTabIndex = pagerState.currentPage,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                divider = {
                    Spacer(
                        modifier = Modifier
                            .width(dimensionResource(id = R.dimen.content_padding_small))
                    )
                },
            ) {
                Utils.tabs.forEachIndexed { index, s ->
                    Tab(
                        selected = pagerState.currentPage == index,
                        onClick = {
                            scope.launch {
                                println(pagerState)
                                pagerState.animateScrollToPage(index)
                            }
                        },
                        text = { Text(text = s) }
                    )
                }
            }

            HorizontalPager(count = Utils.tabs.size, state = pagerState) { index ->
                when (index) {
                    0 -> WeeklyWeatherView(
                        modifier = Modifier.fillMaxSize(),
                        viewState = weatherHistoryUIState,
                    )

                    1 -> TodayWeatherView(
                        modifier = Modifier.fillMaxSize(),
                        viewState = weatherUIState,
                    )

                    2 -> WeeklyWeatherView(
                        modifier = Modifier.fillMaxSize(),
                        viewState = weatherForecastUIState
                    )
                }
            }
        }
    }
}
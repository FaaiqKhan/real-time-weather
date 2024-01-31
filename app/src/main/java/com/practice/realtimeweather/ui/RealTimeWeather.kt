package com.practice.realtimeweather.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.google.accompanist.pager.*
import com.practice.realtimeweather.R
import kotlinx.coroutines.launch

val tabData = listOf("Last 14 days", "Today", "7 days")

@OptIn(ExperimentalPagerApi::class)
@Composable
fun RealTimeWeather() {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState()

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
                tabData.forEachIndexed { index, s ->
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

            HorizontalPager(count = tabData.size, state = pagerState) { index ->
                when (index) {
                    0 -> Text(text = "FAIQ")
                    1 -> Text(text = "ALI")
                    2 -> Text(text = "KHAN")
                }
            }
        }
    }
}
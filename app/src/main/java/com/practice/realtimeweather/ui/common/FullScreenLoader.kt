package com.practice.realtimeweather.ui.common

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag

@Composable
fun FullScreenLoader(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.testTag(TestTag.loaderTag),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator()
    }
}

object TestTag {

    const val loaderTag = "full_screen_loader"
}
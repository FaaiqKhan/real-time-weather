package com.practice.realtimeweather.extension

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeTestRule

fun ComposeTestRule.assertHasTestTagIsDisplayed(testTag: String) =
    onNodeWithTag(testTag).run { assertIsDisplayed() }

fun ComposeTestRule.assertHasTextIsDisplayed(text: String) =
    onNodeWithText(text).run { assertIsDisplayed() }
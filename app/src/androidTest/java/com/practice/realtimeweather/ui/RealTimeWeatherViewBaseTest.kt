package com.practice.realtimeweather.ui

import android.content.Context
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Rule

abstract class RealTimeWeatherViewBaseTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    protected val context: Context get() = InstrumentationRegistry.getInstrumentation().targetContext
}
package com.practice.realtimeweather.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.sp
import com.practice.realtimeweather.R

val Lora = FontFamily(
    Font(R.font.lora_bold, FontWeight.Bold),
    Font(R.font.lora_medium, FontWeight.Medium),
    Font(R.font.lora_regular, FontWeight.Normal),
    Font(R.font.lora_semi_bold, FontWeight.SemiBold),
    Font(R.font.lora_italic, FontWeight.Thin),
    Font(R.font.lora_bold_italic, FontWeight.Bold),
    Font(R.font.lora_medium_italic, FontWeight.Medium),
    Font(R.font.lora_semi_bold_italic, FontWeight.SemiBold),
)

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontSize = 64.sp,
        fontFamily = Lora,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        fontWeight = FontWeight.Bold,
        platformStyle = PlatformTextStyle(includeFontPadding = false)
    ),
    displayMedium = TextStyle(
        fontSize = 24.sp,
        fontFamily = Lora,
        lineHeight = 8.sp,
        letterSpacing = 0.2.sp,
        fontWeight = FontWeight.Bold,
        platformStyle = PlatformTextStyle(includeFontPadding = false)
    ),
    displaySmall = TextStyle(
        fontSize = 18.sp,
        fontFamily = Lora,
        lineHeight = 20.sp,
        letterSpacing = 0.4.sp,
        fontWeight = FontWeight.Bold,
        platformStyle = PlatformTextStyle(includeFontPadding = false)
    ),
    headlineLarge = TextStyle(
        fontSize = 18.sp,
        fontFamily = Lora,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        fontWeight = FontWeight.SemiBold,
        platformStyle = PlatformTextStyle(includeFontPadding = false)
    ),
    headlineMedium = TextStyle(
        fontSize = 16.sp,
        fontFamily = Lora,
        lineHeight = 20.sp,
        letterSpacing = 0.4.sp,
        fontWeight = FontWeight.SemiBold,
        platformStyle = PlatformTextStyle(includeFontPadding = false)
    ),
    headlineSmall = TextStyle(
        fontSize = 14.sp,
        fontFamily = Lora,
        lineHeight = 20.sp,
        letterSpacing = 0.4.sp,
        fontWeight = FontWeight.SemiBold,
        platformStyle = PlatformTextStyle(includeFontPadding = false)
    ),
    titleLarge = TextStyle(
        fontSize = 18.sp,
        fontFamily = Lora,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        fontWeight = FontWeight.Medium,
        platformStyle = PlatformTextStyle(includeFontPadding = false)
    ),
    titleMedium = TextStyle(
        fontSize = 16.sp,
        fontFamily = Lora,
        lineHeight = 20.sp,
        letterSpacing = 0.4.sp,
        fontWeight = FontWeight.Medium,
        platformStyle = PlatformTextStyle(includeFontPadding = false)
    ),
    titleSmall = TextStyle(
        fontSize = 14.sp,
        fontFamily = Lora,
        lineHeight = 20.sp,
        letterSpacing = 0.4.sp,
        fontWeight = FontWeight.Medium,
        platformStyle = PlatformTextStyle(includeFontPadding = false)
    ),
    bodyLarge = TextStyle(
        fontSize = 18.sp,
        fontFamily = Lora,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        fontWeight = FontWeight.Normal,
        platformStyle = PlatformTextStyle(includeFontPadding = false)
    ),
    bodyMedium = TextStyle(
        fontSize = 16.sp,
        fontFamily = Lora,
        lineHeight = 22.sp,
        letterSpacing = 0.4.sp,
        fontWeight = FontWeight.Normal,
        platformStyle = PlatformTextStyle(includeFontPadding = false)
    ),
    bodySmall = TextStyle(
        fontSize = 14.sp,
        fontFamily = Lora,
        lineHeight = 6.sp,
        letterSpacing = 0.2.sp,
        fontWeight = FontWeight.Normal,
        platformStyle = PlatformTextStyle(includeFontPadding = false)
    ),
    labelLarge = TextStyle(
        fontSize = 18.sp,
        fontFamily = Lora,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        fontWeight = FontWeight.Thin,
    ),
    labelMedium = TextStyle(
        fontSize = 16.sp,
        fontFamily = Lora,
        lineHeight = 22.sp,
        letterSpacing = 0.4.sp,
        fontWeight = FontWeight.Thin
    ),
    labelSmall = TextStyle(
        fontSize = 14.sp,
        fontFamily = Lora,
        lineHeight = 20.sp,
        letterSpacing = 0.4.sp,
        fontWeight = FontWeight.Thin
    )
)
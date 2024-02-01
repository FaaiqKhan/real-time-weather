package com.practice.realtimeweather.utils

import java.time.*

object Utils {

    val tabs = listOf("Last 14 days", "Today", "7 days")

    fun isToday(date: LocalDateTime): Boolean {
        val current = LocalDateTime.now()
        return current.dayOfMonth == date.dayOfMonth
            && current.monthValue == date.monthValue
            && current.year == date.year
    }

    fun getDateTimeFromEpoch(epoch: Long): LocalDateTime = Instant
        .ofEpochSecond(epoch)
        .atZone(ZoneId.systemDefault())
        .toLocalDateTime()
}
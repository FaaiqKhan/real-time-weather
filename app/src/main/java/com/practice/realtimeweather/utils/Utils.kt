package com.practice.realtimeweather.utils

import java.time.*

object Utils {

    val tabs = listOf("Last 14 days", "Today", "7 days")

    /**
     * Comparing provided date day, month and year with current date day, month and year neglecting
     * time parameters hours, minutes and seconds.
     * @param date to be compare with current date.
     * @see LocalDateTime
     */
    fun isToday(date: LocalDateTime): Boolean {
        val current = LocalDateTime.now()
        return current.dayOfMonth == date.dayOfMonth
            && current.monthValue == date.monthValue
            && current.year == date.year
    }

    /**
     * Converting epoch into local date time object.
     * @param epoch a time based value.
     * @return LocalDateTime object
     * @see LocalDateTime
     */
    fun getDateTimeFromEpoch(epoch: Long): LocalDateTime = Instant
        .ofEpochSecond(epoch)
        .atZone(ZoneId.systemDefault())
        .toLocalDateTime()
}
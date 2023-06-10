package com.arstagaev.testkmm10.util

import kotlinx.datetime.*
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.toLocalDateTime

object DateTimeUtil {

    fun nowTime(): LocalDateTime =
        Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())

    fun toEpochMillis(dateTime: LocalDateTime): Long =
        dateTime.toInstant(TimeZone.currentSystemDefault()).toEpochMilliseconds()

    fun formatDate(dateTime: LocalDateTime): String {
        val year = dateTime.year
        val month = dateTime.month.name.take(3).replaceFirstChar { it.uppercase() }
        val day = if (dateTime.dayOfMonth < 10) "0${dateTime.dayOfMonth}" else dateTime.dayOfMonth
        val hour = if (dateTime.hour < 10) "0${dateTime.hour}" else dateTime.hour
        val minute = if (dateTime.hour < 10) "0${dateTime.minute}" else dateTime.minute

        return buildString {
            append(month)
            append(" ")
            append(day)
            append(" ")
            append(year)
            append(", ")
            append(hour)
            append(":")
            append(minute)
        }
    }
}
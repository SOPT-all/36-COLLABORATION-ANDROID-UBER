package com.sopt.at.uber.core.util

import java.time.format.TextStyle
import java.time.LocalDate
import java.time.LocalTime
import java.util.Locale

object TimeInfoFormatter {
    fun getPickupDisplayData(date: LocalDate, time: LocalTime): TImeData {
        val meridiem = if (time.hour < 12) "오전" else "오후"
        val hour = time.hour.toString().padStart(2, '0')
        val minute = time.minute.toString().padStart(2, '0')
        val day = date.dayOfMonth.toString().padStart(2, '0')
        val month = date.monthValue.toString().padStart(2, '0')
        val weekday = "(${date.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.KOREA)})"

        return TImeData(month, day, weekday, meridiem, hour, minute)
    }

    fun getArrivalDisplayData(pickupTime: LocalTime, durationMinutes: Long = 25): TImeData {
        val time = pickupTime.plusMinutes(durationMinutes)
        val meridiem = if (time.hour < 12) "오전" else "오후"
        val hour = time.hour.toString().padStart(2, '0')
        val minute = time.minute.toString().padStart(2, '0')

        return TImeData("", "", "", meridiem, hour, minute)
    }
}

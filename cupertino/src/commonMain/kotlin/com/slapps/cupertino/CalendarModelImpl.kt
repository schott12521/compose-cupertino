/*
 * Copyright (c) 2023-2024. Compose Cupertino project and open source contributors.
 * Copyright (c) 2025. Scott Lanoue.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



package com.slapps.cupertino

import kotlinx.datetime.DatePeriod
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime
import kotlinx.datetime.Month
import kotlinx.datetime.TimeZone
import kotlinx.datetime.atStartOfDayIn
import kotlinx.datetime.atTime
import kotlinx.datetime.isoDayNumber
import kotlinx.datetime.number
import kotlinx.datetime.plus
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.Instant

internal class CalendarModelImpl : CalendarModel {

    override val today: CalendarDate
        get() {
            val localDate = Clock.System.now()
                .toLocalDateTime(systemTZ)
            return CalendarDate(
                year = localDate.year,
                month = localDate.month.number,
                dayOfMonth = localDate.day,
                utcTimeMillis =
                    localDate.date
                        .atTime(Midnight)
                        .toInstant(TimeZone.UTC)
                        .toEpochMilliseconds(),
            )
        }

    override val firstDayOfWeek: Int
        get() = PlatformDateFormat.firstDayOfWeek

    override val weekdayNames: List<Pair<String, String>>
        get() = weekdayNames(currentLocale())

    private val systemTZ
        get() = TimeZone.currentSystemDefault()

    fun weekdayNames(locale: CalendarLocale): List<Pair<String, String>> = PlatformDateFormat.weekdayNames(locale)

    override fun getDateInputFormat(locale: CalendarLocale): DateInputFormat =
        PlatformDateFormat
            .getDateInputFormat(locale)

    override fun getCanonicalDate(timeInMillis: Long): CalendarDate =
        Instant
            .fromEpochMilliseconds(timeInMillis)
            .toLocalDateTime(TimeZone.UTC)
            .date
            .atStartOfDayIn(TimeZone.UTC)
            .toCalendarDate(TimeZone.UTC)

    override fun getMonth(timeInMillis: Long): CalendarMonth =
        Instant
            .fromEpochMilliseconds(timeInMillis)
            .toCalendarMonth(TimeZone.UTC)

    override fun getMonth(date: CalendarDate): CalendarMonth = getMonth(date.utcTimeMillis)

    override fun getMonth(
        year: Int,
        month: Int,
    ): CalendarMonth {
        val instant =
            LocalDate(
                year = year,
                month = month,
                day = 1
            ).atTime(Midnight)
                .toInstant(TimeZone.UTC)

        return getMonth(instant.toEpochMilliseconds())
    }

    override fun getDate(
        year: Int,
        month: Int,
        day: Int,
    ): CalendarDate =
        CalendarDate(
            year = year,
            month = month,
            dayOfMonth = day,
            utcTimeMillis =
                LocalDate(year, month, day)
                    .atStartOfDayIn(TimeZone.UTC)
                    .toEpochMilliseconds(),
        )

    override fun getDayOfWeek(date: CalendarDate): Int =
        LocalDate(
            year = date.year,
            month = date.month,
            day = date.dayOfMonth
        ).dayOfWeek.isoDayNumber

    override fun plusMonths(
        from: CalendarMonth,
        addedMonthsCount: Int,
    ): CalendarMonth =
        Instant
            .fromEpochMilliseconds(from.startUtcTimeMillis)
            .toLocalDateTime(TimeZone.UTC)
            .date
            .plus(DatePeriod(months = addedMonthsCount))
            .atTime(Midnight)
            .toInstant(TimeZone.UTC)
            .toCalendarMonth(TimeZone.UTC)

    override fun minusMonths(
        from: CalendarMonth,
        subtractedMonthsCount: Int,
    ): CalendarMonth = plusMonths(from, -subtractedMonthsCount)

    override fun formatWithPattern(
        utcTimeMillis: Long,
        pattern: String,
        locale: CalendarLocale,
    ): String = PlatformDateFormat.formatWithPattern(utcTimeMillis, pattern, locale)

    override fun parse(
        date: String,
        pattern: String,
    ): CalendarDate? = PlatformDateFormat.parse(date, pattern)

    private fun Instant.toCalendarMonth(timeZone: TimeZone): CalendarMonth {
        val dateTime = toLocalDateTime(timeZone)

        val monthStart =
            LocalDate(
                year = dateTime.year,
                month = dateTime.month,
                day = 1
            )

        return CalendarMonth(
            year = dateTime.year,
            month = dateTime.month.number,
            numberOfDays =
                dateTime.month
                    .numberOfDays(dateTime.year.isLeapYear()),
            daysFromStartOfWeekToFirstOfMonth =
                monthStart
                    .daysFromStartOfWeekToFirstOfMonth(),
            startUtcTimeMillis =
                monthStart
                    .atTime(Midnight)
                    .toInstant(TimeZone.UTC)
                    .toEpochMilliseconds(),
        )
    }

    private fun LocalDate.daysFromStartOfWeekToFirstOfMonth() =
        (dayOfWeek.isoDayNumber - firstDayOfWeek).let { if (it >= 0) it else 7 + it }
}

internal fun Instant.toCalendarDate(timeZone: TimeZone): CalendarDate {
    val dateTime = toLocalDateTime(timeZone)

    return CalendarDate(
        year = dateTime.year,
        month = dateTime.month.number,
        dayOfMonth = dateTime.day,
        utcTimeMillis = toEpochMilliseconds(),
    )
}

internal val Midnight = LocalTime(0, 0)

private fun Int.isLeapYear() = this % 4 == 0 && (this % 100 != 0 || this % 400 == 0)

private fun Month.numberOfDays(isLeap: Boolean): Int =
    when (this) {
        Month.FEBRUARY -> if (isLeap) 29 else 28
        Month.JANUARY,
        Month.MARCH,
        Month.MAY,
        Month.JULY,
        Month.AUGUST,
        Month.OCTOBER,
        Month.DECEMBER,
        -> 31

        else -> 30
    }

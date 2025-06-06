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

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalConfiguration
import java.time.DayOfWeek
import java.time.Instant
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.chrono.Chronology
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.time.format.DateTimeParseException
import java.time.format.DecimalStyle
import java.time.format.FormatStyle
import java.time.format.TextStyle
import java.time.temporal.WeekFields
import java.util.Locale

@Composable
@ReadOnlyComposable
internal actual fun defaultLocale(): CalendarLocale = LocalConfiguration.current.locale

internal actual fun currentLocale(): CalendarLocale = Locale.getDefault()

/**
 * A [CalendarModel] implementation for API >= 26.
 */
@RequiresApi(Build.VERSION_CODES.O)
internal class AndroidCalendarModelImpl : CalendarModel {
    override val today
        get(): CalendarDate {
            val systemLocalDate = LocalDate.now()
            return CalendarDate(
                year = systemLocalDate.year,
                month = systemLocalDate.monthValue,
                dayOfMonth = systemLocalDate.dayOfMonth,
                utcTimeMillis =
                    systemLocalDate
                        .atTime(LocalTime.MIDNIGHT)
                        .atZone(utcTimeZoneId)
                        .toInstant()
                        .toEpochMilli(),
            )
        }

    override val firstDayOfWeek: Int = WeekFields.of(Locale.getDefault()).firstDayOfWeek.value

    override val weekdayNames: List<Pair<String, String>> = weekdayNames(Locale.getDefault())

    fun weekdayNames(locale: Locale): List<Pair<String, String>> =
        // This will start with Monday as the first day, according to ISO-8601.
        with(locale) {
            DayOfWeek.entries.map {
                it.getDisplayName(
                    TextStyle.FULL,
                    // locale =
                    this,
                ) to
                    it.getDisplayName(
                        TextStyle.SHORT,
                        // locale =
                        this,
                    )
            }
        }

    override fun getDateInputFormat(locale: Locale): DateInputFormat =
        datePatternAsInputFormat(
            DateTimeFormatterBuilder.getLocalizedDateTimePattern(
                // dateStyle =
                FormatStyle.SHORT,
                // timeStyle =
                null,
                // chrono =
                Chronology.ofLocale(locale),
                // locale =
                locale,
            ),
        )

    override fun getCanonicalDate(timeInMillis: Long): CalendarDate {
        val localDate =
            Instant.ofEpochMilli(timeInMillis).atZone(utcTimeZoneId).toLocalDate()
        return CalendarDate(
            year = localDate.year,
            month = localDate.monthValue,
            dayOfMonth = localDate.dayOfMonth,
            utcTimeMillis = localDate.atStartOfDay().toEpochSecond(ZoneOffset.UTC) * 1000,
        )
    }

    override fun getMonth(timeInMillis: Long): CalendarMonth =
        getMonth(
            Instant
                .ofEpochMilli(timeInMillis)
                .atZone(utcTimeZoneId)
                .withDayOfMonth(1)
                .toLocalDate(),
        )

    override fun getMonth(date: CalendarDate): CalendarMonth = getMonth(LocalDate.of(date.year, date.month, 1))

    override fun getMonth(
        year: Int,
        month: Int,
    ): CalendarMonth = getMonth(LocalDate.of(year, month, 1))

    override fun getDate(
        year: Int,
        month: Int,
        day: Int,
    ): CalendarDate = CalendarDate(year, month, day, 0)

    override fun getDayOfWeek(date: CalendarDate): Int = date.toLocalDate().dayOfWeek.value

    override fun plusMonths(
        from: CalendarMonth,
        addedMonthsCount: Int,
    ): CalendarMonth {
        if (addedMonthsCount <= 0) return from

        val firstDayLocalDate = from.toLocalDate()
        val laterMonth = firstDayLocalDate.plusMonths(addedMonthsCount.toLong())
        return getMonth(laterMonth)
    }

    override fun minusMonths(
        from: CalendarMonth,
        subtractedMonthsCount: Int,
    ): CalendarMonth {
        if (subtractedMonthsCount <= 0) return from

        val firstDayLocalDate = from.toLocalDate()
        val earlierMonth = firstDayLocalDate.minusMonths(subtractedMonthsCount.toLong())
        return getMonth(earlierMonth)
    }

    override fun formatWithPattern(
        utcTimeMillis: Long,
        pattern: String,
        locale: Locale,
    ): String = AndroidCalendarModelImpl.formatWithPattern(utcTimeMillis, pattern, locale)

    override fun parse(
        date: String,
        pattern: String,
    ): CalendarDate? {
        // TODO: A DateTimeFormatter can be reused.
        val formatter = DateTimeFormatter.ofPattern(pattern)
        return try {
            val localDate = LocalDate.parse(date, formatter)
            CalendarDate(
                year = localDate.year,
                month = localDate.month.value,
                dayOfMonth = localDate.dayOfMonth,
                utcTimeMillis =
                    localDate
                        .atTime(LocalTime.MIDNIGHT)
                        .atZone(utcTimeZoneId)
                        .toInstant()
                        .toEpochMilli(),
            )
        } catch (pe: DateTimeParseException) {
            null
        }
    }

    override fun toString(): String = "CalendarModel"

    companion object {
        /**
         * Formats a UTC timestamp into a string with a given date format pattern.
         *
         * @param utcTimeMillis a UTC timestamp to format (milliseconds from epoch)
         * @param pattern a date format pattern
         * @param locale the [Locale] to use when formatting the given timestamp
         */
        fun formatWithPattern(
            utcTimeMillis: Long,
            pattern: String,
            locale: Locale,
        ): String {
            val formatter: DateTimeFormatter =
                DateTimeFormatter
                    .ofPattern(pattern, locale)
                    .withDecimalStyle(DecimalStyle.of(locale))
            return Instant
                .ofEpochMilli(utcTimeMillis)
                .atZone(utcTimeZoneId)
                .toLocalDate()
                .format(formatter)
        }

        /**
         * Holds a UTC [ZoneId].
         */
        internal val utcTimeZoneId: ZoneId = ZoneId.of("UTC")
    }

    private fun getMonth(firstDayLocalDate: LocalDate): CalendarMonth {
        val difference = firstDayLocalDate.dayOfWeek.value - firstDayOfWeek
        val daysFromStartOfWeekToFirstOfMonth =
            if (difference < 0) {
                difference + DaysInWeek
            } else {
                difference
            }
        val firstDayEpochMillis =
            firstDayLocalDate
                .atTime(LocalTime.MIDNIGHT)
                .atZone(utcTimeZoneId)
                .toInstant()
                .toEpochMilli()
        return CalendarMonth(
            year = firstDayLocalDate.year,
            month = firstDayLocalDate.monthValue,
            numberOfDays = firstDayLocalDate.lengthOfMonth(),
            daysFromStartOfWeekToFirstOfMonth = daysFromStartOfWeekToFirstOfMonth,
            startUtcTimeMillis = firstDayEpochMillis,
        )
    }

    private fun CalendarMonth.toLocalDate(): LocalDate = Instant.ofEpochMilli(startUtcTimeMillis).atZone(utcTimeZoneId).toLocalDate()

    private fun CalendarDate.toLocalDate(): LocalDate =
        LocalDate.of(
            this.year,
            this.month,
            this.dayOfMonth,
        )
}

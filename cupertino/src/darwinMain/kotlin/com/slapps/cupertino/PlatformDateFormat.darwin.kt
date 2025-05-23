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

import androidx.compose.runtime.Composable
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toNSTimeZone
import platform.Foundation.NSCalendar
import platform.Foundation.NSDate
import platform.Foundation.NSDateFormatter
import platform.Foundation.NSDateFormatterShortStyle
import platform.Foundation.NSLocale
import platform.Foundation.currentLocale
import platform.Foundation.dateWithTimeIntervalSince1970
import platform.Foundation.timeIntervalSince1970

actual typealias CalendarLocale = NSLocale

@Composable
internal actual fun defaultLocale(): CalendarLocale = NSLocale.currentLocale()

internal actual fun currentLocale(): CalendarLocale = NSLocale.currentLocale()

internal actual object PlatformDateFormat {
    actual val firstDayOfWeek: Int
        get() = firstDayOfWeek()

    actual fun formatWithPattern(
        utcTimeMillis: Long,
        pattern: String,
        locale: CalendarLocale,
    ): String {
        val nsDate = NSDate.dateWithTimeIntervalSince1970(utcTimeMillis / 1000.0)

        return NSDateFormatter()
            .apply {
                setTimeZone(TimeZone.UTC.toNSTimeZone())
                setLocale(locale)
                setDateFormat(pattern)
            }.stringFromDate(nsDate)
    }

    actual fun formatWithSkeleton(
        utcTimeMillis: Long,
        skeleton: String,
        locale: CalendarLocale,
    ): String {
        val nsDate = NSDate.dateWithTimeIntervalSince1970(utcTimeMillis / 1000.0)

        return NSDateFormatter()
            .apply {
                setTimeZone(TimeZone.UTC.toNSTimeZone())
                setLocale(locale)
                setLocalizedDateFormatFromTemplate(skeleton)
            }.stringFromDate(nsDate)
    }

    actual fun parse(
        date: String,
        pattern: String,
    ): CalendarDate? {
        val nsDate =
            NSDateFormatter()
                .apply {
                    setTimeZone(TimeZone.UTC.toNSTimeZone())
                    setDateFormat(pattern)
                }.dateFromString(date) ?: return null

        return Instant
            .fromEpochMilliseconds((nsDate.timeIntervalSince1970 * 1000).toLong())
            .toCalendarDate(TimeZone.UTC)
    }

    actual fun getDateInputFormat(locale: CalendarLocale): DateInputFormat {
        val pattern =
            NSDateFormatter()
                .apply {
                    setLocale(locale)
                    setDateStyle(NSDateFormatterShortStyle)
                }.dateFormat

        return datePatternAsInputFormat(pattern)
    }

    @Suppress("UNCHECKED_CAST")
    actual fun weekdayNames(locale: CalendarLocale): List<Pair<String, String>> {
        val formatter =
            NSDateFormatter().apply {
                setLocale(locale)
            }

        val fromSundayToSaturday =
            formatter.standaloneWeekdaySymbols
                .zip(formatter.shortStandaloneWeekdaySymbols) as List<Pair<String, String>>

        return fromSundayToSaturday.drop(1) + fromSundayToSaturday.first()
    }

    @Suppress("UNCHECKED_CAST")
    actual fun monthsNames(locale: CalendarLocale): List<String> {
        val formatter =
            NSDateFormatter().apply {
                setLocale(locale)
            }

        return formatter.monthSymbols as List<String>
    }

    private fun firstDayOfWeek(): Int = (NSCalendar.currentCalendar.firstWeekday.toInt() - 1).takeIf { it > 0 } ?: 7

    // See http://www.unicode.org/reports/tr35/tr35-31/tr35-dates.html#Date_Format_Patterns
    //
    // 'j' template requests the preferred hour format for the locale.
    // 'a' is a pattern for AM\PM symbol. Presence of this symbol means that locale has 12h format.
    actual fun is24HourFormat(locale: CalendarLocale): Boolean =
        NSDateFormatter
            .dateFormatFromTemplate("j", 0u, locale)
            ?.contains('a') == false
}

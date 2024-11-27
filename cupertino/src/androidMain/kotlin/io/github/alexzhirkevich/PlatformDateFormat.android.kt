

package io.github.alexzhirkevich

import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast

internal actual object PlatformDateFormat {
    private val delegate by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            AndroidCalendarModelImpl()
        } else {
            error("should not be used for api < 26")
        }
    }
    actual val firstDayOfWeek: Int
        get() =
            apiCheck(
                old = { LegacyDateFormat.firstDayOfWeek },
                new = { delegate.firstDayOfWeek },
            )

    actual fun formatWithPattern(
        utcTimeMillis: Long,
        pattern: String,
        locale: CalendarLocale,
    ): String =
        apiCheck(
            old = {
                LegacyDateFormat.formatWithPattern(utcTimeMillis, pattern, locale)
            },
            new = {
                delegate.formatWithPattern(utcTimeMillis, pattern, locale)
            },
        )

    actual fun formatWithSkeleton(
        utcTimeMillis: Long,
        skeleton: String,
        locale: CalendarLocale,
    ): String =
        apiCheck(
            old = {
                LegacyDateFormat.formatWithSkeleton(utcTimeMillis, skeleton, locale)
            },
            new = {
                val pattern =
                    android.text.format.DateFormat
                        .getBestDateTimePattern(locale, skeleton)
                AndroidCalendarModelImpl.formatWithPattern(utcTimeMillis, pattern, locale)
            },
        )

    actual fun parse(
        date: String,
        pattern: String,
    ): CalendarDate? =
        apiCheck(
            old = {
                LegacyDateFormat.parse(date, pattern)
            },
            new = {
                delegate.parse(date, pattern)
            },
        )

    actual fun getDateInputFormat(locale: CalendarLocale): DateInputFormat =
        apiCheck(
            old = { LegacyDateFormat.getDateInputFormat(locale) },
            new = { delegate.getDateInputFormat(locale) },
        )

    // From CalendarModelImpl.android.kt weekdayNames.
    //
    // Legacy model returns short ('Mon') format while newer version returns narrow ('M') format
    actual fun weekdayNames(locale: CalendarLocale): List<Pair<String, String>> =
        apiCheck(
            old = { LegacyDateFormat.weekdayNames(locale) },
            new = { delegate.weekdayNames(locale) },
        )

    actual fun monthsNames(locale: CalendarLocale): List<String> = LegacyDateFormat.monthsNames(locale)

    // https://android.googlesource.com/platform/frameworks/base/+/jb-release/core/java/android/text/format/DateFormat.java
    //
    // public static boolean is24HourFormat(Context context) -- used by Android date format
    actual fun is24HourFormat(locale: CalendarLocale): Boolean = LegacyDateFormat.is24HourFormat(locale)
}

@ChecksSdkIntAtLeast(api = Build.VERSION_CODES.O, lambda = 2)
private fun <T> apiCheck(
    old: () -> T,
    new: () -> T,
): T =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        new()
    } else {
        old()
    }

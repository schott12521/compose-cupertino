

package com.slapps.cupertino

import androidx.compose.runtime.Composable

@Composable
internal actual fun defaultLocale(): CalendarLocale = java.util.Locale.getDefault()

internal actual fun currentLocale(): CalendarLocale = java.util.Locale.getDefault()

internal actual typealias PlatformDateFormat = LegacyDateFormat



package io.github.alexzhirkevich.cupertino

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.atStartOfDayIn
import kotlinx.datetime.toLocalDateTime
import platform.UIKit.UIDatePickerMode

@OptIn(InternalCupertinoApi::class)
@Composable
@ExperimentalCupertinoApi
actual fun CupertinoTimePickerNative(
    state: CupertinoTimePickerState,
    modifier: Modifier,
    height : Dp,
    containerColor : Color
) {
    LaunchedEffect(state){
        state.isManual = true
    }

    val millis by remember(state) {
        derivedStateOf {
            Clock.System.now()
                .toLocalDateTime(TimeZone.UTC)
                .date
                .atStartOfDayIn(TimeZone.UTC)
                .toEpochMilliseconds() + (state.hour * MinutesInHour + state.minute) * MillisInMunite
        }
    }

    CupertinoDatePickerNativeImpl(
        modifier = modifier,
        millis = millis,
        mode = UIDatePickerMode.UIDatePickerModeTime,
        onChange = {
            val rem = (it % MillisIn24Hours) / MillisInMunite

            state.manualHour = (rem / MinutesInHour).toInt()
            state.manualMinute = (rem % MinutesInHour).toInt()
        },
        style = DatePickerStyle.Wheel(),
        containerColor = containerColor
    )
}

private const val MillisIn24Hours = 24 * 60 * 60 * 1000
private const val MillisInMunite = 60_000
private const val MinutesInHour = 60
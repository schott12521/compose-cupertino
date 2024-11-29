

package com.slapps.cupertino

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import platform.UIKit.UIDatePickerMode

@OptIn(InternalCupertinoApi::class)
@Composable
@ExperimentalCupertinoApi
actual fun CupertinoDateTimePickerNative(
    state: CupertinoDateTimePickerState,
    modifier: Modifier,
    style: DatePickerStyle,
    containerColor : Color
) {
    LaunchedEffect(state){
        state.isManual = true
    }

    key(state) {
        CupertinoDatePickerNativeImpl(
            millis = state.selectedDateTimeMillis,
            mode = UIDatePickerMode.UIDatePickerModeDateAndTime,
            onChange = {
                state.setSelection(it)
            },
            modifier = modifier,
            style = style,
            containerColor = containerColor,
        )
    }
}
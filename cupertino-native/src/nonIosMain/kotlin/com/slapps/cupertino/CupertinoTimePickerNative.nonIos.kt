

package com.slapps.cupertino

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

@Composable
@ExperimentalCupertinoApi
actual fun CupertinoTimePickerNative(
    state: CupertinoTimePickerState,
    modifier: Modifier,
    height : Dp,
    containerColor : Color
) = CupertinoTimePicker(
    state = state,
    modifier = modifier,
    height = height,
    containerColor = containerColor
)
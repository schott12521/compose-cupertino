

package io.github.alexzhirkevich.cupertino

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
@ExperimentalCupertinoApi
actual fun CupertinoDatePickerNative(
    state: CupertinoDatePickerState,
    modifier: Modifier,
    style: DatePickerStyle,
    containerColor : Color
) = CupertinoDatePicker(
    state = state,
    modifier = modifier,
    style = style,
    containerColor = containerColor
)
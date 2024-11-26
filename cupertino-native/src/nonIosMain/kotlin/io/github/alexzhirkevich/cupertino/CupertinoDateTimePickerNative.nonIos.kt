

package io.github.alexzhirkevich.cupertino

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
@ExperimentalCupertinoApi
actual fun CupertinoDateTimePickerNative(
    state: CupertinoDateTimePickerState,
    modifier: Modifier,
    style: DatePickerStyle,
    containerColor : Color
) = CupertinoDateTimePicker(
    state = state,
    style = style,
    containerColor = containerColor,
    modifier = modifier
)
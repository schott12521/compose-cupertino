

package com.slapps.cupertino

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.takeOrElse
import com.slapps.cupertino.theme.CupertinoTheme

@Composable
@ExperimentalCupertinoApi
expect fun CupertinoDatePickerNative(
    state: CupertinoDatePickerState,
    modifier: Modifier = Modifier,
    style: DatePickerStyle = DatePickerStyle.Wheel(),
    containerColor: Color =
        LocalContainerColor.current.takeOrElse {
            CupertinoTheme.colorScheme.secondarySystemGroupedBackground
        },
)

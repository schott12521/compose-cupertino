

package io.github.alexzhirkevich.cupertino

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.takeOrElse
import io.github.alexzhirkevich.cupertino.theme.CupertinoTheme

@Composable
@ExperimentalCupertinoApi
expect fun CupertinoDateTimePickerNative(
    state: CupertinoDateTimePickerState,
    modifier: Modifier = Modifier,
    style: DatePickerStyle = DatePickerStyle.Wheel(),
    containerColor: Color =
        LocalContainerColor.current.takeOrElse {
            CupertinoTheme.colorScheme.secondarySystemGroupedBackground
        },
)



package com.slapps.cupertino

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.unit.Dp
import com.slapps.cupertino.theme.CupertinoTheme

@Composable
@ExperimentalCupertinoApi
expect fun CupertinoTimePickerNative(
    state: CupertinoTimePickerState,
    modifier: Modifier = Modifier,
    height: Dp = CupertinoPickerDefaults.Height,
    containerColor: Color =
        LocalContainerColor.current.takeOrElse {
            CupertinoTheme.colorScheme.secondarySystemGroupedBackground
        },
)

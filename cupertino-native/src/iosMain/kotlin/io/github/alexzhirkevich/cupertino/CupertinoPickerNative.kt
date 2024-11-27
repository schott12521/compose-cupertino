

package io.github.alexzhirkevich.cupertino

import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.viewinterop.UIKitInteropProperties
import androidx.compose.ui.viewinterop.UIKitView
import io.github.alexzhirkevich.cupertino.theme.CupertinoTheme
import platform.UIKit.UIPickerView

@Composable
@ExperimentalCupertinoApi
fun <T> CupertinoPickerNative(
    state: CupertinoPickerState,
    items: List<T>,
    modifier: Modifier = Modifier,
    height: Dp = CupertinoPickerDefaults.Height,
    containerColor: Color =
        LocalContainerColor.current.takeOrElse {
            CupertinoTheme.colorScheme.secondarySystemGroupedBackground
        },
    enabled: Boolean = true,
    content: (T) -> String,
) {
    UIKitView(
        factory = {
            UIPickerView()
        },
        modifier = modifier.height(height),
        properties =
            UIKitInteropProperties(
                isInteractive = true,
                isNativeAccessibilityEnabled = true,
            ),
    )
}

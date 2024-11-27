

package io.github.alexzhirkevich.cupertino

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.window.DialogProperties

@OptIn(ExperimentalCupertinoApi::class)
@Composable
actual fun CupertinoAlertDialogNative(
    onDismissRequest: () -> Unit,
    title: String?,
    message: String?,
    containerColor: Color,
    shape: Shape,
    properties: DialogProperties,
    buttonsOrientation: Orientation,
    buttons: NativeAlertDialogActionsScope.() -> Unit,
) {
    CupertinoAlertDialog(
        onDismissRequest = onDismissRequest,
        properties = properties,
        title = { CupertinoText(title.orEmpty()) },
        message = { CupertinoText(message.orEmpty()) },
        containerColor = containerColor,
        shape = shape,
        buttonsOrientation = buttonsOrientation,
        buttons = { fromNative(buttons) },
    )
}

@OptIn(ExperimentalCupertinoApi::class)
@Composable
actual fun CupertinoActionSheetNative(
    visible: Boolean,
    onDismissRequest: () -> Unit,
    title: String?,
    message: String?,
    containerColor: Color,
    secondaryContainerColor: Color,
    properties: DialogProperties,
    buttons: NativeAlertDialogActionsScope.() -> Unit,
) = CupertinoActionSheet(
    visible = visible,
    onDismissRequest = onDismissRequest,
    properties = properties,
    title = { CupertinoText(title.orEmpty()) },
    message = { CupertinoText(message.orEmpty()) },
    containerColor = containerColor,
    secondaryContainerColor = secondaryContainerColor,
    buttons = { fromNative(buttons) },
)

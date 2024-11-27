

package io.github.alexzhirkevich.cupertino

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.util.fastForEach
import androidx.compose.ui.util.fastMap
import androidx.compose.ui.window.DialogProperties
import platform.UIKit.UIAlertAction
import platform.UIKit.UIAlertActionStyle
import platform.UIKit.UIAlertActionStyleCancel
import platform.UIKit.UIAlertActionStyleDefault
import platform.UIKit.UIAlertActionStyleDestructive
import platform.UIKit.UIAlertController
import platform.UIKit.UIAlertControllerStyleActionSheet
import platform.UIKit.UIAlertControllerStyleAlert

@Composable
@NonRestartableComposable
actual fun CupertinoAlertDialogNative(
    onDismissRequest : () -> Unit,
    title: String?,
    message: String?,
    containerColor : Color,
    shape: Shape,
    properties: DialogProperties,
    buttonsOrientation: Orientation,
    buttons : NativeAlertDialogActionsScope.() -> Unit
) = UIAlertController(
    onDismissRequest = onDismissRequest,
    title = title,
    message = message,
    style = UIAlertControllerStyleAlert,
    buttons = buttons,
)

@Composable
actual fun CupertinoActionSheetNative(
    visible : Boolean,
    onDismissRequest : () -> Unit,
    title : String?,
    message : String?,
    containerColor : Color,
    secondaryContainerColor : Color,
    properties: DialogProperties,
    buttons : NativeAlertDialogActionsScope.() -> Unit
) {
    if (visible) {
        UIAlertController(
            onDismissRequest = onDismissRequest,
            title = title,
            message = message,
            style = UIAlertControllerStyleActionSheet,
            buttons = buttons,
        )
    }
}

private var isAlertControllerBeingDismissed = false

@Composable
internal fun UIAlertController(
    onDismissRequest: () -> Unit,
    title: String?,
    message: String?,
    style: UIAlertActionStyle,
    buttons: NativeAlertDialogActionsScope.() -> Unit,
) {
    val buttonsList = remember {
        NativeAlertDialogButtonsScopeImpl(onDismissRequest = {
            if (!isAlertControllerBeingDismissed) {
                isAlertControllerBeingDismissed = true
                onDismissRequest()
            }
        }).apply(buttons).buttons
    }

    val titles = buttonsList.fastMap { it.title }
    val styles = buttonsList.fastMap { it.style }

    key(titles, styles) {
        PresentationController(
            factory = {
                UIAlertController.alertControllerWithTitle(
                    title = title,
                    message = message,
                    preferredStyle = style
                ).apply {
                    buttonsList.fastForEach {
                        addAction(it)
                    }
                }
            },
            update = {
                setTitle(title)
                setMessage(message)

                val uiActions = actions.filterIsInstance<UIAlertAction>()
                if (uiActions.size == buttonsList.size) {
                    uiActions.zip(buttonsList).fastForEach { (action, button) ->
                        action.setEnabled(button.enabled)
                    }
                } else {
                    println("Mismatch between number of actions and buttonsList")
                }
            },
            onDismissRequest = onDismissRequest,
            title, message
        )
    }
}

private class NativeAlertDialogButtonsScopeImpl(
    val onDismissRequest: () -> Unit,
) : NativeAlertDialogActionsScope {

    val buttons  = mutableListOf<UIAlertAction>()

    override fun action(
        onClick: () -> Unit,
        style: AlertActionStyle,
        enabled: Boolean,
        title: String
    ) {
        buttons += UIAlertAction.actionWithTitle(
            title = title,
            style = style.ui,
            handler = {
                onClick()
                onDismissRequest()
            }
        ).apply {
            setEnabled(enabled)
        }
    }
}

internal val AlertActionStyle.ui : UIAlertActionStyle get() =
    when(this){
        AlertActionStyle.Default -> UIAlertActionStyleDefault
        AlertActionStyle.Cancel -> UIAlertActionStyleCancel
        AlertActionStyle.Destructive -> UIAlertActionStyleDestructive
    }
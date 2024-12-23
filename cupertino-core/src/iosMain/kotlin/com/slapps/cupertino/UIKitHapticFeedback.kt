

package com.slapps.cupertino

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.hapticfeedback.HapticFeedback
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import platform.UIKit.UIImpactFeedbackGenerator
import platform.UIKit.UIImpactFeedbackStyle
import platform.UIKit.UINotificationFeedbackGenerator
import platform.UIKit.UINotificationFeedbackType
import platform.UIKit.UISelectionFeedbackGenerator

@Composable
actual fun rememberCupertinoHapticFeedback(): HapticFeedback {
    val current = LocalHapticFeedback.current

    return remember(current) {
        UIKitHapticFeedback(current)
    }
}

internal class UIKitHapticFeedback(
    private val delegate: HapticFeedback,
) : HapticFeedback {
    private val notificationFeedbackGenerator by lazy {
        UINotificationFeedbackGenerator()
    }

    private val selectionFeedbackGenerator by lazy {
        UISelectionFeedbackGenerator()
    }

    @OptIn(InternalCupertinoApi::class)
    override fun performHapticFeedback(hapticFeedbackType: HapticFeedbackType) {
        when (hapticFeedbackType) {
            HapticFeedbackType.LongPress, HapticFeedbackType.TextHandleMove -> {
                delegate.performHapticFeedback(hapticFeedbackType)
            }

            CupertinoHapticFeedback.SelectionChanged -> {
                selectionFeedbackGenerator.selectionChanged()
            }

            CupertinoHapticFeedback.Warning,
            CupertinoHapticFeedback.Success,
            CupertinoHapticFeedback.Error,
            -> {
                notificationFeedbackGenerator.notificationOccurred(
                    NotificationFeedbackMapping[hapticFeedbackType]!!,
                )
            }

            CupertinoHapticFeedback.ImpactLight,
            CupertinoHapticFeedback.ImpactMedium,
            CupertinoHapticFeedback.ImpactHeavy,
            CupertinoHapticFeedback.ImpactRigid,
            CupertinoHapticFeedback.ImpactSoft,
            -> {
                UIImpactFeedbackGenerator(
                    ImpactFeedbackMapping[hapticFeedbackType]!!,
                ).impactOccurred()
            }
        }
    }
}

@OptIn(InternalCupertinoApi::class)
private val NotificationFeedbackMapping by lazy {
    mapOf(
        CupertinoHapticFeedback.Success to UINotificationFeedbackType.UINotificationFeedbackTypeSuccess,
        CupertinoHapticFeedback.Warning to UINotificationFeedbackType.UINotificationFeedbackTypeWarning,
        CupertinoHapticFeedback.Error to UINotificationFeedbackType.UINotificationFeedbackTypeError,
    )
}

@OptIn(InternalCupertinoApi::class)
private val ImpactFeedbackMapping by lazy {
    mapOf(
        CupertinoHapticFeedback.ImpactLight to UIImpactFeedbackStyle.UIImpactFeedbackStyleLight,
        CupertinoHapticFeedback.ImpactMedium to UIImpactFeedbackStyle.UIImpactFeedbackStyleMedium,
        CupertinoHapticFeedback.ImpactHeavy to UIImpactFeedbackStyle.UIImpactFeedbackStyleHeavy,
        CupertinoHapticFeedback.ImpactRigid to UIImpactFeedbackStyle.UIImpactFeedbackStyleRigid,
        CupertinoHapticFeedback.ImpactSoft to UIImpactFeedbackStyle.UIImpactFeedbackStyleSoft,
    )
}

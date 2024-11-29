

package com.slapps.cupertino

import androidx.compose.runtime.Composable
import androidx.compose.ui.hapticfeedback.HapticFeedback
import androidx.compose.ui.hapticfeedback.HapticFeedbackType

@Composable
expect fun rememberCupertinoHapticFeedback(): HapticFeedback

/**
 * This haptic feedback types work only on iOS. They are available for public usage in iosMain as
 * extension properties of [HapticFeedbackType.Companion]
 * */
@InternalCupertinoApi
object CupertinoHapticFeedback {

    val SelectionChanged : HapticFeedbackType = HapticFeedbackType(1001)

    val Success : HapticFeedbackType = HapticFeedbackType(2001)
    val Warning : HapticFeedbackType = HapticFeedbackType(2002)
    val Error : HapticFeedbackType = HapticFeedbackType(2003)

    val ImpactLight : HapticFeedbackType = HapticFeedbackType(3001)
    val ImpactMedium : HapticFeedbackType = HapticFeedbackType(3002)
    val ImpactHeavy : HapticFeedbackType = HapticFeedbackType(3003)
    val ImpactRigid : HapticFeedbackType = HapticFeedbackType(3004)
    val ImpactSoft : HapticFeedbackType = HapticFeedbackType(3005)
}
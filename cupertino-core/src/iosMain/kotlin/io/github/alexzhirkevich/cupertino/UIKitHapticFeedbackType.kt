

@file:OptIn(InternalCupertinoApi::class)

package io.github.alexzhirkevich.cupertino

import androidx.compose.ui.hapticfeedback.HapticFeedbackType


val HapticFeedbackType.Companion.SelectionChanged : HapticFeedbackType
    get() = CupertinoHapticFeedback.SelectionChanged

val HapticFeedbackType.Companion.Success : HapticFeedbackType
    get() = CupertinoHapticFeedback.Success
val HapticFeedbackType.Companion.Warning : HapticFeedbackType
    get() = CupertinoHapticFeedback.Warning
val HapticFeedbackType.Companion.Error : HapticFeedbackType
    get() = CupertinoHapticFeedback.Error

val HapticFeedbackType.Companion.ImpactLight : HapticFeedbackType
    get() = CupertinoHapticFeedback.ImpactLight
val HapticFeedbackType.Companion.ImpactMedium : HapticFeedbackType
    get() = CupertinoHapticFeedback.ImpactMedium
val HapticFeedbackType.Companion.ImpactHeavy : HapticFeedbackType
    get() = CupertinoHapticFeedback.ImpactHeavy
val HapticFeedbackType.Companion.ImpactRigid : HapticFeedbackType
    get() = CupertinoHapticFeedback.ImpactRigid
val HapticFeedbackType.Companion.ImpactSoft : HapticFeedbackType
    get() = CupertinoHapticFeedback.ImpactSoft
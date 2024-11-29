package com.slapps.cupertino

import androidx.compose.ui.Modifier
import androidx.compose.foundation.systemGestureExclusion as androidSystemGestureExclusion

internal actual fun Modifier.systemGestureExclusion() = androidSystemGestureExclusion()
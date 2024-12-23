

package com.slapps.cupertino

import androidx.compose.runtime.Composable
import androidx.compose.ui.hapticfeedback.HapticFeedback
import androidx.compose.ui.platform.LocalHapticFeedback

@Composable
actual fun rememberCupertinoHapticFeedback(): HapticFeedback = LocalHapticFeedback.current

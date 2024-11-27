

package io.github.alexzhirkevich.cupertino.adaptive

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.isSpecified

inline fun Color?.takeOrElse(block: () -> Color): Color = if (this != null && isSpecified) this else block()

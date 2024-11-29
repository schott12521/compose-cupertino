

package com.slapps.cupertino.adaptive.icons

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import com.slapps.cupertino.icons.CupertinoIcons
import com.slapps.cupertino.named

@Composable
internal actual fun systemImage(name: String): Painter? = runCatching { CupertinoIcons.named(name) }.getOrNull()

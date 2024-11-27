

package io.github.alexzhirkevich.cupertino.adaptive.icons

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import io.github.alexzhirkevich.cupertino.icons.CupertinoIcons
import io.github.alexzhirkevich.cupertino.named

@Composable
internal actual fun systemImage(name: String): Painter? = runCatching { CupertinoIcons.named(name) }.getOrNull()

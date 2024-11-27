

package io.github.alexzhirkevich

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * Interoperable composition local for content color.
 *
 * Depending on current theme, this local will point to the
 * - internal LocalContentColor - for CupertinoTheme
 * - androidx.compose.matarial3.LocalContentColor - for AdaptiveTheme
 *
 * It used as source of local content color in all cupertino widgets.
 * And therefore for AdaptiveTheme there is no difference between using composables like material3
 * Icon and CupertinoIcon where LocalContentColor.current is passed as a default parameter.
 *
 * You can provide your own local (for ex. basic Material local) using [LocalContentColorProvider]
 * */
val LocalContentColor: ProvidableCompositionLocal<Color>
    @Composable
    @ReadOnlyComposable
    get() = LocalContentColorProvider.current

val LocalContentColorProvider =
    staticCompositionLocalOf {
        EmptyLocalColor
    }

private val EmptyLocalColor =
    compositionLocalOf {
        Color.Black
    }

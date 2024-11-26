

package io.github.alexzhirkevich


import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle


/**
 * Interoperable composition local for text style.
 *
 * Depending on current theme, this local will point to the
 * - internal LocalTextStyle - for CupertinoTheme
 * - androidx.compose.material3.LocalTextStyle - for AdaptiveTheme
 *
 * It used as source of local text style in all cupertino widgets.
 * And therefore for AdaptiveTheme there is no difference between using composables like material3
 * Text and CupertinoText where LocalTextStyle.current is passed as a default parameter.
 *
 * You can provide your own local (for ex. basic Material local) using [LocalTextStyleProvider]
 * */
val LocalTextStyle : ProvidableCompositionLocal<TextStyle>
    @Composable
    get() = LocalTextStyleProvider.current


val LocalTextStyleProvider = staticCompositionLocalOf {
    EmptyLocalTextStyle
}

private val EmptyLocalTextStyle = compositionLocalOf {
    TextStyle()
}
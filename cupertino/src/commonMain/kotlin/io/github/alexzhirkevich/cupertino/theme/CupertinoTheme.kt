


package io.github.alexzhirkevich.cupertino.theme

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalHapticFeedback
import io.github.alexzhirkevich.LocalContentColor
import io.github.alexzhirkevich.LocalTextStyle
import io.github.alexzhirkevich.cupertino.ExperimentalCupertinoApi
import io.github.alexzhirkevich.cupertino.InternalCupertinoApi
import io.github.alexzhirkevich.cupertino.SystemBarAppearance
import io.github.alexzhirkevich.cupertino.rememberCupertinoHapticFeedback
import io.github.alexzhirkevich.cupertino.rememberCupertinoIndication

@OptIn(InternalCupertinoApi::class, ExperimentalCupertinoApi::class)
@Composable
fun CupertinoTheme(
    colorScheme: ColorScheme = if (isSystemInDarkTheme())
        darkColorScheme() else lightColorScheme(),
    shapes: Shapes = Shapes(),
    typography: Typography = Typography(),
    content : @Composable () -> Unit
) {
    SystemBarAppearance(colorScheme.isDark)
    CompositionLocalProvider(
        LocalColorScheme provides colorScheme,
        LocalShapes provides shapes,
        LocalTypography provides typography,
        LocalTextStyle provides typography.body,
        LocalContentColor provides colorScheme.label,
        LocalIndication provides rememberCupertinoIndication(),
        LocalHapticFeedback provides rememberCupertinoHapticFeedback(),
        content = content
    )
}

internal val BrightSeparatorColor
    get() = CupertinoColors.Gray.copy(alpha = .5f)

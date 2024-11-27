

package io.github.alexzhirkevich.cupertino.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

@Composable
@ReadOnlyComposable
internal fun isDark() = CupertinoTheme.colorScheme.isDark

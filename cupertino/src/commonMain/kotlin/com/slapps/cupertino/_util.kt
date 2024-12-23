

package com.slapps.cupertino

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection

@Composable
@ReadOnlyComposable
internal fun PaddingValues.copy(
    top: Dp = calculateTopPadding(),
    start: Dp = calculateStartPadding(LocalLayoutDirection.current),
    bottom: Dp = calculateBottomPadding(),
    end: Dp = calculateEndPadding(LocalLayoutDirection.current),
): PaddingValues =
    PaddingValues(
        top = top,
        start = start,
        end = end,
        bottom = bottom,
    )

@ReadOnlyComposable
internal fun PaddingValues.copy(
    layoutDirection: LayoutDirection,
    top: Dp = calculateTopPadding(),
    start: Dp = calculateStartPadding(layoutDirection),
    bottom: Dp = calculateBottomPadding(),
    end: Dp = calculateEndPadding(layoutDirection),
): PaddingValues =
    PaddingValues(
        top = top,
        start = start,
        end = end,
        bottom = bottom,
    )

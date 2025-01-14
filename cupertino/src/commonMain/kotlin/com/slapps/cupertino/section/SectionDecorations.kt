/*
 * Copyright (c) 2023-2024. Compose Cupertino project and open source contributors.
 * Copyright (c) 2025. Scott Lanoue.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.slapps.cupertino.section

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.slapps.cupertino.LocalContentColor
import com.slapps.cupertino.CupertinoHorizontalDivider
import com.slapps.cupertino.CupertinoIcon
import com.slapps.cupertino.CupertinoIconDefaults
import com.slapps.cupertino.ProvideTextStyle
import com.slapps.cupertino.icons.CupertinoIcons
import com.slapps.cupertino.icons.outlined.ChevronBackward
import com.slapps.cupertino.icons.outlined.ChevronForward
import com.slapps.cupertino.theme.CupertinoTheme

@Composable
internal fun SectionTitle(
    style: SectionStyle,
    state: SectionState?,
    lazy: Boolean,
    autoPadding: Boolean = true,
    content: @Composable (PaddingValues) -> Unit,
) {
    val additionalPadding =
        when {
            !lazy -> PaddingValues(0.dp)
            style == SectionStyle.InsetGrouped ->
                PaddingValues(
                    horizontal = CupertinoSectionTokens.HorizontalPadding,
                )
            else -> PaddingValues(0.dp)
        }

    val basePadding =
        PaddingValues(
            start =
                if (!lazy && style == SectionStyle.Sidebar) {
                    0.dp
                } else {
                    CupertinoSectionTokens.HorizontalPadding
                },
            end = CupertinoSectionTokens.HorizontalPadding,
            bottom =
                if (style == SectionStyle.Sidebar) {
                    CupertinoSectionTokens.InlinePadding * 2
                } else {
                    CupertinoSectionTokens.InlinePadding
                },
        )

    CompositionLocalProvider(
        LocalContentColor provides CupertinoSectionDefaults.titleColor(style),
        LocalSectionStyle provides style,
    ) {
        val tapModifier =
            if (state != null && style == SectionStyle.Sidebar && state.canCollapse) {
                Modifier
                    .fillMaxWidth()
                    .clickable(
                        onClickLabel = if (state.isCollapsed) "Expand" else "Hide",
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = state::toggle,
                        indication = null,
                    )
            } else {
                Modifier
            }

        ProvideTextStyle(CupertinoSectionDefaults.titleTextStyle(style)) {
            Box(
                modifier =
                    tapModifier
                        .then(if (autoPadding) Modifier.padding(basePadding) else Modifier)
                        .then(if (autoPadding) Modifier.padding(additionalPadding) else Modifier),
                contentAlignment = Alignment.CenterStart,
            ) {
                content(if (!autoPadding) basePadding + additionalPadding else ZeroPadding)

                if (style == SectionStyle.Sidebar && state != null && state.canCollapse) {
                    val isLtr = LocalLayoutDirection.current == LayoutDirection.Ltr

                    val rotation by animateFloatAsState(
                        targetValue =
                            when {
                                state.isCollapsed -> 0f
                                isLtr -> 90f
                                else -> -90f
                            },
                        animationSpec =
                            spring(
                                stiffness = Spring.StiffnessMediumLow,
                            ),
                    )

                    CupertinoIcon(
                        imageVector =
                            if (isLtr) {
                                CupertinoIcons.Default.ChevronForward
                            } else {
                                CupertinoIcons.Default.ChevronBackward
                            },
                        contentDescription = "Collapse",
                        modifier =
                            Modifier
                                .padding(
                                    end =
                                        when {
                                            !lazy -> 0.dp
                                            autoPadding -> CupertinoSectionTokens.HorizontalPadding
                                            else -> CupertinoSectionTokens.HorizontalPadding * 2
                                        },
                                ).size(CupertinoIconDefaults.SmallSize)
                                .align(Alignment.CenterEnd)
                                .graphicsLayer {
                                    rotationZ = rotation
                                },
                        tint = CupertinoTheme.colorScheme.accent,
                    )
                }
            }
        }
    }
}

private val ZeroPadding = PaddingValues(0.dp)

@Composable
private operator fun PaddingValues.plus(other: PaddingValues): PaddingValues {
    val layoutDirection = LocalLayoutDirection.current

    return PaddingValues(
        top = calculateTopPadding() + other.calculateTopPadding(),
        bottom = calculateBottomPadding() + other.calculateBottomPadding(),
        start = calculateStartPadding(layoutDirection) + other.calculateStartPadding(layoutDirection),
        end = calculateEndPadding(layoutDirection) + other.calculateEndPadding(layoutDirection),
    )
}

@Composable
internal fun SectionCaption(
    style: SectionStyle,
    lazy: Boolean,
    content: @Composable () -> Unit,
) {
    val addCorner =
        if (style.inset && style.grouped && lazy) {
            CupertinoSectionTokens.HorizontalPadding
        } else {
            0.dp
        }

    CompositionLocalProvider(
        LocalContentColor provides CupertinoSectionDefaults.captionColor(style),
        LocalSectionStyle provides style,
    ) {
        ProvideTextStyle(CupertinoSectionDefaults.captionTextStyle(style)) {
            Box(
                Modifier.padding(
                    PaddingValues(
                        horizontal = CupertinoSectionTokens.HorizontalPadding + addCorner,
                        vertical = CupertinoSectionTokens.InlinePadding,
                    ),
                ),
            ) {
                content()
            }
        }
    }
}

@Composable
internal fun SectionDivider(
    style: SectionStyle,
    modifier: Modifier = Modifier,
) {
    if (style.inset && style.grouped) {
        return
    }

    CupertinoHorizontalDivider(
        modifier =
            modifier.padding(
                start =
                    if (style.grouped) {
                        0.dp
                    } else {
                        CupertinoSectionTokens.HorizontalPadding
                    },
            ),
    )
}

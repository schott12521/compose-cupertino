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

package com.slapps.cupertino.swipebox

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.animateTo
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.slapps.cupertino.LocalContentColor
import com.slapps.cupertino.CupertinoIcon
import com.slapps.cupertino.CupertinoText
import com.slapps.cupertino.ExperimentalCupertinoApi
import com.slapps.cupertino.ProvideTextStyle
import com.slapps.cupertino.cupertinoTween
import com.slapps.cupertino.theme.CupertinoColors
import com.slapps.cupertino.theme.CupertinoTheme
import com.slapps.cupertino.theme.White
import kotlinx.coroutines.launch

/**
 * TODO javadocs
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
@ExperimentalCupertinoApi
fun RowScope.CupertinoSwipeBoxItem(
    color: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    restoreOnClick: Boolean = true,
    onClickLabel: String? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    icon: ImageVector? = null,
    label: String? = null,
    weight: Float = 1f,
) {
    val state = LocalSwipeBoxState.current
    val actionPosition = LocalSwipeActionPosition.current
    val isFullSwipeActionItem = LocalSwipeBoxItemFullSwipe.current
    val shouldRenderItem =
        !(state.currentValue == SwipeBoxStates.EndFullyExpanded || state.currentValue == SwipeBoxStates.StartFullyExpanded) ||
            isFullSwipeActionItem

    val zIndex = if (isFullSwipeActionItem) 1f else 0f

    val coroutineScope = rememberCoroutineScope()
    val currentOnClick by rememberUpdatedState(onClick)

    // TODO use widths directly instead of weights
    // We can't have negative weights, so make it as small as possible
    val animatedWeight by animateFloatAsState(
        targetValue = if (shouldRenderItem) weight else 0.000000001f,
        animationSpec = cupertinoTween(),
    )

    val animHorizontalBias by animateFloatAsState(
        when {
            (state.currentValue == SwipeBoxStates.EndFullyExpanded) && (actionPosition == CupertinoSwipeActionPosition.End) -> -1f // Start
            (state.currentValue == SwipeBoxStates.StartFullyExpanded) && (actionPosition == CupertinoSwipeActionPosition.Start) -> 1f
            (state.currentValue == SwipeBoxStates.Resting) && (actionPosition == CupertinoSwipeActionPosition.End) -> 1f
            (state.currentValue == SwipeBoxStates.Resting) && (actionPosition == CupertinoSwipeActionPosition.Start) -> -1f // Start
            else -> 0f
        },
        animationSpec = cupertinoTween(),
    )

    // Set content color and typography style using CompositionLocalProvider
    CompositionLocalProvider(LocalContentColor provides CupertinoColors.White) {
        ProvideTextStyle(CupertinoTheme.typography.footnote) {
            Box(
                modifier =
                    modifier
                        .weight(animatedWeight)
                        .zIndex(zIndex)
                        .fillMaxSize()
                        .background(color)
                        .align(Alignment.CenterVertically)
                        .clickable(
                            enabled = enabled,
                            indication = LocalIndication.current,
                            interactionSource = interactionSource,
                            onClick = {
                                currentOnClick()
                                if (restoreOnClick) {
                                    coroutineScope.launch {
                                        state.animateTo(SwipeBoxStates.Resting)
                                    }
                                }
                            },
                            onClickLabel = onClickLabel,
                            role = Role.Button,
                        ).padding(horizontal = 8.dp),
                // TODO hardcore removal
                contentAlignment =
                    BiasAlignment(
                        verticalBias = 0f,
                        horizontalBias = animHorizontalBias,
                    ),
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    icon?.let {
                        CupertinoIcon(
                            imageVector = it,
                            contentDescription = onClickLabel,
                            tint = CupertinoColors.White,
                            modifier = Modifier.requiredSize(20.dp),
                        )
                    }

                    label?.let {
                        CupertinoText(
                            it,
                            fontSize = 12.sp,
                            maxLines = 1,
                        )
                    }
                }
            }
        }
    }
}

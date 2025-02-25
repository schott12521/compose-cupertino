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

@file:OptIn(ExperimentalFoundationApi::class)

package com.slapps.cupertino


import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.SpringSpec
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.anchoredDraggable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.slapps.cupertino.section.CupertinoSectionDefaults
import com.slapps.cupertino.swipebox.AnchorsEffect
import com.slapps.cupertino.swipebox.DismissFullyExpandedEffect
import com.slapps.cupertino.swipebox.HapticFeedbackEffect
import com.slapps.cupertino.swipebox.LocalSwipeActionPosition
import com.slapps.cupertino.swipebox.LocalSwipeBoxState
import com.slapps.cupertino.swipebox.CupertinoSwipeActionPosition
import com.slapps.cupertino.swipebox.CupertinoSwipeBoxActionsBuilder
import com.slapps.cupertino.swipebox.LocalSwipeBoxItemFullSwipe
import com.slapps.cupertino.swipebox.SwipeBoxStates
import com.slapps.cupertino.swipebox.rememberCupertinoSwipeBoxState
import kotlin.math.roundToInt

// TODO clean this up
object CupertinoSwipeBoxDefaults {
    val allowFullSwipe = true
    val velocityThreshold = Float.POSITIVE_INFINITY
    val actionItemWidth = 84.dp
    val actionItemHeight = 72.dp
    val animationSpec: SpringSpec<Float> = SpringSpec(
        stiffness = Spring.StiffnessMedium,
        dampingRatio = Spring.DampingRatioNoBouncy
    )
}

/**
 * Swipe box that can display multiple actions for list item and perform dismiss operations.
 *
 * @param state swipe box state. See [rememberCupertinoSwipeBoxState]
 * @param items action items. Use [CupertinoSwipeBoxState.dismissDirection] to display start or end items.
 * [CupertinoSwipeBoxItem] should be used as an item.
 * Items are displayed in a row with parallax and bound effect. Display direction for end items is reversed.
 * @param modifier box container modifier.
 * Any other tap gestures will be consumed.
 * @param itemWidth width of the actions items.
 * @param startToEndFullSwipeEnabled if start to end expansion/dismissal is enabled.
 * @param endToStartFullSwipeEnabled if end to start expansion/dismissal is enabled.
 * @param content foreground content. Should have a non-transparent background
 *
 * @see CupertinoSwipeBoxItem
 * */
@OptIn(ExperimentalFoundationApi::class, InternalCupertinoApi::class)
@Composable
fun CupertinoSwipeBox(
    state: AnchoredDraggableState<SwipeBoxStates> = rememberCupertinoSwipeBoxState(),
    modifier: Modifier = Modifier,
    itemWidth: Dp = CupertinoSwipeBoxDefaults.actionItemWidth,
    height: Dp = CupertinoSwipeBoxDefaults.actionItemHeight,
    startToEndFullSwipeEnabled: Boolean = CupertinoSwipeBoxDefaults.allowFullSwipe,
    endToStartFullSwipeEnabled: Boolean = CupertinoSwipeBoxDefaults.allowFullSwipe,
    actionItemBuilder: CupertinoSwipeBoxActionsBuilder.() -> Unit,
    content: @Composable BoxScope.() -> Unit
) {
    val density = LocalDensity.current
    var parentWidth by remember { mutableStateOf(0) }
    val actionItems = CupertinoSwipeBoxActionsBuilder().apply(actionItemBuilder)
    val startActionsSize = actionItems.startActions.size
    val endActionsSize = actionItems.endActions.size
    val isStartActionItemSupplied = startActionsSize != 0
    val isEndActionItemSupplied = endActionsSize != 0
    val startFullSwipeAction = actionItems.startActions.firstOrNull()?.onClick
    val endFullSwipeAction = actionItems.endActions.lastOrNull()?.onClick

    val hapticFeedback = LocalHapticFeedback.current
    var hasTriggeredHapticFeedback by remember { mutableStateOf(false) }
    var anchorsInitialized by remember { mutableStateOf(false) }

    // Store state of fully expanded
    val isFullyExpandedStart = remember { mutableStateOf(false) }
    val isFullyExpandedEnd = remember { mutableStateOf(false) }

    AnchorsEffect(
        parentWidth = parentWidth,
        fullExpansionStart = startToEndFullSwipeEnabled,
        isStartActionItemSupplied = isStartActionItemSupplied,
        fullExpansionEnd = endToStartFullSwipeEnabled,
        isEndActionItemSupplied = isEndActionItemSupplied,
        swipeBoxState = state,
        density = density,
        amountOfStartActionItems = startActionsSize,
        amountOfEndActionItems = endActionsSize,
        actionItemWidth = itemWidth
    ) { anchorsInitialized = it }

    HapticFeedbackEffect(
        fullExpansionStart = startToEndFullSwipeEnabled,
        fullExpansionEnd = endToStartFullSwipeEnabled,
        isFullyExpandedStart = isFullyExpandedStart,
        isFullyExpandedEnd = isFullyExpandedEnd,
        swipeBoxState = state,
        hapticFeedback = hapticFeedback,
        hasTriggeredHapticFeedback = hasTriggeredHapticFeedback
    ) { hasTriggeredHapticFeedback = it }

    DismissFullyExpandedEffect(
        swipeBoxState = state,
        isStartActionItemSupplied = isStartActionItemSupplied,
        fullExpansionStart = startToEndFullSwipeEnabled,
        isEndActionItemSupplied = isEndActionItemSupplied,
        fullExpansionEnd = endToStartFullSwipeEnabled,
        startFullExpansionOnClick = startFullSwipeAction,
        endFullExpansionOnClick = endFullSwipeAction
    )

    CompositionLocalProvider(
        LocalSwipeBoxState provides state
    ) {
        Box(
            modifier = modifier.then(
                Modifier
                    .fillMaxSize()
                    .onGloballyPositioned { coordinates ->
                        parentWidth = coordinates.size.width
                    }
            )
        ) {
            val offset by remember {
                derivedStateOf {
                    if (anchorsInitialized) state.offset else 0f
                }
            }

            if (offset > 0 && isStartActionItemSupplied) {
                CompositionLocalProvider(
                    LocalSwipeActionPosition provides CupertinoSwipeActionPosition.Start
                ) {
                    Box(
                        modifier = Modifier
                            .height(height)
                            .width(with(density) { offset.toDp() })
                            .align(Alignment.CenterStart)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            actionItems.startActions.forEachIndexed { index, swipeAction ->
                                CompositionLocalProvider(
                                    LocalSwipeBoxItemFullSwipe provides (index == 0)
                                ) {
                                    key(swipeAction.key) {
                                        swipeAction.content.let { it() }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (offset < 0 && isEndActionItemSupplied) {
                CompositionLocalProvider(
                    LocalSwipeActionPosition provides CupertinoSwipeActionPosition.End
                ) {
                    Box(
                        modifier = Modifier
                            .height(height)
                            .width(with(density) { -offset.toDp() })
                            .align(Alignment.CenterEnd)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.End
                        ) {
                            actionItems.endActions.forEachIndexed { index, swipeAction ->
                                CompositionLocalProvider(
                                    LocalSwipeBoxItemFullSwipe provides (index == actionItems.endActions.lastIndex)
                                ) {
                                    key(swipeAction.key) {
                                        swipeAction.content.let { it() }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (anchorsInitialized) {
                Box(
                    modifier = Modifier
                        .offset { IntOffset(state.requireOffset().roundToInt(), 0) }
                        .anchoredDraggable(
                            state = state,
                            orientation = Orientation.Horizontal
                        )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .height(height)
                            .background(LocalContainerColor.current)
                            .padding(
                                start = CupertinoSectionDefaults.PaddingValues
                                    .calculateStartPadding(LocalLayoutDirection.current),
                                end = CupertinoSectionDefaults.PaddingValues
                                    .calculateStartPadding(LocalLayoutDirection.current)
                            )
                    ) {
                        content()
                    }
                }
            }
        }
    }
}
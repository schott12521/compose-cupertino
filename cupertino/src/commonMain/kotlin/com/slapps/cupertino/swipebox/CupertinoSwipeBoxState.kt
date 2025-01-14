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

import androidx.compose.animation.core.SpringSpec
import androidx.compose.animation.splineBasedDecay
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalDensity
import com.slapps.cupertino.InternalCupertinoApi
import com.slapps.cupertino.CupertinoSwipeBoxDefaults
import kotlinx.coroutines.CoroutineScope

enum class SwipeBoxStates {
    Resting,
    EndVisible,
    StartVisible,
    EndFullyExpanded,
    StartFullyExpanded,
}

/**
 * TODO javadocs
 *
 */
@OptIn(ExperimentalFoundationApi::class, InternalCupertinoApi::class,)
@Composable
fun rememberCupertinoSwipeBoxState(
    key: Any? = null,
    initialValue: SwipeBoxStates = SwipeBoxStates.Resting,
    positionalThreshold: (distance: Float) -> Float = { distance -> distance },
    velocityThreshold: Float = CupertinoSwipeBoxDefaults.velocityThreshold,
    animationSpec: SpringSpec<Float> = CupertinoSwipeBoxDefaults.animationSpec,
    scrollableState: ScrollableState? = null,
    openSwipeBoxState: MutableState<AnchoredDraggableState<SwipeBoxStates>?> = mutableStateOf(null),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
): AnchoredDraggableState<SwipeBoxStates> {
    val density = LocalDensity.current

    val anchoredDraggableState =  remember(key) {
        AnchoredDraggableState(
            initialValue = initialValue,
            snapAnimationSpec = animationSpec,
            decayAnimationSpec = splineBasedDecay(density),
            positionalThreshold = positionalThreshold,
            velocityThreshold = { velocityThreshold }
        )
    }

    ScrollEffect(
        scrollableState = scrollableState,
        swipeBoxState = anchoredDraggableState
    )

    ObserverGlobalSwipeBoxListenerEffect(
        state = anchoredDraggableState,
        openSwipeBoxState = openSwipeBoxState,
        coroutineScope = coroutineScope
    )

    return anchoredDraggableState
}
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

import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable

class CupertinoSwipeBoxActionsBuilder {
    private val _startActions = mutableListOf<SwipeAction>()
    private val _endActions = mutableListOf<SwipeAction>()

    val startActions: List<SwipeAction> get() = _startActions
    val endActions: List<SwipeAction> get() = _endActions

    fun start(
        key: Any? = null,
        onClick: (() -> Unit)? = null,
        content: @Composable RowScope.() -> Unit,
    ) {
        _startActions.add(SwipeAction(key, onClick, content))
    }

    fun end(
        key: Any? = null,
        onClick: (() -> Unit)? = null,
        content: @Composable RowScope.() -> Unit,
    ) {
        _endActions.add(SwipeAction(key, onClick, content))
    }

    class SwipeAction(
        val key: Any? = null,
        val onClick: (() -> Unit)? = null,
        val content: @Composable RowScope.() -> Unit,
    )
}

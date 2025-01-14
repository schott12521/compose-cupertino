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

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

/**
 * Section state is used to manage collapsing behavior and state of sections with [SectionStyle.Sidebar]
 * */
@Composable
fun rememberSectionState(
    initiallyCollapsed: Boolean = false,
    canCollapse: Boolean = true,
): SectionState =
    rememberSaveable(
        saver = SectionState.Saver(),
    ) {
        SectionState(
            initiallyCollapsed = initiallyCollapsed,
            canCollapse = canCollapse,
        )
    }

/**
 * Section state is used to manage collapsing behavior and state of sections with [SectionStyle.Sidebar]
 * */
@Stable
class SectionState(
    initiallyCollapsed: Boolean,
    canCollapse: Boolean,
) {
    var isCollapsed by mutableStateOf(initiallyCollapsed)
        private set

    var canCollapse by mutableStateOf(canCollapse)

    fun toggle() {
        if (isCollapsed) {
            expand()
        } else {
            collapse()
        }
    }

    fun collapse() {
        isCollapsed = true
    }

    fun expand() {
        isCollapsed = false
    }

    companion object {
        fun Saver(): Saver<SectionState, *> =
            Saver(
                save = {
                    listOf(it.isCollapsed, it.canCollapse)
                },
                restore = {
                    SectionState(
                        initiallyCollapsed = it[0],
                        canCollapse = it[1],
                    )
                },
            )
    }
}

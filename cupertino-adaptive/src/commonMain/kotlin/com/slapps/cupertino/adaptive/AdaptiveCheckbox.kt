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

package com.slapps.cupertino.adaptive

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import com.slapps.cupertino.CupertinoCheckBox
import com.slapps.cupertino.CupertinoCheckboxColors
import com.slapps.cupertino.CupertinoCheckboxDefaults
import com.slapps.cupertino.CupertinoTriStateCheckBox

@ExperimentalAdaptiveApi
@Composable
fun AdaptiveCheckbox(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    adaptation : AdaptationScope<CupertinoCheckBoxAdaptation, MaterialCheckBoxAdaptation>.() -> Unit = {}
) {
    AdaptiveWidget(
        adaptation = remember { CheckBoxAdaptation() },
        adaptationScope = adaptation,
        material = {
            Checkbox(
                checked = checked,
                onCheckedChange = onCheckedChange,
                modifier = modifier,
                enabled = enabled,
                interactionSource = interactionSource,
                colors = it.colors
            )
        },
        cupertino = {
            CupertinoCheckBox(
                checked = checked,
                onCheckedChange = onCheckedChange,
                modifier = modifier,
                enabled = enabled,
                interactionSource = interactionSource,
                colors = it.colors
            )
        }
    )
}

@ExperimentalAdaptiveApi
@Composable
fun AdaptiveTriStateCheckbox(
    state: ToggleableState,
    onClick: (() -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    adaptation : AdaptationScope<CupertinoCheckBoxAdaptation, MaterialCheckBoxAdaptation>.() -> Unit = {}
) {
    AdaptiveWidget(
        adaptation = remember { CheckBoxAdaptation() },
        adaptationScope = adaptation,
        material = {
            TriStateCheckbox(
                state = state,
                onClick = onClick,
                modifier = modifier,
                enabled = enabled,
                interactionSource = interactionSource,
                colors = it.colors
            )
        },
        cupertino = {
            CupertinoTriStateCheckBox(
                state = state,
                onClick = onClick,
                modifier = modifier,
                enabled = enabled,
                interactionSource = interactionSource,
                colors = it.colors
            )
        }
    )
}

@Stable
class MaterialCheckBoxAdaptation(
    colors: CheckboxColors
) {
    var colors: CheckboxColors by mutableStateOf(colors)
}

@Stable
class CupertinoCheckBoxAdaptation(
    colors : CupertinoCheckboxColors
){
    var colors : CupertinoCheckboxColors by mutableStateOf(colors)
}

@OptIn(ExperimentalAdaptiveApi::class)
@Stable
private class CheckBoxAdaptation : Adaptation<CupertinoCheckBoxAdaptation, MaterialCheckBoxAdaptation>(){

    @Composable
    override fun rememberCupertinoAdaptation(): CupertinoCheckBoxAdaptation {
        val colors = CupertinoCheckboxDefaults.colors()

        return remember(colors) {
            CupertinoCheckBoxAdaptation(colors)
        }
    }

    @Composable
    override fun rememberMaterialAdaptation(): MaterialCheckBoxAdaptation {
        val colors = CheckboxDefaults.colors()

        return remember(colors) {
            MaterialCheckBoxAdaptation(colors)
        }
    }

}
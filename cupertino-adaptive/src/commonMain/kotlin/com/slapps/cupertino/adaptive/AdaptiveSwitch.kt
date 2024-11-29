

package com.slapps.cupertino.adaptive

import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.slapps.cupertino.CupertinoSwitch
import com.slapps.cupertino.CupertinoSwitchColors
import com.slapps.cupertino.CupertinoSwitchDefaults

/**
 * Adaptive Switch depending on current [Theme].
 *
 * Switches toggle the state of a single item on or off.
 *
 * @param checked whether or not this switch is checked
 * @param onCheckedChange called when this switch is clicked. If `null`, then this switch will not
 * be interactable, unless something else handles its input events and updates its state.
 * @param modifier the [Modifier] to be applied to this switch
 * @param thumbContent content that will be drawn inside the thumb
 * @param enabled controls the enabled state of this switch. When `false`, this component will not
 * respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * @param adaptation configuration block for theme-dependent properties for this switch
 */
@ExperimentalAdaptiveApi
@Composable
fun AdaptiveSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    thumbContent: @Composable (() -> Unit)? = null,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    adaptation: AdaptationScope<CupertinoSwitchAdaptation, MaterialSwitchAdaptation>.() -> Unit = {},
) {
    AdaptiveWidget(
        adaptation = remember {
            SwitchAdaptation()
        },
        adaptationScope = adaptation,
        material = {
            Switch(
                checked = checked,
                onCheckedChange = onCheckedChange,
                modifier = modifier,
                thumbContent = thumbContent,
                enabled = enabled,
                interactionSource = interactionSource,
                colors = it.colors
            )
        },
        cupertino = {
            CupertinoSwitch(
                checked = checked,
                onCheckedChange = onCheckedChange,
                enabled = enabled,
                modifier = modifier,
                thumbContent = thumbContent,
                interactionSource = interactionSource,
                colors = it.colors
            )
        }
    )
}

@Stable
class CupertinoSwitchAdaptation internal constructor(
    colors : CupertinoSwitchColors
) {
    var colors by mutableStateOf(colors)
}

@Stable
class MaterialSwitchAdaptation internal constructor(
    colors : SwitchColors
) {
    var colors by mutableStateOf(colors)
}

@Stable
private class SwitchAdaptation :
    Adaptation<CupertinoSwitchAdaptation, MaterialSwitchAdaptation>() {

    @Composable
    override fun rememberCupertinoAdaptation(): CupertinoSwitchAdaptation {

        val colors = CupertinoSwitchDefaults.colors()

        return remember(colors) {
            CupertinoSwitchAdaptation(
                colors = colors
            )
        }
    }

    @Composable
    override fun rememberMaterialAdaptation(): MaterialSwitchAdaptation {

        val colors = SwitchDefaults.colors()

        return remember(colors) {
            MaterialSwitchAdaptation(colors)
        }
    }
}

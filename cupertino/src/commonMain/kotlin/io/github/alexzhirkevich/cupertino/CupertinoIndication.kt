

package io.github.alexzhirkevich.cupertino

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Indication
import androidx.compose.foundation.IndicationNodeFactory
import androidx.compose.foundation.interaction.FocusInteraction
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.node.DrawModifierNode
import io.github.alexzhirkevich.LocalContentColor
import kotlinx.coroutines.launch

/**
 * Cupertino click effect
 * */
@Composable
@ExperimentalCupertinoApi
fun rememberCupertinoIndication(color: Color = CupertinoIndication.DefaultColor): Indication =
    remember(color) {
        CupertinoIndication(color)
    }

internal class CupertinoIndication(
    private val color: Color,
) : IndicationNodeFactory {
    companion object {
        val DefaultColor: Color
            @Composable
            @ReadOnlyComposable
            get() = LocalContentColor.current.copy(alpha = DefaultAlpha)

        const val DefaultAlpha = 0.1f
    }

    override fun create(interactionSource: InteractionSource): Modifier.Node = CupertinoIndicationNode(color, interactionSource)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CupertinoIndication) return false
        return color == other.color
    }

    override fun hashCode(): Int = color.hashCode()
}

internal class CupertinoIndicationNode(
    val color: Color,
    val interactionSource: InteractionSource,
) : Modifier.Node(),
    DrawModifierNode {
    private val animatedAlpha =
        androidx.compose.animation.core
            .Animatable(0f)

    private val pressInteractions = mutableSetOf<PressInteraction.Press>()
    private val focusInteractions = mutableSetOf<FocusInteraction.Focus>()

    override fun onAttach() {
        coroutineScope.launch {
            interactionSource.interactions.collect { interaction ->
                when (interaction) {
                    is PressInteraction.Press -> {
                        pressInteractions.add(interaction)
                        animateAlphaTo(1f)
                    }
                    is PressInteraction.Release -> {
                        // Correctly remove the corresponding PressInteraction.Press
                        pressInteractions.remove(interaction.press)
                        if (pressInteractions.isEmpty()) {
                            animateAlphaTo(if (focusInteractions.isNotEmpty()) 0.5f else 0f)
                        }
                    }
                    is PressInteraction.Cancel -> {
                        // Correctly remove the corresponding PressInteraction.Press
                        pressInteractions.remove(interaction.press)
                        if (pressInteractions.isEmpty()) {
                            animateAlphaTo(if (focusInteractions.isNotEmpty()) 0.5f else 0f)
                        }
                    }
                    is FocusInteraction.Focus -> {
                        focusInteractions.add(interaction)
                        if (pressInteractions.isEmpty()) {
                            animateAlphaTo(0.5f)
                        }
                    }
                    is FocusInteraction.Unfocus -> {
                        focusInteractions.remove(interaction.focus)
                        if (pressInteractions.isEmpty() && focusInteractions.isEmpty()) {
                            animateAlphaTo(0f)
                        }
                    }
                }
            }
        }
    }

    private suspend fun animateAlphaTo(targetAlpha: Float) {
        animatedAlpha.animateTo(targetAlpha, animationSpec = tween())
    }

    override fun ContentDrawScope.draw() {
        if (animatedAlpha.value > 0f) {
            drawRect(color = color, alpha = animatedAlpha.value)
        }
        drawContent()
    }
}

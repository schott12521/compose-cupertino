

package io.github.alexzhirkevich.cupertino

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.tween

/**
 * Cupertino [tween] transition spec.
 *
 * Default values are used for iOS view transitions such as
 * UINavigationController, UIAlertController
 * */
fun <T> cupertinoTween(
    durationMillis: Int = CupertinoTransitionDuration,
    delayMillis: Int = 0,
    easing: Easing = CupertinoEasing,
): TweenSpec<T> =
    tween(
        durationMillis = durationMillis,
        easing = easing,
        delayMillis = delayMillis,
    )

val CupertinoEasing = CubicBezierEasing(0.2833f, 0.99f, 0.31833f, 0.99f)
private val CupertinoTransitionDuration = 400

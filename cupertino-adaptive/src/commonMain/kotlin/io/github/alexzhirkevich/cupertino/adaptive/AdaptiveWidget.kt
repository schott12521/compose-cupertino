

package io.github.alexzhirkevich.cupertino.adaptive

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect

@Composable
@ExperimentalAdaptiveApi
fun AdaptiveWidget(
    material : @Composable () -> Unit,
    cupertino : @Composable () -> Unit
) {
    when(LocalTheme.current){
        Theme.Cupertino -> cupertino()
        else -> material()
    }
}

@Composable
@ExperimentalAdaptiveApi
fun <C,M> AdaptiveWidget(
    adaptation : Adaptation<C, M>,
    material : @Composable (M) -> Unit,
    cupertino : @Composable (C) -> Unit,
    adaptationScope : AdaptationScope<C, M>.() -> Unit,
) {
    adaptation.adaptationScope()

    when (LocalTheme.current) {
        Theme.Cupertino ->
            cupertino(adaptation.rememberUpdatedCupertinoAdaptation())

        else -> material(adaptation.rememberUpdatedMaterialAdaptation())
    }
}
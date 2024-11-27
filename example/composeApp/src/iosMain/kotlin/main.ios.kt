

import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.uikit.OnFocusBehavior
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import platform.UIKit.UIViewController

actual val IsIos: Boolean
    get() = true

fun RootComponent(lifecycleRegistry: LifecycleRegistry): RootComponent = DefaultRootComponent(DefaultComponentContext(lifecycleRegistry))

@OptIn(ExperimentalComposeApi::class)
fun MainViewController(component: RootComponent): UIViewController =
    ComposeUIViewController(
        configure = {
            onFocusBehavior = OnFocusBehavior.DoNothing
            platformLayers = false
        },
    ) {
        App(component)
    }

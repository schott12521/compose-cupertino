import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.singleWindowApplication
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.extensions.compose.lifecycle.LifecycleController
import com.arkivanov.essenty.lifecycle.LifecycleRegistry

fun main() {
    val lifecycle = LifecycleRegistry()

    val component =
        DefaultRootComponent(
            DefaultComponentContext(lifecycle = lifecycle),
        )

    val windowState =
        WindowState(
            size = DpSize(400.dp, 800.dp),
        )

    singleWindowApplication(windowState) {
        LifecycleController(lifecycle, windowState)

        App(component)
    }
}

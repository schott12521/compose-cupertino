

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.essenty.backhandler.BackDispatcher

@Composable
@ExperimentalDecomposeApi
actual fun ActualPredictiveBackGestureOverlay(
    backDispatcher: BackDispatcher,
    modifier: Modifier,
    content: @Composable () -> Unit
) = Box(modifier){
    content()
}
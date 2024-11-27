


package io.github.alexzhirkevich.cupertino.decompose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.Child
import com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimation
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

@Composable
actual fun <C : Any, T : Any> NativeChildren(
    stack: Value<ChildStack<C, T>>,
    onBack: () -> Unit,
    modifier: Modifier,
    animation: StackAnimation<C, T>?,
    content: @Composable (child: Child.Created<C, T>) -> Unit,
) {
    UIKitChildren(
        stack = stack,
        modifier = modifier,
        onBack = onBack,
        content = content,
    )
}

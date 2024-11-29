

package io.github.alexzhirkevich.cupertino.decompose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.Child
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimation
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

/**
 * Native children will use UINavigationController on iOS and [Children] on other platforms
 *
 * @param stack children stack
 * @param onBack called when active child was swiped-out and needs to be popped
 * @param modifier stack modifier. Must declare fixed size.
 * @param animation stack animation used for [Children]. Not used on iOS
 * @param content child content
 * */
@Composable
expect fun <C : Any, T : Any> NativeChildren(
    stack: Value<ChildStack<C, T>>,
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
    animation: StackAnimation<C, T>? = null,
    content: @Composable (child: Child.Created<C, T>) -> Unit,
)

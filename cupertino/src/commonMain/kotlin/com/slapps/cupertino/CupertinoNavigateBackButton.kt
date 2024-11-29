

package com.slapps.cupertino

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.slapps.cupertino.CupertinoButtonDefaults.plainButtonColors
import com.slapps.cupertino.icons.CupertinoIcons
import com.slapps.cupertino.icons.outlined.ChevronBackward
import com.slapps.cupertino.icons.outlined.ChevronForward
import com.slapps.cupertino.theme.CupertinoTheme

@Composable
@ExperimentalCupertinoApi
fun CupertinoNavigateBackButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    size: CupertinoButtonSize = CupertinoButtonSize.Regular,
    shape: Shape = size.shape(CupertinoTheme.shapes),
    colors: CupertinoButtonColors =
        plainButtonColors(),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = PaddingValues(8.dp, 4.dp),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    icon: ImageVector =
        if (LocalLayoutDirection.current == LayoutDirection.Ltr) {
            CupertinoIcons.Default.ChevronBackward
        } else {
            CupertinoIcons.Default.ChevronForward
        },
    title: @Composable RowScope.() -> Unit,
) {
    CupertinoButton(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        shape = shape,
        border = border,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        colors = colors,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CupertinoIcon(
                imageVector = icon,
                contentDescription = null,
                modifier =
                    Modifier
                        .height(CupertinoIconDefaults.MediumSize)
                        .padding(end = 6.dp),
            )
            title()
        }
    }
}

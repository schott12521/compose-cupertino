/*
 * Copyright (c) 2023-2024. Compose Cupertino project and open source contributors.
 * Copyright (c) 2025. Scott Lanoue.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



package com.slapps.cupertino

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.slapps.cupertino.section.CupertinoSectionDefaults
import com.slapps.cupertino.theme.CupertinoTheme

@ExperimentalCupertinoApi
@Composable
fun CupertinoBottomAppBar(
    modifier: Modifier = Modifier,
    isTranslucent: Boolean = true,
    isTransparent: Boolean = false,
    containerColor: Color = CupertinoNavigationBarDefaults.containerColor,
    contentColor: Color = CupertinoTheme.colorScheme.accent,
    contentPadding: PaddingValues = CupertinoSectionDefaults.PaddingValues,
    windowInsets: WindowInsets = WindowInsets.navigationBars,
    content: @Composable RowScope.() -> Unit,
) {
    val actualContainerColor =
        cupertinoTranslucentBottomBarColor(
            color = containerColor,
            isTranslucent = isTranslucent,
            isTransparent = isTransparent,
        )

    Column {
        if (!isTransparent) {
            CupertinoHorizontalDivider()
        }
        CupertinoSurface(
            modifier = modifier,
            color = actualContainerColor,
            contentColor = contentColor,
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .windowInsetsPadding(windowInsets)
                    .padding(contentPadding),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                content = content,
            )
        }
    }
}

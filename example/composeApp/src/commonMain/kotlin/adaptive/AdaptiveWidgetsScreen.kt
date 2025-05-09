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



package adaptive

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.slapps.cupertino.CupertinoNavigateBackButton
import com.slapps.cupertino.CupertinoText
import com.slapps.cupertino.ExperimentalCupertinoApi
import com.slapps.cupertino.adaptive.AdaptiveAlertDialog
import com.slapps.cupertino.adaptive.AdaptiveButton
import com.slapps.cupertino.adaptive.AdaptiveCheckbox
import com.slapps.cupertino.adaptive.AdaptiveCircularProgressIndicator
import com.slapps.cupertino.adaptive.AdaptiveDatePicker
import com.slapps.cupertino.adaptive.AdaptiveFilledIconButton
import com.slapps.cupertino.adaptive.AdaptiveIconButton
import com.slapps.cupertino.adaptive.AdaptiveNavigationBar
import com.slapps.cupertino.adaptive.AdaptiveNavigationBarItem
import com.slapps.cupertino.adaptive.AdaptiveScaffold
import com.slapps.cupertino.adaptive.AdaptiveSlider
import com.slapps.cupertino.adaptive.AdaptiveSwitch
import com.slapps.cupertino.adaptive.AdaptiveTextButton
import com.slapps.cupertino.adaptive.AdaptiveTopAppBar
import com.slapps.cupertino.adaptive.AdaptiveTriStateCheckbox
import com.slapps.cupertino.adaptive.AdaptiveWidget
import com.slapps.cupertino.adaptive.ExperimentalAdaptiveApi
import com.slapps.cupertino.adaptive.icons.AccountCircle
import com.slapps.cupertino.adaptive.icons.AdaptiveIcons
import com.slapps.cupertino.adaptive.icons.Add
import com.slapps.cupertino.adaptive.icons.Create
import com.slapps.cupertino.adaptive.icons.Delete
import com.slapps.cupertino.adaptive.icons.Menu
import com.slapps.cupertino.adaptive.icons.Person
import com.slapps.cupertino.adaptive.icons.Search
import com.slapps.cupertino.adaptive.icons.Settings
import com.slapps.cupertino.adaptive.icons.Share
import com.slapps.cupertino.adaptive.icons.ThumbUp
import com.slapps.cupertino.cancel
import com.slapps.cupertino.default
import com.slapps.cupertino.rememberCupertinoDatePickerState

@OptIn(
    ExperimentalAdaptiveApi::class,
    ExperimentalLayoutApi::class,
    ExperimentalCupertinoApi::class,
)
@Composable
fun AdaptiveWidgetsScreen(component: AdaptiveWidgetsComponent) {
    AdaptiveScaffold(
        topBar = {
            AdaptiveTopAppBar(
                navigationIcon = {
                    AdaptiveWidget(
                        cupertino = {
                            CupertinoNavigateBackButton(
                                onClick = component::onNavigateBack,
                            ) {
                                CupertinoText("Back")
                            }
                        },
                        material = {
                            IconButton(
                                onClick = component::onNavigateBack,
                            ) {
                                Icon(
                                    imageVector =
                                        if (LocalLayoutDirection.current == LayoutDirection.Ltr) {
                                            Icons.AutoMirrored.Default.ArrowBack
                                        } else {
                                            Icons.AutoMirrored.Default.ArrowForward
                                        },
                                    contentDescription = "Back",
                                )
                            }
                        },
                    )
                },
                title = {
                    Text("Adaptive")
                },
                actions = {
                    Text("Theme")
                    AdaptiveSwitch(
                        modifier = Modifier.padding(horizontal = 6.dp),
                        checked = component.isMaterial.value,
                        onCheckedChange = {
                            component.onThemeChanged()
                        },
                    )
                },
            )
        },
        bottomBar = {
            AdaptiveNavigationBar {
                var selected by rememberSaveable {
                    mutableStateOf(0)
                }

                val content =
                    listOf(
                        "Profile" to AdaptiveIcons.Outlined.Person,
                        "Menu" to AdaptiveIcons.Outlined.Menu,
                        "Settings" to AdaptiveIcons.Outlined.Settings,
                    )

                content.forEachIndexed { index, pair ->
                    AdaptiveNavigationBarItem(
                        selected = selected == index,
                        onClick = {
                            selected = index
                        },
                        icon = {
                            Icon(
                                imageVector = pair.second,
                                contentDescription = pair.first,
                            )
                        },
                        label = {
                            Text(pair.first)
                        },
                    )
                }
            }
        },
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding =
                PaddingValues(
                    start = 12.dp,
                    end = 12.dp,
                    top = it.calculateTopPadding() + 12.dp,
                    bottom = it.calculateBottomPadding(),
                ),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            item {
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    adaptiveIcons().forEach {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            imageVector = it,
                            contentDescription = it.name,
                        )
                    }
                }
            }

            item {
                var checked by remember { mutableStateOf(false) }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    AdaptiveSwitch(
                        checked = checked,
                        onCheckedChange = {
                            checked = it
                        },
                    )
                    AdaptiveSwitch(
                        checked = !checked,
                        onCheckedChange = {
                            checked = !it
                        },
                    )

                    AdaptiveCircularProgressIndicator()
                }
            }

            item {
                var v by remember {
                    mutableStateOf(.5f)
                }

                AdaptiveSlider(v, { v = it })
            }

            item {
                var v by remember {
                    mutableStateOf(.5f)
                }

                AdaptiveSlider(v, { v = it }, steps = 5)
            }

            item {
                var alertVisible by remember {
                    mutableStateOf(false)
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    AdaptiveButton(
                        onClick = {
                            alertVisible = true
                        },
                    ) {
                        Text("Alert")
                    }
                    AdaptiveTextButton(onClick = {}) {
                        Text("Text Button")
                    }

                    AdaptiveIconButton(onClick = {}) {
                        Icon(
                            imageVector = AdaptiveIcons.Outlined.Delete,
                            contentDescription = null,
                        )
                    }
                    AdaptiveFilledIconButton(onClick = {}) {
                        Icon(
                            imageVector = AdaptiveIcons.Outlined.Delete,
                            contentDescription = null,
                        )
                    }
                }

                if (alertVisible) {
                    AdaptiveAlertDialog(
                        onDismissRequest = {
                            alertVisible = false
                        },
                        title = {
                            Text("Alert")
                        },
                        message = {
                            Text("Adaptive Alert Dialog")
                        },
                    ) {
                        cancel(onClick = {
                            alertVisible = false
                        }) {
                            Text("Cancel")
                        }
                        default(onClick = {
                            alertVisible = false
                        }) {
                            Text("OK")
                        }
                    }
                }
            }

            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    var a by remember { mutableStateOf(true) }
                    var b by remember { mutableStateOf(false) }
                    var c by remember { mutableStateOf(ToggleableState.Indeterminate) }

                    AdaptiveCheckbox(checked = a, onCheckedChange = { a = it })
                    AdaptiveCheckbox(checked = b, onCheckedChange = { b = it })
                    AdaptiveTriStateCheckbox(state = c, onClick = {
                        c =
                            when (c) {
                                ToggleableState.On -> ToggleableState.Off
                                ToggleableState.Off -> ToggleableState.Indeterminate
                                ToggleableState.Indeterminate -> ToggleableState.On
                            }
                    })
                }
            }

            item {
                AdaptiveDatePicker(
                    state = rememberCupertinoDatePickerState(),
                    modifier = Modifier.fillMaxWidth(),
                    adaptation = {
                        material {
                            headline = null
                            showModeToggle = false
                            title = null
                        }
                    },
                )
            }
        }
    }
}

@Composable
private fun adaptiveIcons() =
    listOf(
        AdaptiveIcons.Outlined.Add,
        AdaptiveIcons.Outlined.Create,
        AdaptiveIcons.Outlined.Share,
        AdaptiveIcons.Outlined.Settings,
        AdaptiveIcons.Outlined.Person,
        AdaptiveIcons.Outlined.AccountCircle,
        AdaptiveIcons.Outlined.Delete,
        AdaptiveIcons.Outlined.ThumbUp,
        AdaptiveIcons.Outlined.Search,
    )

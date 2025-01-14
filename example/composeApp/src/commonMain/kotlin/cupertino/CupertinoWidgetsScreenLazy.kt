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

package cupertino///*
// * Copyright (c) 2023-2024. Compose Cupertino project and open source contributors.
// *
// *  Licensed under the Apache License, Version 2.0 (the "License");
// *  you may not use this file except in compliance with the License.
// *  You may obtain a copy of the License at
// *
// *      http://www.apache.org/licenses/LICENSE-2.0
// *
// *  Unless required by applicable law or agreed to in writing, software
// *  distributed under the License is distributed on an "AS IS" BASIS,
// *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// *  See the License for the specific language governing permissions and
// *  limitations under the License.
// *
// */
//
//@file:OptIn(ExperimentalCupertinoApi::class, ExperimentalLayoutApi::class,
//    ExperimentalStdlibApi::class
//)
///*
// * Copyright (c) 2023 Compose Cupertino project and open source contributors.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package cupertino
//
//import IsIos
//import RootComponent
//import androidx.compose.animation.AnimatedContent
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.gestures.ScrollableState
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.ExperimentalLayoutApi
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.calculateEndPadding
//import androidx.compose.foundation.layout.calculateStartPadding
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.imePadding
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.LazyListScope
//import androidx.compose.foundation.lazy.LazyListState
//import androidx.compose.foundation.lazy.rememberLazyListState
//import androidx.compose.material3.Icon
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.MutableState
//import androidx.compose.runtime.derivedStateOf
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.input.nestedscroll.nestedScroll
//import androidx.compose.ui.platform.LocalDensity
//import androidx.compose.ui.platform.LocalFocusManager
//import androidx.compose.ui.platform.LocalLayoutDirection
//import androidx.compose.ui.state.ToggleableState
//import androidx.compose.ui.unit.dp
//import com.slapps.cupertino.CupertinoActionSheet
//import com.slapps.cupertino.CupertinoActionSheetNative
//import com.slapps.cupertino.CupertinoActivityIndicator
//import com.slapps.cupertino.CupertinoAlertDialog
//import com.slapps.cupertino.CupertinoAlertDialogNative
//import com.slapps.cupertino.CupertinoBottomSheetContent
//import com.slapps.cupertino.CupertinoBottomSheetScaffold
//import com.slapps.cupertino.CupertinoBottomSheetScaffoldDefaults
//import com.slapps.cupertino.CupertinoButton
//import com.slapps.cupertino.CupertinoButtonDefaults
//import com.slapps.cupertino.CupertinoButtonSize
//import com.slapps.cupertino.CupertinoDatePicker
//import com.slapps.cupertino.CupertinoDatePickerNative
//import com.slapps.cupertino.CupertinoDatePickerState
//import com.slapps.cupertino.CupertinoDateTimePicker
//import com.slapps.cupertino.CupertinoDateTimePickerNative
//import com.slapps.cupertino.CupertinoDateTimePickerState
//import com.slapps.cupertino.CupertinoDropdownMenu
//import com.slapps.cupertino.CupertinoIcon
//import com.slapps.cupertino.CupertinoIconButton
//import com.slapps.cupertino.CupertinoIconDefaults
//import com.slapps.cupertino.MenuAction
//import com.slapps.cupertino.CupertinoNavigationBar
//import com.slapps.cupertino.CupertinoNavigationBarItem
//import com.slapps.cupertino.CupertinoWheelPicker
//import com.slapps.cupertino.CupertinoPickerState
//import com.slapps.cupertino.CupertinoSearchTextField
//import com.slapps.cupertino.CupertinoSearchTextFieldDefaults
//import com.slapps.cupertino.CupertinoSegmentedControl
//import com.slapps.cupertino.CupertinoSegmentedControlTab
//import com.slapps.cupertino.CupertinoSheetValue
//import com.slapps.cupertino.CupertinoSlider
//import com.slapps.cupertino.CupertinoSwitch
//import com.slapps.cupertino.CupertinoText
//import com.slapps.cupertino.CupertinoTimePicker
//import com.slapps.cupertino.CupertinoTimePickerNative
//import com.slapps.cupertino.CupertinoTimePickerState
//import com.slapps.cupertino.CupertinoTopAppBar
//import com.slapps.cupertino.MenuSection
//import com.slapps.cupertino.CupertinoBorderedTextField
//import com.slapps.cupertino.CupertinoBorderedTextFieldDefaults
//import com.slapps.cupertino.CupertinoBottomSheetScaffoldState
//import com.slapps.cupertino.CupertinoCheckBox
//import com.slapps.cupertino.CupertinoNavigationTitle
//import com.slapps.cupertino.CupertinoSwipeBox
//import com.slapps.cupertino.CupertinoSwipeBoxItem
//import com.slapps.cupertino.CupertinoSwipeBoxValue
//import com.slapps.cupertino.CupertinoTextField
//import com.slapps.cupertino.CupertinoTriStateCheckBox
//import com.slapps.cupertino.ExperimentalCupertinoApi
//import com.slapps.cupertino.LocalContainerColor
//import com.slapps.cupertino.PresentationDetent
//import com.slapps.cupertino.PresentationStyle
//import com.slapps.cupertino.SwipeBoxBehavior
//import com.slapps.cupertino.adaptive.icons.AdaptiveIcons
//import com.slapps.cupertino.adaptive.icons.Add
//import com.slapps.cupertino.adaptive.icons.Settings
//import com.slapps.cupertino.adaptive.icons.Share
//import com.slapps.cupertino.cancel
//import com.slapps.cupertino.default
//import com.slapps.cupertino.destructive
//import com.slapps.cupertino.icons.CupertinoIcons
//import com.slapps.cupertino.icons.outlined.*
//import com.slapps.cupertino.icons.filled.*
//import com.slapps.cupertino.isNavigationBarTransparent
//import com.slapps.cupertino.isTopBarTransparent
//import com.slapps.cupertino.isTowardsEnd
//import com.slapps.cupertino.isTowardsStart
//import com.slapps.cupertino.rememberCupertinoBottomSheetScaffoldState
//import com.slapps.cupertino.rememberCupertinoDatePickerState
//import com.slapps.cupertino.rememberCupertinoDateTimePickerState
//import com.slapps.cupertino.rememberCupertinoPickerState
//import com.slapps.cupertino.rememberCupertinoSearchTextFieldState
//import com.slapps.cupertino.rememberCupertinoSheetState
//import com.slapps.cupertino.rememberCupertinoSwipeBoxState
//import com.slapps.cupertino.rememberCupertinoTimePickerState
//import com.slapps.cupertino.section.CupertinoLinkIcon
//import com.slapps.cupertino.section.ProvideSectionStyle
//import com.slapps.cupertino.section.LazySectionScope
//import com.slapps.cupertino.section.SectionScope
//import com.slapps.cupertino.section.SectionState
//import com.slapps.cupertino.section.SectionStyle
//import com.slapps.cupertino.section.link
//import com.slapps.cupertino.section.rememberSectionState
//import com.slapps.cupertino.section.section
//import com.slapps.cupertino.section.sectionContainerBackground
//import com.slapps.cupertino.section.sectionTitle
//import com.slapps.cupertino.section.switch
//import com.slapps.cupertino.theme.CupertinoColors
//import com.slapps.cupertino.theme.CupertinoTheme
//import com.slapps.cupertino.theme.systemBlue
//import com.slapps.cupertino.theme.systemCyan
//import com.slapps.cupertino.theme.systemGray
//import com.slapps.cupertino.theme.systemGreen
//import com.slapps.cupertino.theme.systemIndigo
//import com.slapps.cupertino.theme.systemOrange
//import com.slapps.cupertino.theme.systemPurple
//import com.slapps.cupertino.theme.systemRed
//import kotlinx.coroutines.launch
//import kotlinx.datetime.Instant
//import kotlinx.datetime.TimeZone
//import kotlinx.datetime.toLocalDateTime
//import kotlin.reflect.KClass
//
//private enum class PickerTab {
//    Picker, Time, Date, DateTime
//}
//
//@OptIn(ExperimentalCupertinoApi::class)
//@Composable
//fun CupertinoWidgetsScreen(
//    component: CupertinoWidgetsComponent
//) {
//
//    val lazyListState = rememberLazyListState()
//    val sheetListState = rememberLazyListState()
//
//    val scaffoldState = rememberCupertinoBottomSheetScaffoldState(
//        rememberCupertinoSheetState(
//            presentationStyle = PresentationStyle.Modal(
//                detents = setOf(
//                    PresentationDetent.Large,
//                    PresentationDetent.Fraction(.6f),
//                ),
//            )
////            presentationStyle = PresentationStyle.Fullscreen
//        )
//    )
//
//    val sheetSectionColor = CupertinoTheme.colorScheme.tertiarySystemBackground
//
//    val focusManager = LocalFocusManager.current
//
//    val nativePickers = remember {
//        mutableStateOf(false)
//    }
//
//    LaunchedEffect(lazyListState.isScrollInProgress){
//        if (lazyListState.isScrollInProgress){
//            focusManager.clearFocus(force = true)
//        }
//    }
//
//    LaunchedEffect(scaffoldState.bottomSheetState.targetValue){
//        if (scaffoldState.bottomSheetState.targetValue == CupertinoSheetValue.Hidden){
//            focusManager.clearFocus(force = true)
//        }
//    }
//
//    CupertinoBottomSheetScaffold(
//        hasNavigationTitle = true,
//        colors = CupertinoBottomSheetScaffoldDefaults.colors(
//            sheetContainerColor = CupertinoTheme.colorScheme
//                .secondarySystemBackground,
//        ),
//        sheetContent = {
//           SheetSample(
//               scaffoldState = scaffoldState,
//               sheetListState = sheetListState,
//               sheetSectionColor = sheetSectionColor
//           )
//        },
//        scaffoldState = scaffoldState,
//        topBar = {
//            TopBarSample(
//                lazyListState = lazyListState,
//                nativePickers = nativePickers.value,
//                component = component
//            )
//        },
//        bottomBar = {
//           BottomBarSample(
//               lazyListState = lazyListState,
//               nativePickers = nativePickers.value
//           )
//        }
//    ) { pv ->
//        Body(
//            paddingValues = pv,
//            lazyListState = lazyListState,
//            component = component,
//            scaffoldState = scaffoldState,
//            nativePickers = nativePickers
//        )
//    }
//}
//
//@Composable
//private fun Body(
//    paddingValues: PaddingValues,
//    lazyListState: LazyListState,
//    component: CupertinoWidgetsComponent,
//    scaffoldState: CupertinoBottomSheetScaffoldState,
//    nativePickers : MutableState<Boolean>
//) {
//
//    val coroutineScope = rememberCoroutineScope()
//
//    val pickerValues = remember {
//        listOf(
//            "January", "February",
//            "March", "April",
//            "May", "June", "July", "August", "September",
//            "October", "November", "December"
//        )
//    }
//
//    val pickerState = rememberCupertinoPickerState()
//    val timePickerState = rememberCupertinoTimePickerState()
//    val datePickerState = rememberCupertinoDatePickerState()
//    val dateTimePickerState = rememberCupertinoDateTimePickerState()
//
//    var selectedPickerTab by remember {
//        mutableStateOf(PickerTab.Picker)
//    }
//
//    val searchState = rememberCupertinoSearchTextFieldState(
//        scrollableState = lazyListState,
//        blockScrollWhenFocusedAndEmpty = true
//    )
//
//    val buttonsSectionState = rememberSectionState()
//    val navSectionState = rememberSectionState()
//    val popupsSectionState = rememberSectionState()
//    val wheelPickersSectionState = rememberSectionState()
//
//    ProvideSectionStyle(
//        SectionStyle.Sidebar
//    ) {
//        LazyColumn(
//            state = lazyListState,
//            contentPadding = paddingValues + PaddingValues(top = 10.dp),
//            modifier = Modifier
//                .fillMaxSize()
//                .sectionContainerBackground()
//                .nestedScroll(searchState.nestedScrollConnection)
//        ) {
//
//            item {
//                CupertinoNavigationTitle {
//                    Text("Cupertino")
//                }
//            }
//            item {
//                var value by remember {
//                    mutableStateOf("")
//                }
//                CupertinoSearchTextField(
//                    value = value,
//                    onValueChange = {
//                        value = it
//                    },
//                    state = searchState,
//                    paddingValues = CupertinoSearchTextFieldDefaults.PaddingValues +
//                            PaddingValues(bottom = 12.dp)
//                )
//            }
//
//            section {
//                switch(
//                    checked = component.isInvertLayoutDirection.value,
//                    onCheckedChange = component::onInvertLayoutDirection
//                ) {
//                    Text("Toggle layout direction")
//                }
//
//                colorButtons(onColorsChanged = component::onAccentColorChanged)
//            }
//
//            linksWithIcons(
//                state = navSectionState,
//                onSheetClicked = {
//                    coroutineScope.launch {
//                        scaffoldState.bottomSheetState.show()
//                    }
//                },
//                onNavigate = component::onNavigate
//            )
//
//            section {
//                swipeBox(lazyListState)
//                swipeBox(lazyListState)
//            }
//
//            section(
//                state = buttonsSectionState,
//                title = {
//                    CupertinoText(
//                        text = "Controls".sectionTitle(),
//                    )
//                }
//            ) {
//                buttons()
//                switchAndProgressBar()
//            }
////
//
//            section(
//                state = popupsSectionState,
//                title = {
//                    CupertinoText(
//                        text = "Popups".sectionTitle(),
//                    )
//                },
//                caption = {
//                    CupertinoText(
//                        text = "Native dialogs will use UIAlertController on iOS and Compose Cupertino analogs on other platforms",
//                    )
//                }
//            ) {
//                dialogs()
//                sheets()
//                dropdown()
//            }
//
//            section(
//                state = wheelPickersSectionState,
//                title = {
//                    CupertinoText(
//                        text = "Wheel Pickers".sectionTitle()
//                    )
//                },
//                caption = {
//                    CupertinoText(
//                        text = when (selectedPickerTab) {
//                            PickerTab.Picker ->
//                                "Selected: ${
//                                    pickerValues[pickerState.selectedItemIndex(
//                                        pickerValues.size
//                                    )]
//                                }"
//
//                            PickerTab.Time -> "${timePickerState.hour} : ${timePickerState.minute}"
//                            PickerTab.Date -> remember {
//                                derivedStateOf {
//                                    Instant
//                                        .fromEpochMilliseconds(datePickerState.selectedDateMillis)
//                                        .toLocalDateTime(TimeZone.UTC)
//                                        .toString()
//                                }
//                            }.value
//
//                            PickerTab.DateTime -> remember {
//                                derivedStateOf {
//                                    Instant
//                                        .fromEpochMilliseconds(dateTimePickerState.selectedDateTimeMillis)
//                                        .toLocalDateTime(TimeZone.UTC)
//                                        .toString()
//                                }
//                            }.value
//                        }
//                    )
//                }
//            ) {
//                item {
//                    CupertinoSegmentedControl(
//                        selectedTabIndex = PickerTab.entries.indexOf(selectedPickerTab),
//                    ) {
//                        val tabs = PickerTab.entries
//
//                        tabs.forEach { s ->
//                            CupertinoSegmentedControlTab(
//                                isSelected = s == selectedPickerTab,
//                                onClick = {
//                                    selectedPickerTab = s
//                                }
//                            ) {
//                                CupertinoText(s.name)
//                            }
//                        }
//                    }
//                }
//
//                switch(
//                    checked = nativePickers.value,
//                    onCheckedChange = {
//                        nativePickers.value = it
//                    }
//                ) {
//                    Text("Native")
//                }
//                when (selectedPickerTab) {
//                    PickerTab.Picker -> picker(pickerValues, pickerState)
//                    PickerTab.Time -> timePicker(timePickerState, nativePickers.value)
//                    PickerTab.Date -> datePicker(datePickerState, nativePickers.value)
//                    PickerTab.DateTime -> dateTimePicker(dateTimePickerState, nativePickers.value)
//                }
//
//            }
//            item {
//                Spacer(Modifier.imePadding())
//            }
//        }
//    }
//}
//
//@OptIn(ExperimentalCupertinoApi::class)
//private fun LazySectionScope.swipeBox(scrollableState: ScrollableState) {
//    item {
//        val state = rememberCupertinoSwipeBoxState(
//            collapseOnScroll = scrollableState
//        )
//
//        val scope = rememberCoroutineScope()
//
//        CupertinoSwipeBox(
//            modifier = Modifier
//                .fillMaxWidth(),
//            state = state,
//            startToEndBehavior = SwipeBoxBehavior.Expandable,
//            items = {
//                when {
//                    state.dismissDirection.isTowardsStart -> {
//                        CupertinoSwipeBoxItem(
//                            onClick = {
//                                scope.launch {
//                                    if (state.currentValue == CupertinoSwipeBoxValue.DismissedToStart) {
//                                        state.reset()
//                                    } else {
//                                        state.animateTo(CupertinoSwipeBoxValue.DismissedToStart)
//                                    }
//                                }
//                            },
//                            color = CupertinoColors.systemRed,
//                            icon = {
//                                Icon(
//                                    imageVector = CupertinoIcons.Filled.Trash,
//                                    contentDescription = "Delete"
//                                )
//                            },
//                            label = {
//                                Text("Delete")
//                            }
//                        )
//                        CupertinoSwipeBoxItem(
//                            onClick = {
//                                scope.launch { state.reset() }
//                            },
//                            color = CupertinoColors.systemOrange,
//                            icon = {
//                                Icon(
//                                    imageVector = CupertinoIcons.Filled.SpeakerSlash,
//                                    contentDescription = "Mute"
//                                )
//                            },
//                            label = {
//                                Text("Mute")
//                            }
//                        )
//                    }
//
//                    state.dismissDirection.isTowardsEnd -> {
//                        CupertinoSwipeBoxItem(
//                            onClick = {
//                                scope.launch { state.reset() }
//                            },
//                            color = CupertinoColors.systemGray,
//                            icon = {
//                                Icon(
//                                    imageVector = CupertinoIcons.Filled.BubbleLeft,
//                                    contentDescription = "Unread"
//                                )
//                            },
//                            label = {
//                                Text("Unread")
//                            }
//                        )
//                        CupertinoSwipeBoxItem(
//                            onClick = {
//                                scope.launch { state.reset() }
//                            },
//                            color = CupertinoColors.systemGreen,
//                            icon = {
//                                Icon(
//                                    imageVector = CupertinoIcons.Filled.Pin,
//                                    contentDescription = "Pin"
//                                )
//                            },
//                            label = {
//                                Text("Pin")
//
//                            }
//                        )
//                    }
//
//                    else -> {
//                        // Empty content on collapsed state to avoid clipping artifacts
//                    }
//                }
//            }
//        ) {
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .height(72.dp)
//                    .background(LocalContainerColor.current)
//                    .clickable {}
//            ) {
//                Text(
//                    modifier = Modifier
//                        .padding(it)
//                        .align(Alignment.CenterStart),
//                    text = "Swipe horizontally"
//                )
//            }
//        }
//    }
//}
//
//@Composable
//private fun TopBarSample(
//    lazyListState : LazyListState,
//    nativePickers : Boolean,
//    component : CupertinoWidgetsComponent
//) {
//    val density = LocalDensity.current
//
//    val isTransparent by remember(lazyListState, density) {
//        derivedStateOf {
//            // top bar is collapsing only on mobile
//            if (IsIos) {
//
//                val isFirst = lazyListState.firstVisibleItemIndex < 2
//
//                val isSecondWithPadding = lazyListState.firstVisibleItemIndex == 2 &&
//                        lazyListState.firstVisibleItemScrollOffset < density.run { 20.dp.toPx() }
//
//                isFirst || isSecondWithPadding
//            } else {
//                !lazyListState.canScrollBackward
//            }
//
//        }
//    }
//
//    CupertinoTopAppBar(
//        // Currently UIKitView doesn't work inside a container with translucent app bars
//        isTranslucent = isTransparent || !(IsIos && nativePickers),
//        isTransparent = isTransparent,
//        actions = {
//            CupertinoIconButton(
//                onClick = component::onThemeClicked
//            ) {
//                AnimatedContent(component.isDark.value) {
//                    if (it) {
//                        CupertinoIcon(
//                            imageVector = CupertinoIcons.Default.SunMax,
//                            contentDescription = null
//                        )
//                    } else {
//                        CupertinoIcon(
//                            imageVector = CupertinoIcons.Default.MoonStars,
//                            contentDescription = null
//                        )
//                    }
//                }
//            }
//        },
//        title = {
//            CupertinoText("Cupertino")
//        }
//    )
//}
//
//@Composable
//private fun BottomBarSample(
//    lazyListState : LazyListState,
//    nativePickers: Boolean
//) {
//    var tab by remember {
//        mutableStateOf(0)
//    }
//
//    val isTransparent = lazyListState.isNavigationBarTransparent
//
//    CupertinoNavigationBar(
//        // Currently UIKitView doesn't work inside a container with translucent app bars
//        isTranslucent = isTransparent || !(IsIos && nativePickers),
//        isTransparent = isTransparent,
//    ) {
//        CupertinoNavigationBarItem(
//            selected = tab == 0,
//            onClick = { tab = 0 },
//            icon = {
//                CupertinoIcon(
//                    imageVector = CupertinoIcons.Filled.Person,
//                    contentDescription = null
//                )
//            },
//            label = {
//                CupertinoText("Profile")
//            }
//        )
//        CupertinoNavigationBarItem(
//            selected = tab == 1,
//            onClick = { tab = 1 },
//            icon = {
//                CupertinoIcon(
//                    imageVector = CupertinoIcons.Filled.Gearshape,
//                    contentDescription = null
//                )
//            },
//            label = {
//                CupertinoText("Settings")
//            }
//        )
//    }
//}
//
//@Composable
//private fun SheetSample(
//    scaffoldState : CupertinoBottomSheetScaffoldState,
//    sheetListState : LazyListState,
//    sheetSectionColor : Color
//) {
//
//    val coroutineScope = rememberCoroutineScope()
//
//    CupertinoBottomSheetContent(
//        topBar = {
//            CupertinoTopAppBar(
//                title = {
//                    CupertinoText("Bottom Sheet")
//                },
//                actions = {
//                    CupertinoButton(
//                        colors = CupertinoButtonDefaults.borderlessButtonColors(),
//                        onClick = {
//                            coroutineScope.launch {
//                                scaffoldState.bottomSheetState.hide()
//                            }
//                        }
//                    ){
//                        CupertinoText("Done")
//                    }
//                },
//                isTransparent = sheetListState.isTopBarTransparent
//            )
//        }
//    ) { pv ->
//        LazyColumn(
//            modifier = Modifier.fillMaxSize(),
//            state = sheetListState,
//            contentPadding = pv ,
//        ) {
//
//            section(
//                color = sheetSectionColor
//            ) {
//                repeat(100) {
//                    link(onClick = {}){
//                        CupertinoText("Item $it")
//                    }
//                }
//            }
//            item {
//                Spacer(Modifier.imePadding())
//            }
//        }
//    }
//}
//
//@Composable
//private operator fun PaddingValues.plus(other : PaddingValues) : PaddingValues{
//    val layoutDirection = LocalLayoutDirection.current
//
//    return PaddingValues(
//        top = calculateTopPadding() + other.calculateTopPadding(),
//        bottom = calculateBottomPadding() + other.calculateBottomPadding(),
//        start = calculateStartPadding(layoutDirection) + other.calculateStartPadding(layoutDirection),
//        end = calculateEndPadding(layoutDirection) + other.calculateEndPadding(layoutDirection)
//    )
//}
//
//@OptIn(ExperimentalCupertinoApi::class)
//fun LazySectionScope.picker(
//    pickerValues: List<String>,
//    pickerState: CupertinoPickerState
//) {
//
//    item {
//        CupertinoWheelPicker(
//            state = pickerState,
//            items = pickerValues,
//            modifier = Modifier.fillMaxWidth(),
//            containerColor = CupertinoTheme.colorScheme.secondarySystemGroupedBackground
//        ) {
//            CupertinoText(it)
//        }
//    }
//}
//
//fun LazySectionScope.timePicker(
//    state : CupertinoTimePickerState, native : Boolean
//) {
//    item {
//        if (native) {
//            CupertinoTimePickerNative(
//                modifier = Modifier.fillMaxWidth(),
//                state = state
//            )
//        } else {
//            CupertinoTimePicker(
//                modifier = Modifier.fillMaxWidth(),
//                state = state
//            )
//        }
//    }
//}
//
//fun LazySectionScope.datePicker(
//    state: CupertinoDatePickerState, native: Boolean
//) {
//    item {
//        if (native) {
//            CupertinoDatePickerNative(
//                state = state,
//                modifier = Modifier.fillMaxWidth(),
//            )
//        } else {
//            CupertinoDatePicker(
//                modifier = Modifier.fillMaxWidth(),
//                state = state,
//            )
//        }
//    }
//}
//
//
//@OptIn(ExperimentalCupertinoApi::class)
//fun LazySectionScope.dateTimePicker(
//    state : CupertinoDateTimePickerState, native: Boolean
//) {
//
//    item {
//        if (native) {
//            CupertinoDateTimePickerNative(
//                state = state,
//                modifier = Modifier.fillMaxWidth()
//            )
//        } else {
//            CupertinoDateTimePicker(
//                modifier = Modifier.fillMaxWidth(),
//                state = state
//            )
//        }
//    }
//}
//
//
//
//private fun LazySectionScope.switchAndProgressBar() {
//    item { pv ->
//        Row(
//            modifier = Modifier.padding(pv),
//            horizontalArrangement = Arrangement.spacedBy(12.dp)
//        ) {
//            var active1 by remember {
//                mutableStateOf(true)
//            }
//
//            var active2 by remember {
//                mutableStateOf(false)
//            }
//            CupertinoSwitch(
//                checked = active1,
//                onCheckedChange = {
//                    active1 = it
//                }
//            )
//            CupertinoSwitch(
//                checked = active2,
//                onCheckedChange = {
//                    active2 = it
//                }
//            )
//            CupertinoSwitch(
//                checked = true,
//                enabled = false,
//                onCheckedChange = {}
//            )
//            CupertinoSwitch(
//                checked = false,
//                enabled = false,
//                onCheckedChange = {}
//            )
//
//            CupertinoActivityIndicator()
//        }
//    }
//
//    item { pv ->
//        Row(
//            modifier = Modifier.padding(pv),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.spacedBy(12.dp)
//        ) {
//            var b by remember {
//                mutableStateOf(.5f)
//            }
//            CupertinoSlider(
//                modifier = Modifier.weight(1f),
//                value = b,
//                onValueChange = {
//                    b = it
//                }
//            )
//
//            CupertinoActivityIndicator(
//                progress = b
//            )
////            Text(
////                text = b.toString().take(4),
////                modifier = Modifier.width(40.dp),
////                maxLines = 1
////            )
//        }
//    }
//
//    item { pv ->
//        Row(
//            modifier = Modifier.padding(pv),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.spacedBy(12.dp)
//        ) {
//            var b by remember {
//                mutableStateOf(.5f)
//            }
//            CupertinoSlider(
//                modifier = Modifier.weight(1f),
//                value = b,
//                steps = 5,
//                onValueChange = {
//                    b = it
//                }
//            )
//
//            Text(
//                text = b.toString().take(4),
//                modifier = Modifier.width(40.dp),
//                maxLines = 1
//            )
//        }
//    }
//
//    item {
//        var v by remember {
//            mutableStateOf("")
//        }
//
//        CupertinoTextField(
//            value = v,
//            onValueChange = {
//                v = it
//            },
//            placeholder = {
//                CupertinoText("Text field...")
//            },
//            modifier = Modifier.padding(it)
//        )
//    }
//
//
//    item {
//        var v by remember {
//            mutableStateOf("")
//        }
//
//        CupertinoBorderedTextField(
//            modifier = Modifier.padding(it),
//            value = v,
//            onValueChange = {
//                v = it
//            },
//            placeholder = {
//                CupertinoText("Text field...")
//            },
//            contentAlignment = Alignment.Bottom,
//            colors = CupertinoBorderedTextFieldDefaults.colors(
//                focusedContainerColor = CupertinoTheme.colorScheme.systemBackground
//            ),
//            shape = CupertinoTheme.shapes.large,
//            leadingIcon = {
//                  CupertinoIcon(
//                      modifier = Modifier.height(CupertinoIconDefaults.MediumSize),
//                      imageVector = CupertinoIcons.Outlined.FaceSmiling,
//                      contentDescription = null
//                  )
//            },
//            trailingIcon = {
//                CupertinoIcon(
//                    modifier = Modifier.height(CupertinoIconDefaults.MediumSize),
//                    imageVector = CupertinoIcons.Outlined.Paperclip,
//                    contentDescription = null
//                )
//            },
//        )
//    }
//}
//
//private fun LazySectionScope.colorButtons(
//    onColorsChanged : (light : Color, dark : Color) -> Unit
//) {
//
//
//    item {
//        Row(
//            modifier = Modifier.padding(it),
//            horizontalArrangement = Arrangement.spacedBy(12.dp)
//        ) {
//            CupertinoIconButton(
//                onClick = {
//                    onColorsChanged(
//                        CupertinoColors.systemBlue(false),
//                        CupertinoColors.systemBlue(true)
//                    )
//                },
//                colors = CupertinoButtonDefaults.borderedButtonColors(
//                    contentColor = CupertinoColors.systemBlue
//                )
//            ) {
//                CupertinoIcon(
//                    imageVector = CupertinoIcons.Default.Paintpalette,
//                    contentDescription = null
//                )
//            }
//            CupertinoIconButton(
//                onClick = {
//                    onColorsChanged(
//                        CupertinoColors.systemGreen(false),
//                        CupertinoColors.systemGreen(true)
//                    )
//                },
//                colors = CupertinoButtonDefaults.borderedButtonColors(
//                    contentColor = CupertinoColors.systemGreen
//                )
//            ) {
//                CupertinoIcon(
//                    imageVector = CupertinoIcons.Default.Paintpalette,
//                    contentDescription = null
//                )
//            }
//            CupertinoIconButton(
//                onClick = {
//                    onColorsChanged(
//                        CupertinoColors.systemPurple(false),
//                        CupertinoColors.systemPurple(true)
//                    )
//                },
//                colors = CupertinoButtonDefaults.borderedButtonColors(
//                    contentColor = CupertinoColors.systemPurple
//                )
//            ) {
//                CupertinoIcon(
//                    imageVector = CupertinoIcons.Default.Paintpalette,
//                    contentDescription = null
//                )
//            }
//
//            CupertinoIconButton(
//                onClick = {
//                    onColorsChanged(
//                        CupertinoColors.systemOrange(false),
//                        CupertinoColors.systemOrange(true)
//                    )
//                },
//                colors = CupertinoButtonDefaults.borderedButtonColors(
//                    contentColor = CupertinoColors.systemOrange
//                )
//            ) {
//                CupertinoIcon(
//                    imageVector = CupertinoIcons.Default.Paintpalette,
//                    contentDescription = null
//                )
//            }
//            CupertinoIconButton(
//                onClick = {
//                    onColorsChanged(
//                        CupertinoColors.systemRed(false),
//                        CupertinoColors.systemRed(true)
//                    )
//                },
//                colors = CupertinoButtonDefaults.borderedButtonColors(
//                    contentColor = CupertinoColors.systemRed
//                )
//            ) {
//                CupertinoIcon(
//                    imageVector = CupertinoIcons.Default.Paintpalette,
//                    contentDescription = null
//                )
//            }
//        }
//    }
//}
//
//private fun LazySectionScope.buttons() {
//
//    item {
//        Row(
//            modifier = Modifier.padding(it),
//            horizontalArrangement = Arrangement.spacedBy(6.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//
//            var a by remember { mutableStateOf(true) }
//            var b by remember { mutableStateOf(false) }
//            var c by remember { mutableStateOf(ToggleableState.Indeterminate) }
//
//            CupertinoCheckBox(checked = a, onCheckedChange = { a = it })
//            CupertinoCheckBox(checked = b, onCheckedChange = { b = it })
//            CupertinoTriStateCheckBox(state = c, onClick = {
//                c = when (c){
//                    ToggleableState.On ->  ToggleableState.Off
//                    ToggleableState.Off -> ToggleableState.Indeterminate
//                    ToggleableState.Indeterminate -> ToggleableState.On
//                }
//            })
//            CupertinoIconButton(
//                onClick = {},
//            ) {
//                CupertinoIcon(
//                    imageVector = AdaptiveIcons.Outlined.Share,
//                    contentDescription = null
//                )
//            }
//            CupertinoIconButton(
//                onClick = {},
//                colors = CupertinoButtonDefaults.borderedButtonColors()
//            ) {
//                CupertinoIcon(
//                    imageVector = AdaptiveIcons.Outlined.Add,
//                    contentDescription = null
//                )
//            }
//            CupertinoIconButton(
//                onClick = {},
//                colors = CupertinoButtonDefaults.borderedGrayButtonColors()
//            ) {
//                CupertinoIcon(
//                    imageVector = AdaptiveIcons.Outlined.Settings,
//                    contentDescription = null
//                )
//            }
//            CupertinoIconButton(
//                onClick = {},
//                enabled = false,
//            ) {
//                CupertinoIcon(
//                    imageVector = AdaptiveIcons.Outlined.Add,
//                    contentDescription = null
//                )
//            }
//        }
//    }
//
//    item {
//        Row(
//            modifier = Modifier.padding(it),
//            horizontalArrangement = Arrangement.spacedBy(12.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//
//            CupertinoButton(
//                colors = CupertinoButtonDefaults.borderedGrayButtonColors(),
//                onClick = {},
//                size = CupertinoButtonSize.Small
//            ) {
//                CupertinoText("Gray S")
//            }
//
//            CupertinoButton(
//                colors = CupertinoButtonDefaults.borderedButtonColors(),
//                onClick = {},
//                size = CupertinoButtonSize.Regular
//            ) {
//                CupertinoText("Tinted M")
//            }
//
//            CupertinoButton(
//                colors = CupertinoButtonDefaults.borderedProminentButtonColors(),
//                onClick = {},
//                size = CupertinoButtonSize.Large
//            ) {
//                CupertinoText("Filled L")
//            }
//
//        }
//    }
//
//    item {
//        Row(
//            modifier = Modifier.padding(it),
//            horizontalArrangement = Arrangement.spacedBy(12.dp)
//        ) {
//            CupertinoButton(
//                colors = CupertinoButtonDefaults.borderlessButtonColors(),
//                onClick = {}
//            ) {
//                CupertinoText("Plain")
//            }
//            CupertinoButton(
//                colors = CupertinoButtonDefaults.borderlessButtonColors(),
//                onClick = {},
//                enabled = false
//            ) {
//                CupertinoText("Disabled")
//            }
//
//            CupertinoButton(
//                colors = CupertinoButtonDefaults.borderedProminentButtonColors(),
//                onClick = {},
//                enabled = false
//            ) {
//                CupertinoText("Disabled")
//            }
//        }
//    }
//
//}
//
//@OptIn(ExperimentalCupertinoApi::class)
//private fun LazySectionScope.dialogs(){
//    item {
//
//        var alertVisible by remember {
//            mutableStateOf(false)
//        }
//        var nativeAlertVisible by remember {
//            mutableStateOf(false)
//        }
//
//        if (alertVisible) {
//            CupertinoAlertDialog(
//                onDismissRequest = {
//                    alertVisible = false
//                },
//                title = {
//                    CupertinoText("Alert Dialog")
//                },
//                message = {
//                    CupertinoText("Alert dialog message")
//                }
//            ) {
//                destructive(
//                    onClick = {
//                        alertVisible = false
//                    }
//                ) {
//                    CupertinoText("Cancel")
//                }
//                default(
//                    onClick = {
//                        alertVisible = false
//                    }
//                ) {
//                    CupertinoText("OK")
//                }
//            }
//        }
//        if (nativeAlertVisible) {
//            CupertinoAlertDialogNative(
//                onDismissRequest = {
//                    nativeAlertVisible = false
//                },
//                title = "Alert Dialog",
//                message = "Alert dialog message"
//            ) {
//                destructive(
//                    onClick = {
//                        nativeAlertVisible = false
//                    },
//                    title = "Cancel"
//                )
//                default(
//                    onClick = {
//                        nativeAlertVisible = false
//                    },
//                    title = "OK"
//                )
//            }
//        }
//
//        Row(
//            modifier = Modifier.padding(it),
//            horizontalArrangement = Arrangement.spacedBy(12.dp)
//        ) {
//            CupertinoButton(
//                colors = CupertinoButtonDefaults.borderedButtonColors(),
//                onClick = {
//                    alertVisible = true
//                }
//            ) {
//                CupertinoText("Alert")
//            }
//            CupertinoButton(
//                colors = CupertinoButtonDefaults.borderedButtonColors(),
//                onClick = {
//                    nativeAlertVisible = true
//                }
//            ) {
//                CupertinoText("Native")
//            }
//        }
//    }
//}
//
//private fun LazySectionScope.sheets(){
//    item {
//
//        var sheetVisible by remember {
//            mutableStateOf(false)
//        }
//        var nativeSheetVisible by remember {
//            mutableStateOf(false)
//        }
//
//            CupertinoActionSheet(
//                visible = sheetVisible,
//                onDismissRequest = {
//                    sheetVisible = false
//                },
//                title = {
//                    CupertinoText("Action Sheet")
//                },
//                message = {
//                    CupertinoText("This is a message of the action sheet")
//                },
//            ) {
//                default(
//                    onClick = {
//                        sheetVisible = false
//                    }
//                ) {
//                    CupertinoText("OK")
//                }
//                destructive(
//                    onClick = {
//                        sheetVisible = false
//                    }
//                ) {
//                    CupertinoText("Delete")
//                }
//
//                cancel(
//                    onClick = {
//                        sheetVisible = false
//                    }
//                ) {
//                    CupertinoText("Cancel")
//                }
//            }
//            CupertinoActionSheetNative(
//                visible = nativeSheetVisible,
//                onDismissRequest = {
//                    nativeSheetVisible = false
//                },
//                title = "Action Sheet",
//                message = "This is a message of the action sheet"
//            ) {
//                default(
//                    onClick = {
//                        nativeSheetVisible = false
//                    },
//                    title = "OK"
//                )
//                destructive(
//                    onClick = {
//                        nativeSheetVisible = false
//                    },
//                    title = "Delete"
//                )
//
//                cancel(
//                    onClick = {
//                        nativeSheetVisible = false
//                    },
//                    title = "Cancel"
//                )
//            }
//
//        Row(
//            modifier = Modifier.padding(it),
//            horizontalArrangement = Arrangement.spacedBy(12.dp)
//        ) {
//            CupertinoButton(
//                colors = CupertinoButtonDefaults.borderedButtonColors(),
//                onClick = {
//                    sheetVisible = true
//                }
//            ) {
//                CupertinoText("Action Sheet")
//            }
//            CupertinoButton(
//                colors = CupertinoButtonDefaults.borderedButtonColors(),
//                onClick = {
//                    nativeSheetVisible = true
//                }
//            ) {
//                CupertinoText("Native")
//            }
//        }
//    }
//}
//
//
//private fun LazySectionScope.dropdown() {
//
//
//    item { pv ->
//
//        var dropdownVisible by remember {
//            mutableStateOf(false)
//        }
//
//        var pickerSheetVisible by remember {
//            mutableStateOf(false)
//        }
//        CupertinoActionSheet(
//            visible = pickerSheetVisible,
//            onDismissRequest = {
//                pickerSheetVisible = false
//            },
//            title = {
//                CupertinoText("Cupertino Picker Sheet")
//            },
//            message = {
//                CupertinoText("Pickers are the most used case for such sheets but you can place below any content you want")
//            },
//            buttons = {
//                default(
//                    onClick = {
//                        pickerSheetVisible = false
//                    },
//                ) {
//                    CupertinoText("Confirm")
//                }
//                cancel(
//                    onClick = {
//                        pickerSheetVisible = false
//                    },
//                ) {
//                    CupertinoText("Cancel")
//                }
//            },
//            content = {
//                CupertinoDatePicker(
//                    state = rememberCupertinoDatePickerState(),
//                    modifier = Modifier.fillMaxWidth(),
//                )
//            }
//        )
//
//
//        Row(
//            modifier = Modifier.padding(pv),
//            horizontalArrangement = Arrangement.spacedBy(12.dp)
//        ) {
//
//            CupertinoButton(
//                colors = CupertinoButtonDefaults.borderedButtonColors(),
//                onClick = {
//                    pickerSheetVisible = true
//                }
//            ) {
//                CupertinoText("Picker Sheet")
//            }
//
//            Spacer(Modifier.weight(1f))
//            //Menu bar should be in the box with anchor to align correctly
//            Box {
//                CupertinoButton(
//                    onClick = {
//                        dropdownVisible = !dropdownVisible
//                    }
//                ) {
//                    CupertinoText("Menu")
//                }
//
//
//                val red = CupertinoColors.systemRed
//
//                CupertinoDropdownMenu(
//                    expanded = dropdownVisible,
//                    onDismissRequest = {
//                        dropdownVisible = false
//                    }
//                ) {
//                    MenuSection(
//                        title = {
//                            Text("Menu")
//                        }
//                    ) {
//                        MenuAction(
//                            onClick = {
//                                dropdownVisible = false
//                            },
//                            icon = {
//                                CupertinoIcon(
//                                    imageVector = CupertinoIcons.Default.SquareAndArrowUp,
//                                    contentDescription = null
//                                )
//                            }
//                        ) {
//                            CupertinoText("Share")
//                        }
//                        MenuAction(
//                            enabled = false,
//                            onClick = {
//                                dropdownVisible = false
//                            },
//                            icon = {
//                                CupertinoIcon(
//                                    imageVector = CupertinoIcons.Default.Bookmark,
//                                    contentDescription = null
//                                )
//                            }
//                        ) {
//                            CupertinoText("Add to Favorites")
//                        }
//                    }
//
//                    MenuAction(
//                        onClick = {
//                            dropdownVisible = false
//
//                        },
//                        contentColor = red,
//                        icon = {
//                            CupertinoIcon(
//                                imageVector = CupertinoIcons.Default.Trash,
//                                contentDescription = null
//                            )
//                        }
//                    ) {
//                        CupertinoText("Delete")
//                    }
//                }
//            }
//        }
//    }
//}
//
//private fun LazyListScope.linksWithIcons(
//    state: SectionState,
//    onSheetClicked : () -> Unit,
//    onNavigate: (KClass<out RootComponent.Child>) -> Unit,
//) {
//    section(
//        state = state,
//    ) {
//        link(
//            icon = {
//                CupertinoLinkIcon(
//                    imageVector = CupertinoIcons.Default.Heart,
//                    contentDescription = null,
//                    containerColor = CupertinoColors.systemRed
//                )
//            },
//            caption = {
//                Text("One")
//            },
//            onClick = {
//                onNavigate(RootComponent.Child.Icons::class)
//            }
//        ) {
//            CupertinoText("SF Symbols")
//        }
//
//        link(
//            icon = {
//                CupertinoLinkIcon(
//                    imageVector = CupertinoIcons.Default.SquareSplit1x2,
//                    containerColor = CupertinoColors.systemIndigo
//                )
//            },
//            caption = {
//                Text("Two")
//            },
//            onClick = {
//                onNavigate(RootComponent.Child.Sections::class)
//            }
//        ) {
//            CupertinoText("Sections")
//        }
//
//
//        link(
//            icon = {
//                CupertinoLinkIcon(
//                    imageVector = CupertinoIcons.Default.Iphone,
//                    containerColor = CupertinoColors.systemBlue
//                )
//            },
//            caption = {
//                Text("Three")
//            },
//            onClick = {
//                onNavigate(RootComponent.Child.Adaptive::class)
//            }
//        ) {
//            CupertinoText("Adaptive Widgets")
//        }
//
//        link(
//            icon = {
//                CupertinoLinkIcon(
//                    imageVector = CupertinoIcons.Default.RectangleStack,
//                    contentDescription = null,
//                    containerColor = CupertinoColors.systemCyan
//                )
//            },
//            caption = {
//                Text("Four")
//            },
//            onClick = onSheetClicked
//        ) {
//            CupertinoText("Bottom Sheet")
//        }
//    }
//}

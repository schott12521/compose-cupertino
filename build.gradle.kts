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

plugins {
    // Necessary trick: for the same plugin versions in all sub-modules
    id(libs.plugins.androidLibrary.get().pluginId) apply false
    id(libs.plugins.kotlinMultiplatform.get().pluginId) apply false
    id(libs.plugins.androidApplication.get().pluginId) apply false
    id(libs.plugins.compose.compiler.get().pluginId) version
        libs.plugins.compose.compiler.get().version.displayName apply false
    id(libs.plugins.composeJB.get().pluginId) version
            libs.plugins.composeJB.get().version.displayName apply false
}

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

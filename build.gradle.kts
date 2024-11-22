import com.android.utils.TraceUtils.simpleId

plugins {
    // Necessary trick: for the same plugin versions in all sub-modules
    id(libs.plugins.androidLibrary.get().pluginId) apply false
    id(libs.plugins.kotlinMultiplatform.get().pluginId) apply false
    id(libs.plugins.androidApplication.get().pluginId) apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.21" apply false
    id("org.jetbrains.compose") version "1.7.1" apply false
//    id(libs.plugins.kotlin.android.get().pluginId) apply false
//    id(libs.plugins.org.jetbrains.kotlin.jvm.get().pluginId) apply false
//    alias(libs.plugins.compose.compiler) apply false
//    id("org.jetbrains.compose") apply false
//    id(libs.plugins.composeJB.get().pluginId) apply false
//        alias(libs.plugins.compose.compiler)
//    alias(libs.plugins.composeJB)
//    alias(libs.plugins.compose.compiler)
//    alias(libs.plugins.composeJB)
//    alias(libs.plugins.composeJB) apply false
//    alias(libs.plugins.compose.compiler) apply false
}

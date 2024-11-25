@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("multiplatform-module-convention")
    alias(libs.plugins.composeJB)
    alias(libs.plugins.compose.compiler)
    id("publishing-convention")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.cupertinoCore)
            implementation(compose.runtime)
            implementation(compose.ui)
            implementation(compose.animation)
            implementation(libs.decompose.compose)
            implementation(libs.decompose.core)
        }
    }
}
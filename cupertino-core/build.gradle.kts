@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("multiplatform-module-convention")
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.composeJB)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(compose.ui)
            implementation(compose.foundation)
        }
    }
}

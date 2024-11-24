import org.jetbrains.compose.compose

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("multiplatform-module-convention")
    alias(libs.plugins.composeJB)
    alias(libs.plugins.compose.compiler)
    id("publishing")
}

kotlin {

    sourceSets {
        commonMain.dependencies {
            api(projects.cupertino)
            api(projects.cupertinoNative)
            api(compose.material3)
            implementation(projects.cupertinoCore)
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose("org.jetbrains.compose.ui:ui-util"))
        }
    }
}

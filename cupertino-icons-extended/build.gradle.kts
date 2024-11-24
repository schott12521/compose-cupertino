
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
            implementation(compose.ui)
            api(projects.cupertinoCore)
            implementation(projects.cupertino)
        }
    }
}

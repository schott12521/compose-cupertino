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
            api(projects.cupertinoCore)
            implementation(projects.cupertino)
            implementation(compose.runtime)
            implementation(compose.foundation)
        }
    }
}

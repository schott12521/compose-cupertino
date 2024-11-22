
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("multiplatform-module-convention")
    alias(libs.plugins.composeJB)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(compose.ui)
            api(project(":cupertino-core"))
            implementation(project(":cupertino"))
        }
    }
}

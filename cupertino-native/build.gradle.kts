@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("multiplatform-module-convention")
    alias(libs.plugins.composeJB)
    alias(libs.plugins.compose.compiler)
}

kotlin {

    sourceSets {
        commonMain.dependencies {
            api(project(":cupertino-core"))
            implementation(project(":cupertino"))
            implementation(compose.runtime)
            implementation(compose.foundation)
        }
    }
}

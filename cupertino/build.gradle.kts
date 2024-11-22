@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("multiplatform-module-convention")
    alias(libs.plugins.serialization)
    alias(libs.plugins.composeJB)
    alias(libs.plugins.compose.compiler)
}

kotlin {

    sourceSets {
        commonMain.dependencies {
            api(project(":cupertino-core"))
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.uiUtil)
            implementation(libs.datetime)
            implementation(libs.atomicfu)
            implementation(libs.serialization)
        }
    }
}
//
//
//group = "io.github.alexzhirkevich"
//version = findProperty("version") as String
//
//val jvmTarget = "1.8"
//
//kotlin {
//    applyDefaultHierarchyTemplate()
//
//    androidTarget {
//        compilations.all {
//            kotlinOptions.jvmTarget = jvmTarget
//        }
//    }
//
//    iosArm64()
//    iosX64()
//    iosSimulatorArm64()
//    macosX64()
//    macosArm64()
//
//    jvm("desktop") {
//        compilations.all {
//            kotlinOptions.jvmTarget = jvmTarget
//        }
//    }
//
//    js(IR) {
//        browser()
//    }
//
//    @Suppress("OPT_IN_USAGE")
//    wasmJs {
//        browser()
//    }
//
//    sourceSets {
//        val commonMain by getting {
//            dependencies {
////                api(project(":cupertino-core"))
//                implementation(compose.runtime)
//                implementation(compose.foundation)
//                implementation(compose.uiUtil)
//                implementation(libs.datetime)
//                implementation(libs.atomicfu)
//                implementation(libs.serialization)
//            }
//        }
//        val appleMain by getting
//        val jsMain by getting
//        val androidMain by getting
//        val iosMain by getting
//        val macosMain by getting
//        val desktopMain by getting
//        val wasmJsMain by getting
//
//        val skikoMain by creating {
//            dependsOn(commonMain)
//            appleMain.dependsOn(this)
//            desktopMain.dependsOn(this)
//            jsMain.dependsOn(this)
//            wasmJsMain.dependsOn(this)
//        }
//
//        val nonIosMain by creating {
//            dependsOn(commonMain)
//            macosMain.dependsOn(this)
//            androidMain.dependsOn(this)
//            desktopMain.dependsOn(this)
//            jsMain.dependsOn(this)
//            wasmJsMain.dependsOn(this)
//        }
//
//        val darwinMain by creating {
//            dependsOn(commonMain)
//            iosMain.dependsOn(this)
//            macosMain.dependsOn(this)
//        }
//
//        val jvmMain by creating {
//            dependsOn(commonMain)
//            desktopMain.dependsOn(this)
//            androidMain.dependsOn(this)
//        }
//    }
//}

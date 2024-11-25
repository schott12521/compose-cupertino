
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.composeJB)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.serialization)
    id("com.android.application")
    kotlin("multiplatform")
}

kotlin {

    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "shared"
            isStatic = true

            export(libs.decompose.core)
            export(libs.essenty)
            export("com.arkivanov.essenty:lifecycle:${libs.versions.essenty}")
        }
    }
    
    jvm("desktop")
    
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        moduleName = "composeApp"
        browser {
            commonWebpackConfig {
                outputFileName = "composeApp.js"
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(project.rootDir.path)
                        add(project.projectDir.path)
                    }
                }
                sourceMaps = true
            }
        }
        binaries.executable()
    }

    sourceSets {
        val commonMain by getting
        val desktopMain by getting
        val androidMain by getting

        commonMain.dependencies {
            implementation(projects.cupertino)
            implementation(projects.cupertinoAdaptive)
            implementation(projects.cupertinoNative)
            implementation(projects.cupertinoDecompose)
            implementation(projects.cupertinoIconsExtended)
            implementation(libs.material.kolor)

            api(libs.decompose.core)
            api(libs.essenty)
            implementation(libs.decompose.compose)
            implementation(compose.runtime)
            implementation(compose.ui)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.material3)
            implementation(libs.datetime)
            implementation(libs.serialization)
        }
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
        }
    }

}

android {
    namespace = "com.compose.cupertino.example"
    compileSdk = (findProperty("android.compileSdk") as String).toInt()

    defaultConfig {
        applicationId = "com.compose.cupertino.example"
        minSdk = (findProperty("android.minSdk") as String).toInt()
        versionCode = 1
        versionName = "1.0"
        lint {
            targetSdk = (findProperty("android.targetSdk") as String).toInt()
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.compose.cupertino.example"
            packageVersion = "1.0.0"
        }
    }
}
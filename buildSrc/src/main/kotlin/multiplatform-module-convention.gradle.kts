/*
 * Copyright (c) 2023-2024. Compose Cupertino project and open source contributors.
 * Copyright (c) 2025. Scott Lanoue.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("com.android.library")
    kotlin("multiplatform")
}

kotlin {
    applyDefaultHierarchyTemplate()

    targets.all {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    progressiveMode.set(true)
                    // Disable warnings about expect/actual classes
                    freeCompilerArgs.addAll("-Xexpect-actual-classes")
                }
            }
        }
    }

    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_11)
                }
            }
        }
        publishLibraryVariants("release")
    }

    iosArm64()
    iosX64()
    iosSimulatorArm64()
    macosX64()
    macosArm64()

    jvm("desktop") {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_11)
                }
            }
        }
    }

    js(IR) {
        browser()
    }

    @Suppress("OPT_IN_USAGE")
    wasmJs {
        browser()
    }

    sourceSets {

        val desktopMain by getting
        val wasmJsMain by getting

        val skikoMain by creating {
            dependsOn(commonMain.get())
            appleMain.get().dependsOn(this)
            desktopMain.dependsOn(this)
            jsMain.get().dependsOn(this)
            wasmJsMain.dependsOn(this)
        }
        val nonIosMain by creating {
            dependsOn(commonMain.get())
            macosMain.get().dependsOn(this)
            androidMain.get().dependsOn(this)
            desktopMain.dependsOn(this)
            jsMain.get().dependsOn(this)
            wasmJsMain.dependsOn(this)
        }

        val darwinMain by creating {
            dependsOn(commonMain.get())
            iosMain.get().dependsOn(this)
            macosMain.get().dependsOn(this)
        }

        val jvmMain by creating {
            dependsOn(commonMain.get())
            desktopMain.dependsOn(this)
            androidMain.get().dependsOn(this)
        }
    }
}

android {
    namespace = "com.slapps.cupertino${name.filter { it.isLetter() }}"
    compileSdk = (findProperty("android.compileSdk") as String).toInt()

    defaultConfig {
        minSdk = (findProperty("android.minSdk") as String).toInt()
        lint {
            targetSdk = (findProperty("android.targetSdk") as String).toInt()
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

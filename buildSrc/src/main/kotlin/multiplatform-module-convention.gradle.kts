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
                    jvmTarget.set(JvmTarget.JVM_1_8)
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
                    jvmTarget.set(JvmTarget.JVM_1_8)
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
    namespace = "io.github.alexzhirkevich.${name.filter { it.isLetter() }}"
    compileSdk = (findProperty("android.compileSdk") as String).toInt()

    defaultConfig {
        minSdk = (findProperty("android.minSdk") as String).toInt()
        lint {
            targetSdk = (findProperty("android.targetSdk") as String).toInt()
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

}
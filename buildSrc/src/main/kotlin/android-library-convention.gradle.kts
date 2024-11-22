plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdk = 35
    defaultConfig {
        minSdk = 35
        lint {
            targetSdk = 35
        }
    }
    buildFeatures {
        compose = true
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
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}
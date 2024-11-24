plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(gradleApi())
    implementation(libs.gradle)
//    implementation(libs.gradle.api)
    implementation(libs.kotlin.gradle.plugin)
}

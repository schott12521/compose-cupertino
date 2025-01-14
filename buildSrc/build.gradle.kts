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
    implementation(libs.kotlin.gradle.plugin)
//    implementation(libs.vanniktech.mavenPublish)
    implementation(libs.vanniktech.maven.publish.gradle.plugin)
}

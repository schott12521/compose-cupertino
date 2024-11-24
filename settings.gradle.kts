enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "compose-cupertino"

startParameter.excludedTaskNames.addAll(listOf(
    ":example:composeApp:build",
    ":example:composeApp:assembleDebug",
    ":example:composeApp:assembleDebugUnitTest",
    ":example:composeApp:assembleDebugAndroidTest",
    ":example:composeApp:assemble",
))

include(
    ":cupertino",
    ":cupertino-core",
    ":cupertino-native",
    ":cupertino-adaptive",
    ":cupertino-decompose",
    ":cupertino-icons-extended",
    ":example:composeApp"
)
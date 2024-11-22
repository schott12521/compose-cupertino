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

include(
    ":cupertino",
    ":cupertino-core",
    ":cupertino-native",
    ":cupertino-adaptive",
    ":cupertino-decompose",
    ":cupertino-icons-extended"
)
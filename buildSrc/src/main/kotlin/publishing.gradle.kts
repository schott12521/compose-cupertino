import java.util.Properties
import org.gradle.api.publish.PublishingExtension
import org.gradle.kotlin.dsl.*
import org.gradle.api.publish.maven.MavenPublication

plugins {
    `maven-publish`
}

val publishProperties = Properties().apply {
    load(file("publish.properties").inputStream())
}

// Define the plugin
project.afterEvaluate {
    configure<PublishingExtension> {
        repositories {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/schott12521/ExampleLibrary")
                credentials {
                    username = findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                    password = findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
                }
            }
        }
        publications.withType<MavenPublication> {
            // Assuming that the components have been configured in the module's build.gradle.kts
            // For Kotlin Multiplatform, the publication is usually named "kotlinMultiplatform"
            // For Android, you may need to specify the variant

            // Example for Kotlin Multiplatform:
            from(components["kotlin"])

            pom {
                name.set(project.name)
                description.set("A description for ${project.name}")
                url.set("https://github.com/schott12521/ExampleLibrary")
                description.set(publishProperties.getProperty("description"))

                licenses {
                    license {
                        name.set("Apache-2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0")
                    }
                }
                developers {
                    developer {
                        id.set("alexzhirkevich")
                        name.set("Alexander Zhirkevich")
                        email.set("sasha.zhirkevich@gmail.com")
                    }
                    developer {
                        id.set("schott12521")
                        name.set("Scott Lanoue")
                        email.set("schott12521@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git:https://github.com/schott12521/ExampleLibrary.git")
                    developerConnection.set("scm:git:ssh://github.com/schott12521/ExampleLibrary.git")
                    url.set("https://github.com/schott12521/ExampleLibrary")
                }
            }
        }
    }
}
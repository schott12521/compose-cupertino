import org.gradle.kotlin.dsl.*
import java.util.Properties

plugins {
    `maven-publish`
    signing
}

// Load publish properties (for your project description, etc.)
val publishProperties = Properties().apply {
    load(file("publish.properties").inputStream())
}

// Check if we’re on GitHub Actions
val isGithubActions = System.getenv("GITHUB_ACTIONS") == "true"

val computedVersion = if (isGithubActions) {
    val ref = System.getenv("GITHUB_REF") ?: ""
    if (ref.startsWith("refs/tags/")) {
        // e.g. "refs/tags/1.2.3" -> "1.2.3"
        ref.removePrefix("refs/tags/")
    } else {
        // On a push to a non-tag branch, or something else
        "0.0.0-LOCAL"
    }
} else {
    // Local build fallback
    "0.0.0-LOCAL"
}
version = computedVersion

// Create Javadoc JAR (even if it's empty)
val javadocJar by tasks.registering(Jar::class) {
    archiveClassifier.set("javadoc")
}

publishing.publications.withType<MavenPublication> {
    artifact(javadocJar.get())

    // If your code can also run locally, set up the pom:
    pom {
        name.set(project.name)
        description.set(publishProperties.getProperty("description"))
        url.set("https://github.com/schott12521/ExampleLibrary")

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

// 2) Only configure remote repositories & signing if we're in GitHub Actions
if (isGithubActions) {

    // Repositories
    publishing {
        repositories {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/schott12521/compose-cupertino")
                credentials {
                    username = System.getenv("GITHUB_ACTOR")
                    password = System.getenv("GITHUB_TOKEN")
                }
            }
            maven {
                name = "MavenCentral"
                url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
                credentials {
                    username = System.getenv("OSSRH_USERNAME")
                    password = System.getenv("OSSRH_PASSWORD")
                }
            }
        }
    }

    // Signing
    signing {
        val signingKey = System.getenv("SIGNING_KEY")
        val signingPassword = System.getenv("SIGNING_PASSWORD")

        if (!signingKey.isNullOrBlank() && !signingPassword.isNullOrBlank()) {
            useInMemoryPgpKeys(signingKey, signingPassword)
            sign(publishing.publications)
        }
    }
}
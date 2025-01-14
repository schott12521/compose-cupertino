import com.android.build.gradle.internal.scope.publishArtifactToConfiguration
import com.vanniktech.maven.publish.SonatypeHost
import org.gradle.kotlin.dsl.*
import java.util.Properties

plugins {
    id("com.vanniktech.maven.publish")
    signing
}

// Load publish properties (for your project description, etc.)
val publishProperties = Properties().apply {
    load(file("publish.properties").inputStream())
}

// Check if we’re on GitHub Actions
val isGithubActions = System.getenv("GITHUB_ACTIONS") == "true"

version = System.getenv("VERSION") ?:
    if (isGithubActions)
        error("VERSION must be set for GitHub Actions")
    else
        "0.0.0-LOCAL"

// Create Javadoc JAR (even if it's empty)
val javadocJar by tasks.registering(Jar::class) {
    archiveClassifier.set("javadoc")
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL, automaticRelease = true)

//    publishing {
//        repositories {
//            maven {
//                name = "GitHubPackages"
//                url = uri("https://maven.pkg.github.com/schott12521/compose-cupertino")
//                credentials {
//                    username = System.getenv("GITHUB_ACTOR")
//                    password = System.getenv("GITHUB_TOKEN")
//                }
//            }
//        }
//    }

    if (isGithubActions)
        signAllPublications()

    pom {
        name.set(project.name)
        description.set(publishProperties.getProperty("description"))
        url.set("https://github.com/schott12521/compose-cupertino")

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
            connection.set("scm:git:https://github.com/schott12521/compose-cupertino.git")
            developerConnection.set("scm:git:ssh://github.com/schott12521/compose-cupertino.git")
            url.set("https://github.com/schott12521/compose-cupertino")
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
                url = uri("https://repo1.maven.org/maven2/")
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
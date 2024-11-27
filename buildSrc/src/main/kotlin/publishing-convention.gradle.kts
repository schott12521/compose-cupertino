import org.gradle.kotlin.dsl.*
import java.util.Properties

plugins {
    `maven-publish`
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/schott12521/ExampleLibrary")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}

val publishProperties =
    Properties().apply {
        load(file("publish.properties").inputStream())
    }

val javadocJar by tasks.registering(Jar::class) {
    archiveClassifier.set("javadoc")
}

publishing.publications.withType<MavenPublication> {
    artifact(javadocJar.get())
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

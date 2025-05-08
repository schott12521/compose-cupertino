/*
 * Copyright (c) 2023-2024. Compose Cupertino project and open source contributors.
 * Copyright (c) 2025. Scott Lanoue.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinMultiplatform
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

// TODO use Dokka and fix this
val javadocJar by tasks.registering(Jar::class) {
    archiveClassifier.set("javadoc")
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL, automaticRelease = true)

    coordinates(project.group as String, project.name, project.version as String)
    configure(
        KotlinMultiplatform(
            javadocJar = JavadocJar.Empty(),
            sourcesJar = true,
        )
    )

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
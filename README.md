# compose-cupertino

This is a fork of [alexzhirkevich/compose-cupertino](https://github.com/alexzhirkevich/compose-cupertino) except its been updated to work with CMP 1.7+

Additionally this repo has automated builds to enable faster releases, to take advantage of new compose multiplatform features as they become available.

# Usage

For now this package is only available via github packages.

Add the following to your settings.gradle.kts, making sure that you have set or provided mavenUser and mavenPassword to your github username and a Personal Access Token.
```
maven {
    url = uri("https://maven.pkg.github.com/schott12521/compose-cupertino")
    credentials {
        username = mavenUser
        password = mavenPassword
    }
}
```
Then you can depend on the [latest version](https://github.com/schott12521/compose-cupertino/releases) of the library (including my SwipeBox changes), in libs.versions.toml:

```
cupertino = "$latestVersion"

cupertino = { group = "com.slapps.cupertino", name = "cupertino", version.ref = "cupertino" }
cupertino-adaptive = { group = "com.slapps.cupertino", name = "cupertino-adaptive", version.ref = "cupertino" }
cupertino-decompose = { group = "com.slapps.cupertino", name = "cupertino-decompose", version.ref = "cupertino" }
cupertino-native = { group = "com.slapps.cupertino", name = "cupertino-native", version.ref = "cupertino" }
cupertino-icons-extended = { module = "com.slapps.cupertino:cupertino-icons-extended", version.ref = "cupertino" }
```

Note this repo is not officially supported in any capacity; changes will be applied upstream when applicable ([example1](https://github.com/alexzhirkevich/compose-cupertino/pull/74), [example2](https://github.com/alexzhirkevich/compose-cupertino/pull/77))

## Try it

Wanna see what the library feels like? The latest version builds and deploys the Kotlin/WasmJS target to github pages: https://schott12521.github.io/compose-cupertino/

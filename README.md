# compose-cupertino

This is a fork of [alexzhirkevich/compose-cupertino](https://github.com/alexzhirkevich/compose-cupertino) except its been updated to work with CMP 1.7+

Additionally this repo has automated builds to enable faster releases, to take advantage of new compose multiplatform features as they become available.

# Usage

For now this package is only available via github packages.

Add the following to your settings.gradle.kts, making sure that you have set or provided mavenUser and mavenPassword to your github username and a Personal Access Token.
```
maven {
    url = uri("https://maven.pkg.github.com/schott12521/ExampleLibrary")
    credentials {
        username = mavenUser
        password = mavenPassword
    }
}
```
Then you can depend on the latest version of the library (including my SwipeBox changes), in libs.versions.toml:

```
cupertino = "0.1.0"

cupertino = { group = "io.github.alexzhirkevich", name = "cupertino", version.ref = "cupertino" }
cupertino-adaptive = { group = "io.github.alexzhirkevich", name = "cupertino-adaptive", version.ref = "cupertino" }
cupertino-decompose = { group = "io.github.alexzhirkevich", name = "cupertino-decompose", version.ref = "cupertino" }
cupertino-native = { group = "io.github.alexzhirkevich", name = "cupertino-native", version.ref = "cupertino" }
cupertino-icons-extended = { module = "io.github.alexzhirkevich:cupertino-icons-extended", version.ref = "cupertino" }
```

Note this repo is not officially supported in any capacity; changes will be applied upstream when applicable ([example1](https://github.com/alexzhirkevich/compose-cupertino/pull/74), [example2](https://github.com/alexzhirkevich/compose-cupertino/pull/77))

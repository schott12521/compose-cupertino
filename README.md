# compose-cupertino

This is a fork of [alexzhirkevich/compose-cupertino](https://github.com/alexzhirkevich/compose-cupertino) except its been updated to work with CMP 1.7+

Additionally this repo has automated builds to enable faster releases, to take advantage of new compose multiplatform features as they become available.

## New features (compared to the OG `compose-cupertino`)

- Updated SwipeBox
- Fixed Cupertino Date Picker implementations to interact with scrolling correctly

# Usage

This package is published to Maven Packages: // TODO include link

Depend on the [latest version](https://github.com/schott12521/compose-cupertino/releases) by declaring this in libs.versions.toml:

```
cupertino = "$latestVersion"

cupertino = { group = "io.github.schott12521", name = "cupertino", version.ref = "cupertino" }
cupertino-adaptive = { group = "io.github.schott12521", name = "cupertino-adaptive", version.ref = "cupertino" }
cupertino-decompose = { group = "io.github.schott12521", name = "cupertino-decompose", version.ref = "cupertino" }
cupertino-native = { group = "io.github.schott12521", name = "cupertino-native", version.ref = "cupertino" }
cupertino-icons-extended = { group = "io.github.schott12521", name = "cupertino-icons-extended", version.ref = "cupertino" }
```

Note this repo is not officially supported in any capacity; changes will be applied upstream when applicable ([example1](https://github.com/alexzhirkevich/compose-cupertino/pull/74), [example2](https://github.com/alexzhirkevich/compose-cupertino/pull/77))

## Try it

Wanna see what the library feels like? The latest version builds and deploys the Kotlin/WasmJS target to github pages: https://schott12521.github.io/compose-cupertino/

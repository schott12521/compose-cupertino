# Compose Cupertino Example app

This application (excluded from the default `gradle build`) runs an example application across iOS, Android, Desktop, and Web (using WasmJS).

To build these targets, it is recommended to utilize Android Studio + Run Configurations.

## Running on Desktop

```shell
:example:composeApp:run
```

## Running on Web

```shell
:example:composeApp:wasmJsBrowserRun
```

## Running on iOS

Ensure that you have a Run Configuration that looks similar to this:

TODO insert image

```
<configuration name="example iOS App" type="KmmRunConfiguration" factoryName="iOS Application" CONFIG_VERSION="1" EXEC_TARGET_ID="$TARGET_ID" XCODE_PROJECT="$PROJECT_DIR$/example/iosApp/iosApp.xcodeproj" XCODE_CONFIGURATION="Debug" XCODE_SCHEME="iosApp">
  <method v="2">
    <option name="com.jetbrains.kmm.ios.BuildIOSAppTask" enabled="true" />
  </method>
</configuration>
```

## Running on Android
## Get Devices ID (IMEI, SECUREID, SIM SERIAL NUMBER) for Android Devices

[![](https://jitpack.io/v/memishood/android-device-id.svg)](https://jitpack.io/#memishood/android-device-id)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

# Download
#### 1.Add this in your root `build.gradle` at the end of repositories:
    allprojects {
        repositories {
            ...
            maven { url "https://jitpack.io" }
        }
    }
  
#### 2.Add this dependency in your app level `build.gradle`:
    dependencies {
        ...
        def latestVersion = "1.0.4"
        implementation "com.github.memishood:Android-Device-ID:$latestVersion"
    }


### Manifest.xml
#### Add READ_PHONE_STATE Permission to your manifest

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="yourpackage">

    <uses-permission android:name="android.permission.READ_PHONE_STATE"/>

    <application>
     ...
    </application>
</manifest>
```

### Kotlin
Remember to check READ_PHONE_STATE permission before using 
```kotlin
val deviceInfo = DeviceInfo(this)

deviceInfo.imei?.let { imei ->
    // your code..
}
        
deviceInfo.simSerialNumber?.let { simSerialNumber ->
    // your code..
}

deviceInfo.secureId?.let { secureId ->
    // your code..
}
```

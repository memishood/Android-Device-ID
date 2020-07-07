## Get Devices ID (IMEI, SECUREID, SIM SERIAL NUMBER) for Android Studio

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

### Setup
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
```
dependencies {
    def version = "1.0.1"
    implementation "com.github.memishood:Android-Device-ID:$version"
}
```

### Manifest.xml
#### Add READ_PHONE_STATE Permission to your manifest

```

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

```
val imei = DeviceInfo.imei(this)

if (imei == null) {
  // permissions are not granted or context is null
}


val simSerialNumber = DeviceInfo.simSerialNumber(this)

if (imei == null) {
  // permissions are not granted or context is null
}

val secureId = DeviceInfo.secureId(this)

if (secureId == null) {
  // context is null
}
```

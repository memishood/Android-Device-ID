package tr.com.emrememis.getdeviceid

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.provider.Settings
import android.support.v4.content.ContextCompat
import android.telephony.TelephonyManager

class DeviceInfo(private var context: Context) {
    private var telephonyManager: TelephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    fun getDeviceIMEI(): String {
        if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED)
            if (Build.VERSION.SDK_INT >= 26) return telephonyManager.imei
            else return telephonyManager.deviceId
        else
            throw Exception("TR: istek reddedildi, lütfen kullanıcıdan READ_PHONE_STATE iznini alın")
    }

    fun getSimSerialNumber(): String {
        if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED)
            return telephonyManager.simSerialNumber
        else
            throw Exception("TR: istek reddedildi, lütfen kullanıcıdan READ_PHONE_STATE iznini alın")
    }

    fun getSecureAndroidId(): String {
        val androidId: String? = Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
        if (androidId != null)
            return androidId
        else
            throw Exception("TR: istek reddedildi, lütfen kullanıcıdan READ_PHONE_STATE iznini alın")
    }
}
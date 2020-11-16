package tr.com.emrememis.device.info.library

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.ContextCompat
import android.telephony.TelephonyManager
import android.provider.Settings

@Suppress("DEPRECATION", "HardwareIds", "MissingPermission")
class DeviceInfo constructor(var context: Context?) {
    val imei: String?
        get() {
            if (hasPermissions(context)) {
                val telephonyManager = context?.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager?
                return when {
                    Build.VERSION.SDK_INT >= Build.VERSION_CODES.O -> telephonyManager?.imei
                    else -> telephonyManager?.deviceId
                }
            }
            return null
        }

    val simSerialNumber: String?
        get() {
            if (hasPermissions(context)) {
                val telephonyManager = context?.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager?
                return telephonyManager?.simSerialNumber
            }
            return null
        }

    val secureId: String?
        get() {
            return Settings.Secure.getString(context?.contentResolver, Settings.Secure.ANDROID_ID)
        }

    companion object {
        fun hasPermissions(context: Context?): Boolean = context?.let {
            ContextCompat.checkSelfPermission(it, Manifest.permission.READ_PHONE_STATE)
        } == PackageManager.PERMISSION_GRANTED
    }
}
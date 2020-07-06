package tr.com.emrememis.device.info.library

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.ContextCompat
import android.telephony.TelephonyManager
import android.provider.Settings

object DeviceInfo {

    @SuppressLint("HardwareIds", "MissingPermission")
    fun imei(context: Context?): String? {
        context ?: return null
        val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        if (hasPermissions(context)) {
            return if (Build.VERSION.SDK_INT >= 26) telephonyManager.imei else telephonyManager.deviceId
        }
        return null
    }


    @SuppressLint("MissingPermission", "HardwareIds")
    fun simSerialNumber(context: Context?): String? {
        context ?: return null
        val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        if (hasPermissions(context)) {
            return telephonyManager.simSerialNumber
        }
        return null
    }

    @SuppressLint("HardwareIds")
    fun secureId(context: Context?): String? {
        context ?: return null
        return Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
    }

    private fun hasPermissions(context: Context): Boolean = ContextCompat.checkSelfPermission(context,
            Manifest.permission.READ_PHONE_STATE)== PackageManager.PERMISSION_GRANTED
}
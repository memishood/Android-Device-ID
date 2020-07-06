package tr.com.emrememis.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tr.com.emrememis.device.info.library.DeviceInfo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

    }
}
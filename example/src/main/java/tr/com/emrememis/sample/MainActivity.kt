package tr.com.emrememis.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tr.com.emrememis.device.info.library.DeviceInfo

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
    }
}

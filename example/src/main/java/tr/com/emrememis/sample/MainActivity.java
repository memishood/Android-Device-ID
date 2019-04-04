package tr.com.emrememis.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import tr.com.emrememis.getdeviceid.DeviceInfo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DeviceInfo deviceInfo = new DeviceInfo(this);
        Log.d("onEmre",deviceInfo.getDeviceIMEI());
        Log.d("onEmre",deviceInfo.getSecureAndroidId());
        Log.d("onEmre",deviceInfo.getSimSerialNumber());
    }
}
//package tr.com.emrememis.getdeviceid;
//
//import android.Manifest;
//import android.content.Context;
//import android.content.pm.PackageManager;
//import android.os.Build;
//import android.provider.Settings;
//import android.support.v4.content.ContextCompat;
//import android.telephony.TelephonyManager;
//
//public class DeviceInfo {
//    private Context context;
//    private TelephonyManager telephonyManager;
//    public DeviceInfo(Context context){
//        this.context = context;
//        this.telephonyManager = (TelephonyManager) this.context.getSystemService(Context.TELEPHONY_SERVICE);
//    }
//
//    public String getDeviceId() throws Exception {
//        if (ContextCompat.checkSelfPermission(this.context, Manifest.permission.READ_PHONE_STATE)
//                == PackageManager.PERMISSION_GRANTED){
//            if (Build.VERSION.SDK_INT >= 26){
//                return telephonyManager.getImei();
//            }else{
//                return telephonyManager.getDeviceId();
//            }
//        }else{
//            throw new Exception("TR: istek reddedildi, lütfen kullanıcıdan READ_PHONE_STATE iznini alın");
//        }
//    }
//
//    public String getSimSerialNumber() throws Exception {
//        if (ContextCompat.checkSelfPermission(this.context, Manifest.permission.READ_PHONE_STATE)
//                == PackageManager.PERMISSION_GRANTED){
//            return telephonyManager.getSimSerialNumber();
//        }else{
//            throw new Exception("TR: istek reddedildi, lütfen kullanıcıdan READ_PHONE_STATE iznini alın");
//        }
//    }
//    public String getSecureAndroidId() throws Exception {
//        return Settings.Secure.getString(this.context.getContentResolver(),Settings.Secure.ANDROID_ID);
//    }
//}

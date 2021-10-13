package ndk.utils_android1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.TelephonyManager;

import static android.content.Context.TELEPHONY_SERVICE;

public class TelephonyUtils {

    public static boolean dialMobileNumber(Context context, String mobileNumber) {

        if (isTelephonyEnabled(context)) {

            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:" + mobileNumber));
            context.startActivity(callIntent);
            return true;
        }
        return false;
    }

    public static boolean isTelephonyEnabled(Context context) {

        TelephonyManager tm = (TelephonyManager) context.getSystemService(TELEPHONY_SERVICE);
        return tm != null && tm.getSimState() == TelephonyManager.SIM_STATE_READY;
    }
}

package ndk.utils_android1;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils1 {

    public static void longToast(Context applicationContext, String message) {

        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show();
    }

    public static void shortToast(Context context, String message) {

        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void errorToast(Context context) {
        longToast(context, "Error...");
    }

    public static void offlineToast(Context context) {

        longToast(context, "Internet is unavailable...");
    }

    public static void noEntriesToast(Context context) {
        longToast(context, "No Entries...");
    }
}

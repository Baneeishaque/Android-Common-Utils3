package ndk.utils_android1;

import android.content.Context;
import android.util.Log;

import ndk.utils_android3.BuildConfig;

public class LogUtils1 {

    public static void debug(String tag, String message) {

        if (BuildConfig.DEBUG) {

            Log.d(tag, message);
        }
    }

    public static void debugOnGui(String message, Context currentApplicationContext, String applicationTag) {

        if (BuildConfig.DEBUG) {

            ToastUtils1.longToast(currentApplicationContext, message);
        }
        debug(applicationTag, message);
    }
}

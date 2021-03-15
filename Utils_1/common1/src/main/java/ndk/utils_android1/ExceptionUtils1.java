package ndk.utils_android1;

import android.content.Context;

import java.util.Arrays;

public class ExceptionUtils1 {

    public static String getExceptionDetails(Exception e) {

        return "Exception Message : " + e.getLocalizedMessage()
                + "\n" + "Exception Code : " + e.hashCode()
                + "\n" + "Exception Class : " + e.getClass()
                + "\n" + "Exception Cause : " + e.getCause()
                + "\n" + "Exception StackTrace : " + Arrays.toString(e.getStackTrace())
                + "\n" + "Exception : " + e.toString();

    }

    public static void handleException(boolean isGuiPresent, Context applicationContext, final String tag, Exception exception) {

        if (isGuiPresent) {

            //TODO : Short Toast
            ToastUtils.longToast(applicationContext, "Error...");
        }

        LogUtils.debug(tag, getExceptionDetails(exception));
    }

    public static void handleExceptionOnGui(Context applicationContext, final String tag, Exception exception) {

        handleException(true, applicationContext, tag, exception);
    }
}

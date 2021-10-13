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
                + "\n" + "Exception : " + e;
    }

    public static void handleException(boolean isGuiPresent, Context applicationContext, final String tag, String exceptionDetails) {

        if (isGuiPresent) {

            //TODO : Short Toast
            ToastUtils1.longToast(applicationContext, "Error...");
            LogUtils1.debugOnGui(exceptionDetails, applicationContext, tag);

        } else {

            LogUtils1.debug(tag, exceptionDetails);
        }
    }

    public static void handleException(boolean isGuiPresent, Context applicationContext, final String tag, Exception exception) {

        handleException(isGuiPresent, applicationContext, tag, getExceptionDetails(exception));
    }

    public static void handleExceptionOnGui(Context applicationContext, final String tag, Exception exception) {

        handleException(true, applicationContext, tag, getExceptionDetails(exception));
    }

    public static void handleExceptionOnGui(Context applicationContext, final String tag, String exceptionDetails) {

        handleException(true, applicationContext, tag, exceptionDetails);
    }
}

package ndk.utils_android1;

import android.content.Context;

public abstract class LogUtilsWrapper1 {

    public void debug(String message) {

        LogUtils1.debug(configureApplicationTag(), message);
    }

    public abstract String configureApplicationTag();

    public void debugOnGui(String message) {

        LogUtils1.debugOnGui(message, configureCurrentApplicationContext(), configureApplicationTag());
    }

    public abstract Context configureCurrentApplicationContext();
}

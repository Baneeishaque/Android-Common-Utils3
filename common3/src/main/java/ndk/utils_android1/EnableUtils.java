package ndk.utils_android1;

import android.view.View;

public class EnableUtils {

    public static void enableViews(View[] views) {

        for (View view : views) {
            view.setEnabled(true);
        }
    }

    public static void disableViews(View[] views) {

        for (View view : views) {
            view.setEnabled(false);
        }
    }
}

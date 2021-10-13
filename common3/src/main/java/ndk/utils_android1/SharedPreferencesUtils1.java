package ndk.utils_android1;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUtils1 {

    public static SharedPreferences getSharedPreferences(Context applicationContext, String applicationName) {

        return applicationContext.getSharedPreferences(applicationName, Context.MODE_PRIVATE);
    }
}

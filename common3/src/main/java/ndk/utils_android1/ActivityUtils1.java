package ndk.utils_android1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class ActivityUtils1 {

    public static void startActivityForIntent(Context currentActivityContext, Intent nextActivityIntent) {

        currentActivityContext.startActivity(nextActivityIntent);
    }

    public static void startActivityForClass(Context currentActivityContext, Class nextActivityClass) {

        startActivityForIntent(currentActivityContext, new Intent(currentActivityContext, nextActivityClass));
    }

    public static Intent getIntentForUrl(String url) {

        return new Intent(Intent.ACTION_VIEW, Uri.parse(url));
    }

    public static void startActivityForUrl(Context currentActivityContext, String url) {

        startActivityForIntent(currentActivityContext, getIntentForUrl(url));
    }
}

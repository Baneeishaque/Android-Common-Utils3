package ndk.utils_android1;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;

public class JSONUtils {

    public static void printIndexedJSONArrayWithLength(JSONArray jsonArray, String jsonArrayName, String applicationName, Context context) {

        LogUtils1.debug(applicationName, "Length of " + jsonArrayName + " : " + jsonArray.length());
        printIndexedJSONArray(jsonArray, jsonArrayName, applicationName, context);
    }

    private static void printIndexedJSONArray(JSONArray jsonArray, String jsonArrayName, String applicationName, Context context) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                if (i == 0) {
                    result.append("[").append(i).append("] ").append(jsonArray.getJSONObject(i).toString());
                } else {
                    result.append("\n").append("[").append(i).append("] ").append(jsonArray.getJSONObject(i).toString());
                }
            } catch (JSONException e) {
                ErrorUtils.displayException(context, e, applicationName);
            }
        }

        LogUtils1.debug(applicationName, "Indexed " + jsonArrayName + " : " + result);
    }
}

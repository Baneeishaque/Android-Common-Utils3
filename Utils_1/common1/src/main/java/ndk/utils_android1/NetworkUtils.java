package ndk.utils_android1;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import static android.graphics.Color.RED;

public class NetworkUtils {

    public static boolean isOnline(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm != null ? cm.getActiveNetworkInfo() : null;
        if (!(netInfo != null && netInfo.isConnectedOrConnecting())) {

            ToastUtils.longToast(context, "Internet is unavailable");
        }
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public static String[] performHttpClientGetTask(String url) {

        try {
            DefaultHttpClient defaultHttpClient;
            HttpPost httpPost;
            String networkActionResponse;

            defaultHttpClient = new DefaultHttpClient();
            httpPost = new HttpPost(url);
            ResponseHandler<String> basicResponseHandler = new BasicResponseHandler();

            networkActionResponse = defaultHttpClient.execute(httpPost, basicResponseHandler);

            return new String[]{"0", networkActionResponse};

        } catch (UnsupportedEncodingException e) {

            return new String[]{"1", "UnsupportedEncodingException : " + e.getLocalizedMessage()};

        } catch (ClientProtocolException e) {

            return new String[]{"1", "ClientProtocolException : " + e.getLocalizedMessage()};

        } catch (IOException e) {

            return new String[]{"1", "IOException : " + e.getLocalizedMessage()};
        }
    }

    // TODO : Improve to handle exception objects
    public static void displayFriendlyExceptionMessage(Context context, String networkExceptionMessage) {
        if (networkExceptionMessage.contains("IOException")) {
            ToastUtils.longToast(context, "Check your network connection...");
        }
    }

    public static void checkNetworkThenStartActivity(Context context, Class activity) {
        if (isOnline(context)) {
            ActivityUtils1.startActivityForClass(context, activity);
        } else {
            ToastUtils.offlineToast(context);
        }
    }

    public static void displayNetworkActionResponse(String tag, String[] networkActionResponseArray) {

        LogUtils.debug(tag, "Network Action Response Array : " + Arrays.toString(networkActionResponseArray));
    }

    //TODO : Can ping function
    //TODO : No connection SnackBar with Retry option

    public static String[] performHttpGet(String url) {

        String inputLine;

        try {
            //Create a connection
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            //Set methods and timeouts
            connection.setRequestMethod("GET");

            // TODO : Connection With Read Timeout
            // TODO : Connection With Connection Timeout
//            connection.setReadTimeout(READ_TIMEOUT);
//            connection.setConnectTimeout(CONNECTION_TIMEOUT);

            //Connect to our url
            connection.connect();
            //Create a new InputStreamReader
            InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
            //Create a new buffered reader and String Builder
            BufferedReader reader = new BufferedReader(streamReader);
            StringBuilder stringBuilder = new StringBuilder();
            //Check if the line we are reading is not null
            while ((inputLine = reader.readLine()) != null) {
                stringBuilder.append(inputLine);
            }
            //Close our InputStream and Buffered reader
            reader.close();
            streamReader.close();
            //Set our result equal to our stringBuilder
            return new String[]{"0", stringBuilder.toString()};

        } catch (ProtocolException e) {

            return new String[]{"1", "ProtocolException : " + e.getLocalizedMessage()};

        } catch (MalformedURLException e) {

            return new String[]{"1", "MalformedURLException : " + e.getLocalizedMessage()};

        } catch (IOException e) {

            return new String[]{"1", "IOException : " + e.getLocalizedMessage()};
        }
    }
}

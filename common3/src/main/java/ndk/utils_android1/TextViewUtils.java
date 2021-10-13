package ndk.utils_android1;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

import static android.graphics.Color.BLACK;

public class TextViewUtils {

    public static TextView generateTextView(Context context, String text, float textSize, int textColor) {

        TextView textView = new TextView(context);
        textView.setText(text);
        textView.setTextSize(textSize);
        textView.setTextColor(textColor);
        return textView;
    }

    public static TextView generateTableRowMatchedTextView(Context context, String text, float textSize, int textColor) {

        TextView textView = generateTextView(context, text, textSize, textColor);
        textView.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT));
        return textView;
    }

    public static TextView generateTableRowMatchedNormalTextView(Context context, String text, int textColor) {

        return generateTableRowMatchedTextView(context, text, 14, textColor);
    }

    public static TextView generateTableRowMatchedBlackTextView(Context context, String text) {

        return generateTableRowMatchedNormalTextView(context, text, BLACK);
    }

    public static TextView generateNormalTextView(Context context, String text, int textColor) {
        return generateTextView(context, text, 14, textColor);
    }

    public static TextView generateNormalBlankTextView(Context context) {
        return generateNormalTextView(context, "", BLACK);
    }

    public static TextView generateNormalBlackTextView(Context context, String text) {
        return generateNormalTextView(context, text, BLACK);
    }

    public static TextView generateCentralizedNormalBlackTextView(Context context, String text) {

        TextView textView = generateNormalTextView(context, text, BLACK);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    public static TextView generateNormalInvisibleTextView(Context context, String text) {
        TextView textView = generateNormalTextView(context, text, BLACK);
        textView.setVisibility(View.GONE);
        return textView;
    }
}

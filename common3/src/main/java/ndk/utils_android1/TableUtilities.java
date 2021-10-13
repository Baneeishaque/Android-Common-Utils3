package ndk.utils_android1;

import android.content.Context;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;

import static android.graphics.Color.CYAN;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.LTGRAY;
import static android.graphics.Color.MAGENTA;
import static android.graphics.Color.TRANSPARENT;
import static android.graphics.Color.YELLOW;
import static android.view.Gravity.CENTER_VERTICAL;

public class TableUtilities {

    public static TableRow generateTableRow(Context activityContext, TableRow.LayoutParams tableRawParameters) {

        TableRow tableRow = new TableRow(activityContext);
        tableRow.setLayoutParams(tableRawParameters);
        return tableRow;
    }

    public static TableRow generateColoredTableRow(Context activityContext, TableRow.LayoutParams tableRawParameters, int rowColor) {

        TableRow tableRow = generateTableRow(activityContext, tableRawParameters);
        tableRow.setBackgroundColor(rowColor);
        return tableRow;
    }

    public static TableRow generateFullWidthColoredTableRow(Context activityContext, int rowColor) {

        return generateColoredTableRow(activityContext, new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT), rowColor);
    }

    public static TableRow generateFullWidthTableRow(Context activityContext) {

        return generateTableRow(activityContext, new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT));
    }

    public static TableRow generateContentWrappedTableRow(Context activityContext, int rowColor) {

        return generateColoredTableRow(activityContext, new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT), rowColor);
    }

    public static TableRow generateFullWidthTransparentTableRow(Context activityContext) {

        return generateFullWidthColoredTableRow(activityContext, TRANSPARENT);
    }

    public static TableRow generateContentWrappedTransparentTableRow(Context activityContext) {

        return generateContentWrappedTableRow(activityContext, TRANSPARENT);
    }

    public static void addBlankRow(TableLayout table, Context activityContext) {

        table.addView(generateBlankTableRow(activityContext));
    }

    public static void addRowWithSpicedLineOnFirstColumn(TableLayout table, Context activityContext) {

        table.addView(generateTableRowWithSpicedLineOnFirstColumn(activityContext));
    }

    public static void addRowWithLineOnFirstColumn(TableLayout table, Context activityContext) {

        table.addView(generateTableRowWithLineOnFirstColumn(activityContext));
    }

    public static TableRow generateTableRowWithTextOnFirstColumn(Context activityContext, String text) {

        final TableRow dashedTableRow = generateFullWidthTableRow(activityContext);
        dashedTableRow.addView(TextViewUtils.generateTableRowMatchedBlackTextView(activityContext, text));
        return dashedTableRow;
    }

    public static TableRow generateTableRowWithSpicedLineOnFirstColumn(Context activityContext) {

        return generateTableRowWithTextOnFirstColumn(activityContext, "- - - - - -");
    }

    public static TableRow generateTableRowWithLineOnFirstColumn(Context activityContext) {

        return generateTableRowWithTextOnFirstColumn(activityContext, "-----------");
    }

    public static void addColoredBlankRow(TableLayout table, Context activityContext, int color) {

        table.addView(generateColouredBlankTableRow(activityContext, color));
    }

    public static TableRow generateBlankTableRow(Context activityContext) {

        final TableRow blankTableRow = generateFullWidthTransparentTableRow(activityContext);
        blankTableRow.addView(TextViewUtils.generateNormalBlankTextView(activityContext));
        return blankTableRow;
    }

    public static TableRow generateColouredBlankTableRow(Context activityContext, int color) {

        final TableRow blankTableRow = generateFullWidthColoredTableRow(activityContext, color);
        blankTableRow.addView(TextViewUtils.generateNormalBlankTextView(activityContext));
        return blankTableRow;
    }

    public static TableRow generateFullWidthCyanTableRow(Context activityContext) {

        return generateFullWidthColoredTableRow(activityContext, CYAN);
    }

    public static TableRow generateFullWidthMagentaTableRow(Context activityContext) {

        return generateFullWidthColoredTableRow(activityContext, MAGENTA);
    }

    public static TableRow generateFullWidthYellowTableRow(Context activityContext) {

        return generateFullWidthColoredTableRow(activityContext, YELLOW);
    }

    public static TableRow generateFullWidthLightGrayTableRow(Context activityContext) {

        return generateFullWidthColoredTableRow(activityContext, LTGRAY);
    }

    public static TableRow generateFullWidthGreenTableRow(Context activityContext) {

        return generateFullWidthColoredTableRow(activityContext, GREEN);
    }

    public static TableRow generateFullWidthCentralizedGreenTableRow(Context activityContext) {

        TableRow tableRow = generateFullWidthGreenTableRow(activityContext);
        tableRow.setGravity(CENTER_VERTICAL);
        return tableRow;
    }

    public static TableRow generateFullWidthCentralizedCustomHeightGreenTableRow(Context activityContext, int height) {

        TableRow tableRow = generateFullWidthCentralizedGreenTableRow(activityContext);
        tableRow.setMinimumHeight(DisplayHelper.dpToPixel(height, activityContext));
        return tableRow;
    }

    public static TableRow generateFullWidthCentralizedNormalHeightGreenTableRow(Context activityContext) {

        return generateFullWidthCentralizedCustomHeightGreenTableRow(activityContext, 40);
    }

    public static void addViewsToTableRow(TableRow tableRow, View[] views) {

        for (View view : views) {
            tableRow.addView(view);
        }
    }
}

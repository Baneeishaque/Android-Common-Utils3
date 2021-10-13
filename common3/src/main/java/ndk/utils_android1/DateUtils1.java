package ndk.utils_android1;

import org.javatuples.Pair;
import org.javatuples.Triplet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils1 {

    public static SimpleDateFormat mySqlDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.UK);
    public static SimpleDateFormat normalDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.UK);
    public static SimpleDateFormat normalDateInWordsFormat = new SimpleDateFormat("EEE, MMM dd, yyyy", Locale.UK);
    public static SimpleDateFormat mySqlDateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.UK);
    public static SimpleDateFormat normalDateTimeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.UK);
    public static SimpleDateFormat normalDateTimeShortYearFormat = new SimpleDateFormat("dd-MM-yy HH:mm", Locale.UK);
    public static SimpleDateFormat normalDateShortYearFormat = new SimpleDateFormat("dd-MM-yy", Locale.UK);
    public static SimpleDateFormat normalDateTimeInWordsFormat = new SimpleDateFormat("EEE, MMM dd, yyyy HH:mm", Locale.UK);
    public static SimpleDateFormat normalStrippedDateFormat = new SimpleDateFormat("MMM dd", Locale.UK);

    public static String getCurrentDateInMySqlDateString() {

        return mySqlDateFormat.format(new Date());
    }

    public static Date addDays(Date date, int days) {

        return org.apache.commons.lang3.time.DateUtils.addDays(date, days);
    }

    public static String dateToMySqlDateString(Date date) {

        return mySqlDateFormat.format(date);
    }

    public static String dateTimeToCustomDateTimeString(Date date, SimpleDateFormat customDateTimeFormat) {

        return customDateTimeFormat.format(date);
    }

    public static String dateToNormalDateString(Date date) {

        return normalDateFormat.format(date);
    }

    public static String getCurrentDateInNormalDateFormat() {

        return normalDateFormat.format(new Date());
    }

    public static String getTomorrowDateInNormalDateFormat() {

        return normalDateFormat.format(addDays(new Date(), 1));
    }

    public static org.javatuples.Pair<Boolean, String> normalDateStringToMySqlDateString(String normalDateString) {

        try {

            Date normalDate = normalDateFormat.parse(normalDateString);
            if (normalDate != null) {

                return org.javatuples.Pair.with(true, mySqlDateFormat.format(normalDate));

            } else {

                return org.javatuples.Pair.with(false, "Normal Date is NULL");
            }
        } catch (ParseException parseException) {

            return org.javatuples.Pair.with(false, ExceptionUtils1.getExceptionDetails(parseException));
        }
    }

    public static org.javatuples.Pair<Boolean, String> normalDateTimeInWordsStringToMysqlDateTimeString(String normalDateTimeInWordsString) {

        try {

            Date normalDateTimeInWords = normalDateTimeInWordsFormat.parse(normalDateTimeInWordsString);
            if (normalDateTimeInWords != null) {

                return org.javatuples.Pair.with(true, mySqlDateTimeFormat.format(normalDateTimeInWords));

            } else {

                return org.javatuples.Pair.with(false, "Normal DateTimeInWords is NULL");
            }
        } catch (ParseException parseException) {

            return org.javatuples.Pair.with(false, ExceptionUtils1.getExceptionDetails(parseException));
        }
    }

    public static Pair<Boolean, String> mySqlDateStringToNormalDateString(String mySqlDateString) {

        try {

            Date mySqlDate = mySqlDateFormat.parse(mySqlDateString);
            if (mySqlDate != null) {

                return org.javatuples.Pair.with(true, normalDateFormat.format(mySqlDate));

            } else {

                return org.javatuples.Pair.with(false, "MySQL Date is NULL");
            }
        } catch (ParseException parseException) {

            return org.javatuples.Pair.with(false, ExceptionUtils1.getExceptionDetails(parseException));
        }
    }

    public static Pair<Boolean, String> mySqlDateTimeStringToNormalDateTimeString(String mySqlDateTimeString) {

        try {

            Date mySqlDateTime = mySqlDateTimeFormat.parse(mySqlDateTimeString);
            if (mySqlDateTime != null) {

                return org.javatuples.Pair.with(true, normalDateTimeFormat.format(mySqlDateTime));

            } else {

                return org.javatuples.Pair.with(false, "MySQL DateTime is NULL");
            }
        } catch (ParseException parseException) {

            return org.javatuples.Pair.with(false, ExceptionUtils1.getExceptionDetails(parseException));
        }
    }

    public static Pair<Boolean, String> mySqlDateTimeStringToCustomDateTimeString(String mySqlDateTimeString, SimpleDateFormat customDateTimeFormat) {

        try {

            Date mySqlDateTime = mySqlDateTimeFormat.parse(mySqlDateTimeString);
            if (mySqlDateTime != null) {

                return org.javatuples.Pair.with(true, customDateTimeFormat.format(mySqlDateTime));

            } else {

                return org.javatuples.Pair.with(false, "MySQL DateTime is NULL");
            }
        } catch (ParseException parseException) {

            return org.javatuples.Pair.with(false, ExceptionUtils1.getExceptionDetails(parseException));
        }
    }

    public static Triplet<Boolean, Date, String> mySqlDateTimeStringToCustomDateTime(String mySqlDateTimeString, SimpleDateFormat customDateTimeFormat) {

        try {
            Date mySqlDateTime = mySqlDateTimeFormat.parse(mySqlDateTimeString);
            if (mySqlDateTime != null) {

                return org.javatuples.Triplet.with(true, customDateTimeFormat.parse(customDateTimeFormat.format(mySqlDateTime)), "");

            } else {

                return org.javatuples.Triplet.with(false, customDateTimeFormat.parse(customDateTimeFormat.format(new Date())), "MySQL DateTime is NULL");
            }
        } catch (ParseException parseException) {

            return org.javatuples.Triplet.with(false, new Date(), ExceptionUtils1.getExceptionDetails(parseException));
        }
    }

    public static Triplet<Boolean, Date, String> mySqlDateStringToMySqlDate(String mySqlDateString) {

        try {

            return Triplet.with(true, mySqlDateFormat.parse(mySqlDateString), "");

        } catch (ParseException parseException) {

            return Triplet.with(false, new Date(), ExceptionUtils1.getExceptionDetails(parseException));
        }
    }

    public static Triplet<Boolean, Date, String> normalDateStringToDate(String normalDateString) {

        try {

            return Triplet.with(true, normalDateFormat.parse(normalDateString), "");

        } catch (ParseException parseException) {

            return Triplet.with(false, new Date(), ExceptionUtils1.getExceptionDetails(parseException));
        }
    }

    public static Triplet<Boolean, Date, String> normalDateTimeStringToDate(String normalDateTimeString) {

        try {

            return Triplet.with(true, normalDateTimeFormat.parse(normalDateTimeString), "");

        } catch (ParseException parseException) {

            return Triplet.with(false, new Date(), ExceptionUtils1.getExceptionDetails(parseException));
        }
    }

    public static String dateToMysqlDateTimeString(Date date) {

        return mySqlDateTimeFormat.format(date);
    }
}

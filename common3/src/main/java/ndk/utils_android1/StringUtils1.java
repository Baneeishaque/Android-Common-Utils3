package ndk.utils_android1;

public class StringUtils1 {

    public static String removeQuotations(String string) {
        return removeSymbol(string, "\"");
    }

    public static String removeSymbol(String string, String symbol) {

        return string.replace(symbol, "");
    }

    public static String removeLastCharacter(String string) {

        if (string.length() <= 1) return "";
        return string.substring(0, string.length() - 2);
    }

    public static String removeLast2Characters(String string) {

        if (string.length() <= 2) return "";
        return string.substring(0, string.length() - 3);
    }
}

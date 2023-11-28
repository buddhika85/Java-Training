package utilities;

import java.text.DecimalFormat;

public class Formatter {

    private static String ThousandsTwoDecPlaces = "#,##0.00";

    public static String formatTwoDecPlaces(double value)
    {
        return new DecimalFormat(ThousandsTwoDecPlaces).format(value);
    }

    public static String format(double value, String pattern)
    {
        return new DecimalFormat(pattern).format(value);
    }
}

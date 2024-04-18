import java.text.DecimalFormat;

public class Util
{
    public static void displayLine(boolean lineBreak, String msg)
    {
        if (lineBreak)
        {
            System.out.println(msg);
        }
        else
        {
            System.out.print(msg);
        }
    }

    public static String format(double amount)
    {   
        DecimalFormat formatter = 
            new DecimalFormat("###,##0.00");
        return formatter.format(amount); 
    }
}

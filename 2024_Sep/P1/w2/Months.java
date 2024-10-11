public class Months 
{
    public static void main(String[] args) 
    {
        System.out.println("Enter a number between 1-12: ");
        int monthNumber = In.nextInt();
        String monthName = "";
        if (monthNumber == 1)
        {
            monthName = "January";
        }
        else if (monthNumber == 2)
        {
            monthName = "February";
        }
        else if (monthNumber == 3)
        {
            monthName = "March";
        }
        else if (monthNumber == 4)
        {
            monthName = "April";
        }
        else if (monthNumber == 5)
        {
            monthName = "May";
        }
        else if (monthNumber == 6)
        {
            monthName = "June";
        }
        else if (monthNumber == 7)
        {
            monthName = "July";
        }
        else if (monthNumber == 8)
        {
            monthName = "August";
        }
        else if (monthNumber == 9)
        {
            monthName = "Sepetember";
        }
        else if (monthNumber == 10)
        {
            monthName = "October";
        }
        else if (monthNumber == 11)
        {
            monthName = "November";
        }
        else if (monthNumber == 12)
        {
            monthName = "December";
        }
        else
        {
            System.out.println("Error - Invalid Input: " + monthNumber);
        }

        if (!monthName.equals(""))
        {
            System.out.println("Month Name is "+ monthName);
        }
    }
}

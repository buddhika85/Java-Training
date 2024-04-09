import java.text.DecimalFormat;
import java.util.LinkedList;

public class Bank 
{
    private LinkedList<Account> accounts = new LinkedList<>();
    private double totalInterestPaid;
    public static final int NUM_OF_DAYS_PER_YEAR = 365;
    private DecimalFormat formatter = new DecimalFormat("0.0#");

    public Bank()
    {
        setup();
        run();
    }

    private void setup() 
    {
        accounts.add(new SavingsAccount(20000));
        accounts.add(new TransactionsAccount(10000));
        accounts.add(new SavingsAccount(5000));
    }

    private void run() 
    {
       for (Account account : accounts) 
       {
            account.show();
            double interest = account.calcInterest();
            totalInterestPaid += interest;
            account.applyInterest();

            System.out.println("Interest: $" + format(interest) + "New Balance: $" 
                + format(account.getBalance()));
       }
       System.out.println("Total interest paid by Bank: $" + format(totalInterestPaid));
    }

    private String format(double value)
    {
        return formatter.format(value);
    }
}

public class TransactionsAccount extends Account
{
    public static double TRANSACTIONS_INTEREST = 0.01;

    public TransactionsAccount(double balance) 
    {
        super(balance, TRANSACTIONS_INTEREST);
    }

    @Override
    public String toString() 
    {
        return "TRANSACTIONS " + super.toString();
    }
    
}

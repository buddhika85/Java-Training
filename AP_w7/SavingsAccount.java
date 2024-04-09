public class SavingsAccount extends Account
{
    public static double SAVINGS_INTEREST = 0.06;

    public SavingsAccount(double balance) 
    {
        super(balance, SAVINGS_INTEREST);
    }

    @Override
    public String toString() 
    {
        return "SAVINGS " + super.toString();
    }
    
}

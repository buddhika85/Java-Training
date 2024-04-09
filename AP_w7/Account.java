public abstract class Account 
{
    protected double balance;
    protected double interest;

    public Account(double balance, double interest) 
    {
        this.balance = balance;
        this.interest = interest;
    }

    public double calcInterest()
    {
        return balance * interest / Bank.NUM_OF_DAYS_PER_YEAR;
    }

    public void applyInterest()
    {
        balance += calcInterest();
    }

    public double getBalance()
    {
        return balance;
    }

    public void show()
    {
        System.out.println(toString());
    }

    @Override
    public String toString() 
    {
        return "ACCOUNT Balance: $" + balance + ", interest rate:" + interest;
    }    
}

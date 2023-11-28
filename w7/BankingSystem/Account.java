package w7.BankingSystem;

import utilities.Formatter;

public abstract class Account {

    protected double balance, interest;
    protected int daysPerYear = 365;

    public Account(double balance, double interest) {
        this.balance = balance;
        this.interest = interest;
    }

    public double calcInterest()
    {
        return (balance * interest) / daysPerYear;
    }

    public void applyInterest()
    {
        balance += calcInterest();
    }

    public double getBalance()
    {
        return  balance;
    }

    public void show()
    {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return String.format("Balance: $ " + Formatter.formatTwoDecPlaces(balance) + 
            " Interest rate: " + Formatter.formatTwoDecPlaces(interest));
    }
}

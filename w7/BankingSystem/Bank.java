package w7.BankingSystem;

import java.util.LinkedList;

import utilities.Formatter;

public class Bank {

    private LinkedList<Account> accounts = new LinkedList<>();
    private double savingsAccInterest = 0.06;
    private double transactionAccInterest = 0.01;
    private double creditAccInterest = 0.13;
    private double totalInterestPaid;

    public Bank() {
        setup();
    }

    private void setup() {
        accounts.add(new SavingsAccount(20000, savingsAccInterest));
        accounts.add(new TransactionAccount(10000, transactionAccInterest));
        accounts.add(new SavingsAccount(5000, savingsAccInterest));
        accounts.add(new CreditAccount(-7000, creditAccInterest, PaymentGateway.MASTER_CARD));
    }

    public void run()
    {
        for (Account account : accounts) {
            account.show();
            double interest = account.calcInterest();
            totalInterestPaid += interest;
            account.applyInterest();
            System.out.println("Interest: $" + Formatter.formatTwoDecPlaces(interest) + " New Balance : $ " + Formatter.formatTwoDecPlaces(account.getBalance()));
        }
        System.out.println("Total interest paid by the Bank: $" + Formatter.formatTwoDecPlaces(totalInterestPaid));
    }
}

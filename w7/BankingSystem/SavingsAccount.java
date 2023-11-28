package w7.BankingSystem;

public class SavingsAccount extends Account {
    public SavingsAccount(double balance, double interest) {
        super(balance, interest);
    }

    @Override
    public String toString() {        
        return "SAVINGS_ACCOUNT " + super.toString();
    }
}

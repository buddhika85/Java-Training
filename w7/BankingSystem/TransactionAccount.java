package w7.BankingSystem;

public class TransactionAccount extends Account {
    public TransactionAccount(double balance, double interest) {
        super(balance, interest);
    }

    @Override
    public String toString() {        
        return "TRANSACTION_ACCOUNT " + super.toString();
    }
}

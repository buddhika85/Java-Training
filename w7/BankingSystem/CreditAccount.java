package w7.BankingSystem;

public class CreditAccount extends Account {
    private PaymentGateway paymentGateway;
    public CreditAccount(double balance, double interest, PaymentGateway paymentGateway) {
        super(balance, interest);
        this.paymentGateway = paymentGateway;
    }

    @Override
    public String toString() {        
        return "CREDIT_ACCOUNT " + paymentGateway + " " + super.toString();
    }
}

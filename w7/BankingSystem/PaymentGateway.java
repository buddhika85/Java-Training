package w7.BankingSystem;

public enum PaymentGateway {
    
    MASTER_CARD("Mastercard"), VISA("Visa");

    private String name;

    private PaymentGateway(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

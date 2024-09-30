public class Q5 {

}

abstract class Asset {
    private String name;
    private double unitPrice;

    public Asset(String name, double unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public abstract double calculateProfit();

    private double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double value) {
        this.unitPrice = value;
    }
}

class Gold extends Asset {
    private double weight; // Unique attribute for Gold

    public Gold(double unitPrice, double weight) {
        super("Gold", unitPrice);
        this.weight = weight;
    }

    @Override
    public double calculateProfit() {
        //return getUnitPrice() * this.weight * 0.1;
        return 0;
    }

    // Getter and setter for weight
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

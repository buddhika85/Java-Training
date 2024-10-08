public enum Model 
{
    IPHONE_15_PRO("iPhone 15 Pro", 1500),
    IPHONE_15_PRO_MAX("iPhone 15 Pro Max", 1750);

    private String name;
    private double price;

    Model(String name, double price)
    {
        this.name = name;
        this.price = price;
    }
    
    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString()
    {
        return name + " - " + price;
    }
}

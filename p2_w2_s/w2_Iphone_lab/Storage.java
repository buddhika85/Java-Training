public enum Storage 
{
    ONE_TWO_EIGHT("128GB", 0),
    TWO_FIVE_SIX("256GB", 100),
    FIVE_TWELVE("512GB", 250),
    ONE_TB("1TB", 400);

    private String name;
    private double price;

    Storage(String name, double price)
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
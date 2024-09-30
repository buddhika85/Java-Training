package iPhone;

public enum Storage 
{
    ONE_TWO_EIGHT("128 GB", 0),
    TWO_FIVE_SIX("256 GB", 100),
    FIVE_TWELVE("512 GB", 250),
    ONE_TB("1 TB", 400);



    private String description;   
    private double price;

    private Storage(String description, double price)
    {
        this.description = description;
        this.price = price;
    }

    public double getPrice()
    {
        return price;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public String toString()
    {
        return description + " => " + price;
    }
}

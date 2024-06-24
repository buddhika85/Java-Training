public enum Topping 
{
    CHICKEN("Chicken", 100),
    CHEESE("Cheese", 50),
    SAUSAGE("Sausage", 50),
    BACON("Bacon", 60),
    MUSHROOMS("Mushrooms", 100),
    CHILLIE("Chillie", 50),
    BEEF("Beef", 120);

    private String name;
    private double price;

    private Topping(String name, double price)
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
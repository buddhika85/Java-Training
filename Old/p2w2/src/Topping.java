public enum Topping
{
    CHICKEN("Chicken", 100),
    CHEESE("Cheese", 50),
    SAUSAGE("Sausage", 50),
    BACON("Bacon", 60),
    MUSHROOMS("Mushrooms", 100),
    CHILLIE("Chillie", 50),
    BEEF("Beef", 120);

    private String description;
    private double price;

    private Topping(String description, double price) 
    {
        this.description =description;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
   
    @Override
    public String toString()
    {
        return "Topping " + description + "=>" + price;
    }
}

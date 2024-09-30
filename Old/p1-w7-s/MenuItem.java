import java.util.ArrayList;

public class MenuItem 
{
    protected String name;
    protected String category;
    protected double price;

    public MenuItem(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public String getCategory() {
        return category;
    }
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() 
    {
        return name + ", category=" + category + ", price=" + price;
    }    
}

class BeefMenuItem extends MenuItem
{
    public BeefMenuItem(String name, double price) 
    {
        super(name, "Beef", price);
    }    
}


class ChickenMenuItem extends MenuItem
{
    public ChickenMenuItem(String name, double price) 
    {
        super(name, "Chicken", price);
    }    
}


class BeefBurger extends BeefMenuItem
{
    private boolean extraSpicy;

    public BeefBurger(double price, boolean extraSpicy) 
    {
        super("Beef Burger", price);
        this.extraSpicy = extraSpicy;
    }

    @Override
    public String toString() {
        return super.toString() + " extraSpicy=" + extraSpicy;
    }
}

class ChickenNuggets extends ChickenMenuItem
{
    private boolean withSalt;

    public ChickenNuggets(double price, boolean withSalt) 
    {
        super("Chicken Nuggets", price);
        this.withSalt = withSalt;
    }

    @Override
    public String toString() {
        return super.toString() + " withSalt=" + withSalt;
    }
}

class Test
{
    public static void main(String[] args) 
    {
        ArrayList<MenuItem> items = new ArrayList<>();
        items.add(new BeefBurger(10, false));
        items.add(new BeefBurger(12, true));
        items.add(new ChickenNuggets(5, false));
        items.add(new ChickenNuggets(6, true));
        for (MenuItem menuItem : items) 
        {
            System.out.println(menuItem);
        }
    }
}
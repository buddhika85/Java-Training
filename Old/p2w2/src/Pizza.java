import java.util.ArrayList;

public class Pizza 
{
    private final double BASE_PRICE;
    private final Topping[] INCLUDED_TOPPINGS;
    private ArrayList<Topping> extraToppings;
    private double priceDiscount;
    private double discountRate;

    public Pizza(double basePrice, Topping[] includedToppings)
    {
        BASE_PRICE = basePrice;
        INCLUDED_TOPPINGS = includedToppings;
        extraToppings = new ArrayList<>();
    }

    public void addTopping(Topping topping)
    {
        extraToppings.add(topping);
    }

    public double calculatePrice()
    {
        var price = BASE_PRICE + extraToppingsPrice();
        if (discountRate > 0)
        {
            price -= price * discountRate;
        }

        price -= priceDiscount;
        return price;
    }

    private double extraToppingsPrice()
    {
        var sum = 0.0;
        for (Topping topping : extraToppings) {
            sum += topping.getPrice();
        }
        return sum;
    }

    // an argument of 0.1 means a 10% discount.
    public void applyDiscountRate(double discountRate)
    {
        this.discountRate = discountRate;
    }

    // an argument of 2.2 means a $2.2 discount.
    public void applyDiscount(double priceDiscount)
    {
        this.priceDiscount = priceDiscount;
    }
}

import java.util.ArrayList;
import java.util.Arrays;

public class Pizza 
{
    private PizzaType pizzaType;
    private final double BASE_PRICE;
    private final Topping[] includedToppings;
    private ArrayList<Topping> extraToppings = new ArrayList<>();
    private double discount;   

    public Pizza(PizzaType pizzaType) 
    {
        this.pizzaType = pizzaType;
        includedToppings = new Topping[1];
        if (pizzaType == PizzaType.CHICKEN)
        {
            includedToppings[0] = Topping.CHICKEN;
            BASE_PRICE = 1000;
        }
        else if (pizzaType == PizzaType.BEEF)
        {
            includedToppings[0] = Topping.BEEF;
            BASE_PRICE = 1100;
        }
        else 
        {
            includedToppings[0] = Topping.MUSHROOMS;
            BASE_PRICE = 1200;
        }
    }

    public void addTopping(Topping topping)
    {
        extraToppings.add(topping);
    }

    public double calculatePrice()
    {
        return BASE_PRICE + extraToppingsPrice() - discount;
    }

    private double extraToppingsPrice() 
    {
       double total = 0.0;
       for (Topping topping : extraToppings) 
       {
            total += topping.getPrice(); 
       }
       return total;
    }

    // argument of 0.1 means a 10% discount.
    public void applyDiscountRate(double discountRate)
    {
        discount = 0;       // need to set discount to 0, before applying it
        discount = calculatePrice() * discountRate;
    }

    public void applyDiscount(double priceDiscount)
    {
        discount = priceDiscount;
    }

    @Override
    public String toString() {
        return pizzaType + " Pizza \n[BASE_PRICE=" + BASE_PRICE + ", includedToppings=" + Arrays.toString(includedToppings)
                + ", extraToppings=" + extraToppings + ", discount=" + discount + 
                "\n\tPrice => " + calculatePrice() + "]";
    }   
}
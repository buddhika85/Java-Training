public class PizzaMenu 
{
    private Pizza pizza;      

    void runMainMenu() 
    {        
        pizza = new Pizza(PizzaType.CHICKEN);   // default selection
        System.out.println("\n--- Pizza menu ---\n");
        System.out.println("Your current selection is : " + pizza);

        while (true)
        {
            System.out.println("Select an option:");
            System.out.println("  1. Change Pizza Type");
            System.out.println("  2. Add Topping");
            System.out.println("  3. Exit");
            int choice = In.nextInt();
            if (choice == 1) 
            {
                changeType();
            } 
            else if (choice == 2) 
            {
                addTopping();
            } 
            else if (choice == 3) 
            {
                break;
            } 
            else 
            {
                System.out.println("Pick an option 1, 2 or 3");
            }
        }

        System.out.println("Your current selection is : " + pizza);
        System.out.println("Exiting...");
    }

    private void changeType() 
    {
        System.out.println("------- change type");
        displayTypes();
        pizza = new Pizza(findType(In.nextInt()));        
        System.out.println("Your current selection is : " + pizza);
    }

    private void addTopping() 
    {
        System.out.println("------- add topping");
        displayToppings();
        pizza.addTopping(findTopping(In.nextInt()));        
        System.out.println("Your current selection is : " + pizza);
    }

    private void displayTypes() 
    {
        PizzaType[] types = PizzaType.values();
        for (int i = 0; i < types.length; i++) 
        {
            System.out.println("\t" + (i + 1) + ".  " + types[i]);
        }
    }

    private void displayToppings() 
    {
        Topping[] types = Topping.values();
        for (int i = 0; i < types.length; i++) 
        {
            System.out.println("\t" + (i + 1) + ".  " + types[i]);
        }
    }


    private PizzaType findType(int typeInt) 
    {        
        if (typeInt == 2)
            return PizzaType.BEEF;
        if (typeInt == 3)
            return PizzaType.MUSHROOM;
        return PizzaType.CHICKEN;
    }

    private Topping findTopping(int num) 
    {
        if (num == 2)
            return Topping.CHEESE;
        if (num == 3)
            return Topping.SAUSAGE;
        if (num == 4)
            return Topping.BACON;
        if (num == 4)
            return Topping.MUSHROOMS;
        if (num == 4)
            return Topping.CHILLIE;
        return Topping.CHICKEN;
    }
}

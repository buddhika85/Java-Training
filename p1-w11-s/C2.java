import java.util.HashMap;

public class C2 {
    public static void main(String[] args) 
    {
        // for (int i = 30; i <= 80; i += 10)
        // {
        //     System.out.println(i);
        // }

        // C3
        // System.out.println("Choose either 3 or 4:");
        // int input = In.nextInt();
        // if (input == 3)
        //     System.out.println("Thirsty 3rd");
        // else if (input == 4)
        //     System.out.println("Famished 4th");
        // else
        //     System.out.println("Hmmm");

        // C5
        // int[] numbers = {4,5,6};
        // for(int num : numbers)
        // {
        //     System.out.println(num);
        // }

        // // C6
        // for (int i = 0; i < numbers.length; i++)
        // {
        //     System.out.println(numbers[i]);
        // }

        BubbleTea bubbleTea = new BubbleTea("Bubble Tea");
        bubbleTea.addTopping("test 1", 10);
        bubbleTea.addTopping("test 2", 20);
        bubbleTea.display();
    }
}


class BubbleTea
{
	private String name;
	private HashMap<String, Integer> toppings = new HashMap<>();
	
	public BubbleTea(String name) {
        this.name = name;
    }

    public void addTopping(String toppingName, int quantity)
	{
		toppings.put(toppingName, quantity);
	}    

    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "BubbleTea [name=" + name + ", toppings=" + toppings + "]";
    }
}
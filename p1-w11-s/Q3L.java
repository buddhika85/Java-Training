import java.util.*;

class SportsInventory {
    private HashMap<String, Integer> inventory;

    public SportsInventory() {
        inventory = new HashMap<>();
    }

    public void addStock(String brand, int quantity) {
        if (inventory.containsKey(brand)) {
            int currentStock = inventory.get(brand);
            inventory.put(brand, currentStock + quantity);
        } else {
            inventory.put(brand, quantity);
        }
    }

    public void removeStock(String brand, int quantity) {
        if (inventory.containsKey(brand)) {
            int currentStock = inventory.get(brand);
            if (currentStock >= quantity) {
                inventory.put(brand, currentStock - quantity);
            } else {
                System.out.println("Insufficient stock.");
            }
        } else {
            System.out.println("Brand not found in inventory.");
        }
    }

    public void display() {
        for (String brand : inventory.keySet()) {
            int stock = inventory.get(brand);
            System.out.println(brand + ": " + stock);
        }
    }
}

public class Q3L {
    public static void main(String[] args) {
        SportsInventory inventory = new SportsInventory();
        inventory.addStock("Nike", 20);
        inventory.addStock("Adidas", 15);
        System.out.println("How many Nike items would you like to buy?");
        int nikePurchase = In.nextInt();
        System.out.println("How many Adidas items would you like to buy?");
        int adidasPurchase = In.nextInt();
        inventory.removeStock("Nike", nikePurchase);
        inventory.removeStock("Adidas", adidasPurchase);
        inventory.addStock("Nike", 20);
        inventory.addStock("Adidas", 15);
        inventory.display();

    }
}
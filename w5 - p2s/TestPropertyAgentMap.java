import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TestPropertyAgentMap 
{
    public static void main(String[] args) 
    {
        Property p1 = new Property(PropertyType.HOUSE, 500000.00, 5000, 4, 2);
        Property p2 = new Property(PropertyType.APARTMENT, 150000.00, 100, 2, 1);
        Property p3 = new Property(PropertyType.HOUSE, 200000.00, 200, 3, 2);
        Property p4 = new Property(PropertyType.APARTMENT, 500000.00, 1000, 5, 3);
        Property p5 = new Property(PropertyType.APARTMENT, 120000.00, 300, 3, 1);

        AgentInventory agentInventory = new AgentInventory();
        agentInventory.addForRent(p1);
        agentInventory.addForRent(p2);
        agentInventory.addForRent(p3);
        agentInventory.addForRent(p4);
        agentInventory.addForRent(p5);

        System.out.println("\nBefore sorting");
        for (Property property : agentInventory.forRent) 
        {
            System.out.println(property);
        }

        agentInventory.sortPropertiesForRent();
        System.out.println("\nAfter sorting");
        for (Property property : agentInventory.forRent) 
        {
            System.out.println(property);
        }
    }
}

enum Transaction { SALE, RENT }

class AgentInventoryWithMaps 
{
    Map<Transaction, List<Property>> inventory;
    
    public AgentInventoryWithMaps() 
    {
        this.inventory = new HashMap<>();
        this.inventory.put(Transaction.SALE, new ArrayList<>());
        this.inventory.put(Transaction.RENT, new LinkedList<>());
    }

    public void addForSale(Property p)
    {
        List<Property> forSaleList = inventory.get(Transaction.SALE);
        forSaleList.add(p);
    }

    public void addForRent(Property p)
    {
        List<Property> forRentList = inventory.get(Transaction.RENT);
        forRentList.add(p);
    }

    public void sortPropertiesForRent()
    {
        // sorts the forRent attribute by price, then by number of bedrooms, both in ascending order
        Comparator<Property> comparator = Comparator.comparing(Property :: getPrice)
            .thenComparing(Property :: getNumOfRooms);
        Collections.sort(inventory.get(Transaction.RENT), comparator);
    }

    public void sortPropertiesForSale()
    {
        // use descending order, first by price, then by land size, then by number of bedrooms.
        Comparator<Property> comparator = Comparator.comparing(Property :: getPrice).reversed()
            .thenComparing(Property :: getLandSize).reversed()
            .thenComparing(Property :: getNumOfRooms).reversed();
        Collections.sort(inventory.get(Transaction.SALE), comparator);
    }
}


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AgentInventory 
{
    // private List<Property> forSale;
    // private List<Property> forRent;

    private Map<Transaction, List<Property>> inventory = 
        new HashMap<Transaction, List<Property>>();

    public AgentInventory() 
    {
        // forSale = new ArrayList<>();
        // forRent = new LinkedList<>();
        inventory.put(Transaction.SALE, new ArrayList<>());
        inventory.put(Transaction.RENT, new LinkedList<>());
    }

    public void addForSale(Property p)
    {
        // forSale.add(p);
        inventory.get(Transaction.SALE).add(p);
    }

    public void addForRent(Property p)
    {
        // forRent.add(p);
        inventory.get(Transaction.RENT).add(p);
    }

    public List<Property> getPropertiesForRent()
    {
        Comparator<Property> propertyComparator = Comparator.comparing(Property::getPrice).thenComparing(Property::getNumOfRooms);
        // Collections.sort(forRent, propertyComparator);
        // return forRent;

        Collections.sort(inventory.get(Transaction.RENT), propertyComparator);
        return inventory.get(Transaction.RENT);
    }

    public List<Property> getPropertiesForSale()
    {
        Comparator<Property> propertyComparator = Comparator.comparing(Property::getPrice).reversed()
            .thenComparing(Property::getLandSize).reversed()
            .thenComparing(Property::getNumOfBathRooms).reversed();
        // Collections.sort(forSale, propertyComparator);
        // return forSale;

        Collections.sort(inventory.get(Transaction.SALE), propertyComparator);
        return inventory.get(Transaction.SALE);
    }
}

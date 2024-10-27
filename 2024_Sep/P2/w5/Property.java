import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

enum PropertyType 
{
    APARTMENT,
    HOUSE;
}

public class Property 
{
    private PropertyType propertyType;
    private double price;
    private double landSize;
    private int numOfRooms;
    private int numOfBathRooms;
    
    // orders properties by price ASC
    public static final Comparator<Property> ORDER_BY_PRICE = Comparator.comparing(Property :: getPrice);

    public Property(PropertyType propertyType, double price, double landSize, int numOfRooms, int numOfBathRooms) {
        this.propertyType = propertyType;
        this.price = price;
        this.landSize = landSize;
        this.numOfRooms = numOfRooms;
        this.numOfBathRooms = numOfBathRooms;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public double getPrice() {
        return price;
    }

    public double getLandSize() {
        return landSize;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public int getNumOfBathRooms() {
        return numOfBathRooms;
    }

    @Override
    public String toString() {
        return "Property [Type=" + propertyType + ", price=" + price + ", landSize=" + landSize
                + ", numOfRooms=" + numOfRooms + ", numOfBathRooms=" + numOfBathRooms + "]";
    }

    
}


class TestProperty
{
    public static void main(String[] args) {
        List<Property> properties = new ArrayList<>();
        Property p1 = new Property(PropertyType.HOUSE, 300000.00, 500, 4, 2);
        Property p2 = new Property(PropertyType.APARTMENT, 150000.00, 100, 2, 1);
        Property p3 = new Property(PropertyType.HOUSE, 200000.00, 200, 3, 2);
        Property p4 = new Property(PropertyType.APARTMENT, 500000.00, 1000, 5, 3);
        Property p5 = new Property(PropertyType.APARTMENT, 120000.00, 300, 3, 1);
        properties.add(p1);
        properties.add(p2);
        properties.add(p3);
        properties.add(p4);
        properties.add(p5);

        for (Property property : properties) 
        {
            System.out.println(property);    
        }

        System.out.println("\nAfter sorting ASC");
        Collections.sort(properties, Property.ORDER_BY_PRICE);

        for (Property property : properties) 
        {
            System.out.println(property);    
        }
    }
}


class AgentInventory 
{
    List<Property> forSale;
    List<Property> forRent;

    public AgentInventory() 
    {
        this.forSale = new ArrayList<>();
        this.forRent = new LinkedList<>();
    }

    void addForSale(Property p)
    {
        forSale.add(p);
    }

    void addForRent(Property p)
    {
        forRent.add(p);
    }

    void sortPropertiesForRent()
    {
        //  sorts the forRent attribute by price, 
        // then by number of bedrooms, both in ascending order. Note: create a local variable
        Comparator<Property> comparator = Comparator.comparing(Property::getPrice).thenComparing(Property::getNumOfRooms);
        Collections.sort(forRent, comparator);
    }

    void sortPropertiesForSale()
    {
        // descending order, first by price, then by land size, then by number of bedrooms.
        Comparator<Property> comparator = Comparator.comparing(Property::getPrice).thenComparing(Property::getLandSize).thenComparing(Property::getNumOfRooms).reversed();
        Collections.sort(forSale, comparator);
    }
}


class AgentInventoryMap
{
    Map<Transaction, List<Property>> inventory;

    public AgentInventoryMap() 
    {
        this.inventory.put(Transaction.SALE, new ArrayList<>());
        this.inventory.put(Transaction.RENT, new LinkedList<>());
    }

    void addForSale(Property p)
    {
        this.inventory.get(Transaction.SALE).add(p);
    }

    void addForRent(Property p)
    {
        this.inventory.get(Transaction.RENT).add(p);
    }

    void sortPropertiesForRent()
    {
        //  sorts the forRent attribute by price, 
        // then by number of bedrooms, both in ascending order. Note: create a local variable
        Comparator<Property> comparator = Comparator.comparing(Property::getPrice).thenComparing(Property::getNumOfRooms);
        Collections.sort(this.inventory.get(Transaction.RENT), comparator);
    }

    void sortPropertiesForSale()
    {
        // descending order, first by price, then by land size, then by number of bedrooms.
        Comparator<Property> comparator = Comparator.comparing(Property::getPrice).reversed()
            .thenComparing(Property::getLandSize).reversed()
            .thenComparing(Property::getNumOfRooms).reversed();
        Collections.sort(this.inventory.get(Transaction.SALE), comparator);
    }
}

enum Transaction { SALE, RENT }

class TestPropertyAgent
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

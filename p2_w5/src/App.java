import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception
    {
        //testBinarySearch();
        //testProperty();
        testAgentInvetory();
    }

    private static void testAgentInvetory() 
    {
        Property[] data = { 
            new Property(PropertyType.APARTMENT, 800, 200, 4, 3),
            new Property(PropertyType.HOUSE, 1200, 400, 5, 5),

            new Property(PropertyType.APARTMENT, 800, 200, 4, 3),
            new Property(PropertyType.HOUSE, 1400, 400, 7, 5),

            new Property(PropertyType.APARTMENT, 900, 200, 4, 3),
            new Property(PropertyType.HOUSE, 1000, 300, 6, 5),
        };
        AgentInventory agentInventory = new AgentInventory();
        agentInventory.addForRent(data[0]);
        agentInventory.addForRent(data[1]);
        agentInventory.addForRent(data[2]);        
        agentInventory.addForSale(data[3]);
        agentInventory.addForSale(data[4]);
        agentInventory.addForSale(data[5]);

        List<Property> propertiesForRent = agentInventory.getPropertiesForRent();
        System.out.println("\nProperties For Rent - Price, Num of Rooms");
        displayAll(propertiesForRent);

        List<Property> propertiesForSale = agentInventory.getPropertiesForSale();
        System.out.println("\nProperties For Sale - Sorted");
        displayAll(propertiesForSale);
    }

    private static void testProperty() 
    {
        Property[] data = { 
            new Property(PropertyType.APARTMENT, 800, 200, 4, 3),
            new Property(PropertyType.HOUSE, 1200, 400, 6, 5),

            new Property(PropertyType.APARTMENT, 800, 200, 4, 3),
            new Property(PropertyType.HOUSE, 1400, 400, 7, 5),

            new Property(PropertyType.APARTMENT, 900, 200, 4, 3),
            new Property(PropertyType.HOUSE, 1000, 300, 6, 5),
        };
        ArrayList<Property> properties = new ArrayList<>(Arrays.asList(data));
        System.out.println("Original");
        displayAll(properties);

        Collections.sort(properties, Property.PRICE_COMPARATOR_ASC);
        System.out.println("\nSort By Price - low to high");
        displayAll(properties);

        Collections.sort(properties, Property.PRICE_COMPARATOR_DESC);
        System.out.println("\nSort By Price - high to low");
        displayAll(properties);
    }

    private static void displayAll(List<Property> properties) 
    {
        for (Property property : properties) 
        {
            System.out.println("\t" + property);
        }
    }

    private static void testBinarySearch() {
        Integer[] ints = { 1, 3, 5, 6, 10, 200, 271, 340, 2000, 10000 };
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(ints));

        int value = 271;
        System.out.println(arrayList);
        int index = Collections.binarySearch(arrayList, value);
        System.out.println(value + " is at index " + index);
    }
}

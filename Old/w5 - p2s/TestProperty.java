import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Property 
{
    private PropertyType propertyType;
    private double price;
    private double landSize;
    private int numOfRooms;
    private int numOfBarthRooms;

    // orders properties by price ASC
    public static final Comparator<Property> COMPARATOR_PRICE_ASC 
        = Comparator.comparing(Property:: getPrice);

    public static final Comparator<Property> COMPARATOR_PRICE_DESC 
        = Comparator.comparing(Property:: getPrice).reversed();

    public Property(PropertyType propertyType, double price, double landSize, int numOfRooms, int numOfBarthRooms) 
    {
        this.propertyType = propertyType;
        this.price = price;
        this.landSize = landSize;
        this.numOfRooms = numOfRooms;
        this.numOfBarthRooms = numOfBarthRooms;
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

    public int getNumOfBarthRooms() {
        return numOfBarthRooms;
    }

    @Override
    public String toString() {
        return "Property - Type=" + propertyType + ", price=" + price + ", landSize=" + landSize
                + ", numOfRooms=" + numOfRooms + ", numOfBarthRooms=" + numOfBarthRooms;
    }    
}

enum PropertyType 
{
    APARTMENT, HOUSE;
}

public class TestProperty
{
    public static void main(String[] args) 
    {
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
        Collections.sort(properties, Property.COMPARATOR_PRICE_ASC);
        for (Property property : properties) 
        {
            System.out.println(property);    
        }

        System.out.println("\nAfter sorting DESC");
        Collections.sort(properties, Property.COMPARATOR_PRICE_DESC);
        for (Property property : properties) 
        {
            System.out.println(property);    
        }
    }
}

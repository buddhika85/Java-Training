import java.util.Comparator;

public class Property 
{
    private PropertyType propertyType;
    private double price;
    private double landSize;
    private int numOfRooms;
    private int numOfBathRooms;

    public static final Comparator<Property> PRICE_COMPARATOR_ASC = Comparator.comparing(Property::getPrice);
    public static final Comparator<Property> PRICE_COMPARATOR_DESC = Comparator.comparing(Property::getPrice).reversed();
    
    public Property(PropertyType propertyType, double price, double landSize, int numOfRooms, int numOfBathRooms) 
    {
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
    public String toString() 
    {
        return "Property [Type=" + propertyType + ", price=" + price + ", landSize=" + landSize
                + ", numOfRooms=" + numOfRooms + ", numOfBathRooms=" + numOfBathRooms + "]";
    }

    
}

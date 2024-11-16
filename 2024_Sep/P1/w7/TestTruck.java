public class TestTruck 
{
    public static void main(String[] args) 
    {
        
    }    
}

class Truck
{
    protected double fuelEfficiency;
    protected double fuelCapacity;

    public Truck(double fuelEfficiency, double fuelCapacity) {
        this.fuelEfficiency = fuelEfficiency;
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public String toString() {
        return "fuelEfficiency = " + fuelEfficiency + 
            ", fuelCapacity = " + fuelCapacity;
    }

    // boolean canMakeDelivery(double deliveryDistance)
    // {
        
    // }
}

class OldTruck extends Truck
{
    public OldTruck() 
    {
        super(7.2, 80);
    }    
}

class NewTruck extends Truck
{
    public NewTruck()
    {
        super(11.3, 100);
    }
}
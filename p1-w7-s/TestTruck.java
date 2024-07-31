import java.util.ArrayList;

public class TestTruck 
{
    public static void main(String[] args) 
    {
        ArrayList<NewTruck> newTrucks = new ArrayList<>();
        ArrayList<OldTruck> oldTrucks = new ArrayList<>();
        newTrucks.add(new NewTruck(1));
        newTrucks.add(new NewTruck(0.8));

        for (NewTruck newTruck : newTrucks) {
            newTruck.makeDelivery(10);
        }
    }    
}

class Truck
{
    protected double fuelEfficiency;
    protected double fuelCapacity;
    protected double fuelRemaning;

    public Truck(double fuelEfficiency, double fuelCapacity, double fuelRemaning) {
        this.fuelEfficiency = fuelEfficiency;
        this.fuelCapacity = fuelCapacity;
        this.fuelRemaning = fuelRemaning;
    }

    @Override
    public String toString() {
        return "fuelEfficiency = " + fuelEfficiency + 
            ", fuelCapacity = " + fuelCapacity;
    }

    protected boolean canMakeDelivery(double deliveryDistance)
    {
        double litresForDistance = deliveryDistance / fuelEfficiency;
        return fuelRemaning > litresForDistance;
    }

    protected void makeDelivery(double distanceTravelled)
    {        
    }
}

class OldTruck extends Truck
{
    public OldTruck(double fuelRemaning) 
    {
        super(7.2, 80, fuelRemaning);
    }    

    @Override
    public void makeDelivery(double distanceTravelled)
    {    
        if (super.canMakeDelivery(distanceTravelled))    
        {
            super.fuelRemaning -= distanceTravelled / fuelEfficiency;
            System.out.println("Old truck completed joruney, fuel remaining " + super.fuelRemaning);
        }
        else
        {
            System.out.println("Not enough fuel in the old truck");
        }
    }
}

class NewTruck extends Truck
{
    public NewTruck(double fuelRemaning)
    {
        super(11.3, 100, fuelRemaning);
    }    

    @Override
    public void makeDelivery(double distanceTravelled)
    {    
        if (super.canMakeDelivery(distanceTravelled))    
        {
            super.fuelRemaning -= distanceTravelled / fuelEfficiency;
            System.out.println("New truck completed joruney, fuel remaining " + super.fuelRemaning);
        }
        else
        {
            System.out.println("Not enough fuel in the new truck");
        }
    }
}
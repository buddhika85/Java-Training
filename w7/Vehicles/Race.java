package w7.Vehicles;

import java.util.LinkedList;

public class Race
{
    //private Vehicle [] vehicles = new Vehicle[4];
    LinkedList<Vehicle> vehicles = new LinkedList<>();
    public Race()
    {
        vehicles.add(new Car("ABC123", "Coupe"));
        vehicles.add(new Bus("BD-1234", 75));
        vehicles.add(new Truck("ZXS443", 500));        
        vehicles.add(new Bike("HGD455", 1000));
    }
    public void display(int time)
    {
        for(Vehicle current : vehicles)
            current.display(time); 
    }
    
    
}

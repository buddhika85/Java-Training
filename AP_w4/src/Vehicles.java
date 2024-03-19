import java.util.LinkedList;

public class Vehicles 
{
    private LinkedList<Vehicle> vehicles = new LinkedList<Vehicle>();

    public Vehicles()
    {
        vehicles.add(new Car("ABC123", "Coupe"));
        vehicles.add(new Bus("BD-1234", 75));
        vehicles.add(new Truck("ZXS443", 500));
        vehicles.add(new Bike("HGD455", 1000));
        for (Vehicle vehicle : vehicles) 
        {
            vehicle.display(10);
        }
    }
}


public class Race
{
    private Vehicle [] vehicles = new Vehicle[4];
    public Race()
    {       
        vehicles[0] = new Car("ABC123", "Coupe");
        vehicles[1] = new Bus("BD-1234", 75);
        vehicles[2] = new Truck("ZXS443", 500);        
        vehicles[3] = new Bike("HGD455", 1000);
    }
    
    public void display(int time)
    {
        for(Vehicle current : vehicles)
            current.display(time); 
    }
    
    
}

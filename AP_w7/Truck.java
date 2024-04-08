public class Truck extends Vehicle
{
    private int tonnage;
    private final double FACTOR = 100.0;
    public Truck(String registration, int tonnage)
    {
      super(registration, 2, "Truck");
      this.tonnage = tonnage;
    }
    public double distance(int time)
    {
        return acceleration * tonnage/FACTOR * time;
    }
    public String toString()
    {
        return super.toString() + " and tonnage " + tonnage;
    }    
}

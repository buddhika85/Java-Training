public class Bike extends Vehicle
{
    private int capacity;
    public Bike(String registration, int capacity)
    {
      super(registration, 10, "Bike");
      this.capacity = capacity;
    }
    public double distance(int time)
    {
        return acceleration * (capacity/100.0) * time;
    }
    public String toString()
    {
        return super.toString() + " and capacity " + capacity;
    }
}
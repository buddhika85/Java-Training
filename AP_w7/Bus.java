public class Bus extends Vehicle
{
    private int passengers;
    private final double FACTOR = 100.0;
    public Bus(String registration, int passengers)
    {
      super(registration, 3, "Bus");
      this.passengers = passengers;
    }
    public double distance(int time)
    {
        return acceleration * (FACTOR/passengers) * time;
    }
    public String toString()
    {
        return super.toString() + " and the no of passengers allowed being " 
                + passengers;
    }
}
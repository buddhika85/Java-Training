public class Car extends Vehicle
{
    private String bodyType;
    private final int FACTOR = 20;
    public Car(String registration, String bodyType)
    {
      super(registration, 4, "Car");
      this.bodyType = bodyType;
    }
    public double distance(int time)
    {
        return acceleration * FACTOR * time;
    }
    public String toString()
    {
        return super.toString() + " and body type " + bodyType;
    }
}
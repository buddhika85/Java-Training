public class Car extends Vehicle
{
    public static final String NAME = "CAR";
    public static final int ACCERLERATION = 4;
    private String bodyType;

    public Car(String registration, String bodyType) 
    {
        super(registration, ACCERLERATION, NAME);
        this.bodyType = bodyType;
    }

    @Override
    public double distance(int time) 
    {
        return acceleration * 20 * time;
    }

    @Override
    public String toString() {
        return "Car " + super.toString() + " and body type " + bodyType;
    }
}

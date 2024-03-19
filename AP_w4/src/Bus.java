public class Bus extends Vehicle
{
    public static final String NAME = "Bus";
    public static final int ACCERLERATION = 3;
    private int passengers;

    public Bus(String registration, int passengers) 
    {
        super(registration, ACCERLERATION, NAME);
        this.passengers = passengers;
    }

    @Override
    public double distance(int time) 
    {
        return  acceleration * (100.0/passengers) * time;
    }

    @Override
    public String toString() {
        return "Bus " + super.toString() + " and no of passengers " + passengers;
    }
}

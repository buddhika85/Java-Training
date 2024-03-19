public class Bike extends Vehicle
{
    public static final String NAME = "Bike";
    public static final int ACCERLERATION = 10;
    private int capacity;

    public Bike(String registration, int capacity) 
    {
        super(registration, ACCERLERATION, NAME);
        this.capacity = capacity;
    }

    @Override
    public double distance(int time) 
    {
        return  acceleration * (capacity/100.0) * time;
    }

    @Override
    public String toString() {
        return "Bike " + super.toString() + " and capacity " + capacity ;
    }
}

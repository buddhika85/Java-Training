public class Truck extends Vehicle
{
    public static final String NAME = "Truck";
    public static final int ACCERLERATION = 2;
    private int tonnage;

    public Truck(String registration, int tonnage) 
    {
        super(registration, ACCERLERATION, NAME);
        this.tonnage = tonnage;
    }

    @Override
    public double distance(int time) 
    {
        return acceleration * tonnage/100 * time;
    }

    @Override
    public String toString() {
        return "Truck " + super.toString() + " and tonnage " + tonnage ;
    }
}
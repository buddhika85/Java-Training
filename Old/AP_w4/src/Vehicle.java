public abstract class Vehicle
{
    protected String registration;
    protected int acceleration;
    protected String name;

    public Vehicle(String registration, int acceleration, String name) 
    {
        this.registration = registration;
        this.acceleration = acceleration;
        this.name = name;
    }

    public abstract double distance(int time);

    public void display(int time)
    {
        System.out.println("After " + time + " seconds the " + toString() + 
            " is " + distance(time) + " meters from the starting line");
    }

    @Override
    public String toString() 
    {
        return "registration " + registration;
    }
}

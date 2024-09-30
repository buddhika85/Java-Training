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
    protected abstract double distance(int time);
    public void display(int time)
    {
        System.out.println("After " + time + " seconds the " + toString() 
            + " is " + distance(time) + " metres from the starting line");
    }
    public String toString()
    {
        return name + " with registration " + registration;
    }
}

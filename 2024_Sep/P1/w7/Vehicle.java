public class Vehicle 
{
    protected int wheelSize;
    protected int tyreThickness;
    protected String name;

    public Vehicle(int wheelSize, int tyreThickness, String name) 
    {
        this.wheelSize = wheelSize;
        this.tyreThickness = tyreThickness;
        this.name = name;
    }

    public void showDetails() {
        System.out.println("Vehicle: " + name);
        System.out.println("Wheel Size: " + wheelSize);
        System.out.println("Tyre Thickness: " + tyreThickness);
    }
}
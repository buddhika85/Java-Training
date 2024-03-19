
/**
 * class Circle example.
 */
public class Circle implements Shape  
{
    // constants
    public double PI = Math.PI;
    // instance variables 
    protected double radius;

    /**
     * Constructor for objects of class Circle
     */
    public Circle(double Radius)
    {
        // initialise instance variables
        radius = Radius;
    }

    /**
     * area - calculate the area of a Circle
     */
    @Override
    public double area()
    {
        return PI * Math.pow(radius, 2);
    }

    /**
     * perimeter - calculate the perimeter of a Circle
     */
    @Override
    public double perimeter()
    {
        return 2 * PI * radius;
    }

    /**
     * diameter - calculate the diameter of a Circle
     */
    public double diameter()
    {
        return 2 * radius;
    }
}

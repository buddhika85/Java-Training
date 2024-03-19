/**
 * class Triangle example.
 */
public class Triangle implements Shape  
{
    // constants
    final public int SIDES = 3;
    // instance variables 
    protected double sideA;
    protected double sideB;
    protected double sideC;
    protected double height;

 
    /**
     * Constructor for objects of class Triangle
     */
    public Triangle(double a, double b, double c, double h)
    {
        // initialise instance variables
        sideA = a;
        sideB = b;
        sideC = c;
        height = h;
    }

    /**
     * area - calculate the area of a Triangle
     */
    @Override
    public double area()
    {
        return 0.5*(sideB* height);
    }

    /**
     * perimeter - calculate the perimeter of a Triangle
     */
    @Override
    public double perimeter()
    {
        return sideA + sideB + sideC;
    }
}

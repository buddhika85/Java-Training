package w7;

/**
 * class Circle example.
 */
public class Circle implements Shape  
{
    // constants
    final public double PI = Math.PI;
    // instance variables 
    protected double radius;

    /**
     * Constructor for objects of class Circle
     */
    public Circle(double radius)
    {
        // initialise instance variables
        this.radius = radius;
    }
    /**
     * area - calculate the area of a Circle
     */
    public double area()
    {
        return PI * Math.pow(radius, 2);
    }
      /**
     * perimeter - calculate the perimeter of a Circle
     */
    public double perimeter()
    {
        return 2 * PI * radius;
    }

    // unique to child
    public double diameter()
    {
        return 2 * radius;
    }
}
 
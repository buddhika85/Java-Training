package w7;


/**
 * class Rectangle example.
 */
public class Rectangle implements Shape  
{
    // instance variables 
    protected double length;
    protected double width;

    /**
     * Constructor for objects of class Rectangle
     */
    public Rectangle(double length, double width)
    {
        // initialise instance variables
        this.length = length;
        this.width = width;
    }
    /**
     * area - calculate the area of a rectangle
     */
    public double area()
    {
        return length*width;
    }
     
 
/**
     * perimeter - calculate the perimeter of a rectangle
     */
    public double perimeter()
    {
        return 2*(length + width);
    }
}

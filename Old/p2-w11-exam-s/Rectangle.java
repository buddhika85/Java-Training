/**
 * class Rectangle Example.
 */
public class Rectangle implements Shape  
{
    // instance variables 
    private double length;
    private double width;

    /**
     * Constructor for objects of class Rectangle
     */
    public Rectangle(double length, double width)
    {
        // initialise instance variables
        setLength(length);
        setWidth(width);
    }

    /**
     * setLength - Sets the length variable
     */
    public void setLength(double length)
    {
        this.length = length;
    }

    /**
     * setWidth - Sets the width variable
     */
    public void setWidth(double width)
    {
        this.width = width;
    }

    /**
     * area - calculate the area of a rectangle
     */
    @Override
    public double area()
    {
        return length*width;
    }

    /**
     * perimeter - calculate the perimeter of a rectangle
     */
    @Override
    public double perimeter()
    {
        return 2*(length + width);
    }
       

    @Override
    public String toString()
    {
        return "Rectangle with Length => " + length + "Width => " + width; 
    }
}
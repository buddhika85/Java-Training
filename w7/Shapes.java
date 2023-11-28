package w7;


import java.util.LinkedList;

/**
 * class Shapes - contains a list of Shape objects
 * 
 */
public class Shapes
{
    //instance variables
    private LinkedList<Shape> shapes  = new LinkedList<Shape>();
    /**
     * Constructor for objects of class Shapes
     */
    public Shapes()
    {
        shapes.add(new Circle(10));
        shapes.add(new Rectangle(10, 5));
        shapes.add(new Triangle(3, 4, 5, 3));
    }
    /**
     * listProperties - prints the area and perimeter of each shape in the list
     * 
     */
    public void listProperties()
    {
        for(Shape current : shapes)
        {
            System.out.println("Area is:" + current.area());
            System.out.println("Perimeter is:" + current.perimeter());
            if (current instanceof Circle)
                System.out.println("Diameter is:" + 
                    ((Circle)current).diameter());         // down casting to circle
            System.out.println("\n");
        }
    }
}

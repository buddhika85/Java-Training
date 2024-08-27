import java.util.LinkedList;

public class Shapes
{
    private LinkedList<Shape> shapes = new LinkedList<Shape>();
    
    public Shapes()
    {         
        shapes.add(new Rectangle(10, 5));
        shapes.add(new Circle(10));
        displayResults();
    }
    
    private void displayResults()
    {
        for(Shape shape : shapes)
        {
            System.out.println(shape.toString());
            System.out.println("\tArea = " + shape.area());
            System.out.println("\tPerimeter = " + shape.perimeter());
            
            if (shape instanceof Circle)
            {
                System.out.println("\tDiameter = " + ((Circle)shape).diameter());
            }
            
            System.out.println("\n");
        }
    }
}
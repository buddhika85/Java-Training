import java.util.ArrayList;
import java.util.List;

public class Shapes
{
    private List<Shape> shapes = new ArrayList<Shape>();
    
    public Shapes()
    {         
        shapes.add(new Rectangle(10, 5));
        shapes.add(new Circle(10));        
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

    public static void main(String[] args) {
        new Shapes().displayResults();
    }
}
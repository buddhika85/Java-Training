public class Q4 {
    
}


abstract class Shape {
    // Abstract method to calculate the area of the shape
    public abstract double calculateArea();
    }
    
class Circle extends Shape
{
    private double radius;

    public Circle(double radius)
    {
        this.radius = radius;
    }

    @Override
    public double calculateArea()
    {
        return Math.PI * radius * radius;
    }

}
public class Q4 
{
    public static void main(String[] args) 
    {
        Shape shape = new Circle(10);
        System.out.println("Area = " + shape.calculateArea());
    }    
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
        // automatic super() call added by Java Compiler
        // super();
        this.radius = radius;
    }
    
    public double calculateArea()
    {
        return Math.PI * radius * radius;
    }
}
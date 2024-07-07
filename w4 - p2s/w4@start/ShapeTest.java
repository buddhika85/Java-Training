import java.util.ArrayList;

public class ShapeTest {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(10));
        shapes.add(new Rectangle(10, 5));

        for (Shape shape : shapes) {
            System.out.println("Area: " + shape.area() + 
                ", Perimeter: " + shape.perimeter());
        }
    }
}


interface Shape 
{
    double area();
    double perimeter();
}

class Circle implements Shape
{

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

}

class Rectangle implements Shape
{
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double area() {
        return width * width;
    }

    @Override
    public double perimeter() {
        return 2 * (height * width);
    }
}
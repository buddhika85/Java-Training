public class TestShapes {
    public static void main(String[] args) 
    {
        UserInput userInput = new UserInput();
        Rectangle rect1 = new Rectangle("Rect 1", 
            userInput.getInt("Width of Rectangle? "), 
            userInput.getInt("Height of Rectangle? "));
        System.out.println(rect1.getArea());
        System.out.println(rect1.getPerimeter());

        Hexagon hex1 = new Hexagon("Hex 1", 10);
        System.out.println(hex1.getArea());
        System.out.println(hex1.getPerimeter());

        Square sq1 = new Square("SQ1", 8);
        System.out.println(sq1.getArea());
        System.out.println(sq1.getPerimeter());
    }
}

class Shape /*extends Object*/
{
    String name;

    Shape(String name) {
        this.name = name;
    }

    double getPerimeter() {
        // we have no information about the shape, so let's just return zero here.
        return 0;
    }

    double getArea() {
        // Similarly, we return zero here.
        return 0;
    }
}

class Rectangle extends Shape
{
    // attributes unique to rectangle
    private double width;
    private double height;

    public Rectangle(String name, double width, double height)
    {
        super(name);
        this.width = width;
        this.height = height;
    }

    @Override
    double getPerimeter() 
    {
        return (this.width + this.height) * 2;
    }

    @Override
    double getArea() 
    {
        return this.height * this.width;
    }
}

class Hexagon extends Shape 
{
    private double side;

    public Hexagon(String name, double side)
    {
        super(name);
        this.side = side;
    }

    @Override
    double getPerimeter()
    {
        return 6 * side;
    }

    @Override
    double getArea()
    {
        return ((3 * Math.sqrt(3)) / 2) * side * side; 
    }
}

class Square extends Rectangle
{
    public Square(String name, double side)
    {
        super(name, side, side);
    }
}
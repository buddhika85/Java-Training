import java.util.HashMap;
import java.util.Map;

public class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) 
    {
        HashMap<Integer, Point> pointsMap = new HashMap<>();
        Point pointOne = new Point(10, 20);
        Point pointTwo = new Point(1, 2);
        pointsMap.put(1, pointOne);
        pointsMap.put(2, pointTwo);
        
        System.out.println(pointsMap);
        // display
        for (Map.Entry<Integer, Point> entry : pointsMap.entrySet()) {
            System.out.println("Key is " + entry.getKey() + " and the value is " + entry.getValue());
        }
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }
}

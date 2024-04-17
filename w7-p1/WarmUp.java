import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class WarmUp 
{
    public static void main(String[] args) 
    {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <= 10; i++) 
        {
            numbers.add(i);
        }
        System.out.println(numbers);
        ArrayList<Integer> hundreads = new ArrayList<>(Arrays.asList(100, 200, 300, 400));
        System.out.println(hundreads);

        HashMap<Integer, Point> points = new HashMap<>();
        points.put(0, new Point(0, 0));
        points.put(1, new Point(1, 1));
        System.out.println(points);
    }    
}


class Point
{
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }
}
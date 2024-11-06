import java.util.ArrayList;
import java.util.Arrays;

public class Warmup 
{
    public static void main(String[] args) {
        // 1
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            arrayList.add(i);
        }
        System.out.println(arrayList);

        // 2 
        ArrayList<Integer> hundreds = new ArrayList<>(Arrays.asList(100, 200, 300, 400));
        for (int num : hundreds) {
            System.out.println(num);
        }

        

    }    
}

// 3.1
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

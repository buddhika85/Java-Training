import java.util.ArrayList;

public class Q3 {
    public static void main(String[] args) {
        ArrayList<Integer> values = new ArrayList<>();
        values.add(2);
        values.add(5);
        values.add(9);
        values.add(7);
        int n = -100;
        for (int i : values) {
            if (i > n) {
                n = i;
            }
        }
        System.out.println(n);
    }
}

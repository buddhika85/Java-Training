import java.util.ArrayList;
import java.util.Arrays;

public class Warmup
{
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        System.out.println(numbers);

        for (int i = 0; i <= 10; i++) {
            numbers.add(i);
        }
        System.out.println(numbers);
       
        ArrayList<Integer> hundredsList = new ArrayList<>(Arrays.asList(100, 200, 300, 400));
        System.out.println(hundredsList);
    }
}
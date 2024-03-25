import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception
    {
        testBinarySearch();
    }

    private static void testBinarySearch() {
        Integer[] ints = { 1, 3, 5, 6, 10, 200, 271, 340, 2000, 10000 };
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(ints));

        int value = 271;
        System.out.println(arrayList);
        int index = Collections.binarySearch(arrayList, value);
        System.out.println(value + " is at index " + index);
    }
}

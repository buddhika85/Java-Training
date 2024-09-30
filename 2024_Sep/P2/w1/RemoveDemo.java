import java.util.ArrayList;

public class RemoveDemo 
{
    public static void main(String[] args) 
    {
        ArrayList<String> strs = new ArrayList<>();
        strs.add("a");
        strs.add("a");
        strs.add("b");
        show(strs);

        // demoForwardRemove(strs, "a");
        // show(strs);

        demoReverseRemove(strs, "a");
        show(strs);
    }

    private static void show(ArrayList<String> strs) 
    {
        for (String str : strs) {
            System.out.print(str + " , ");
        }
        System.out.println("\n");
    }

    private static void demoReverseRemove(ArrayList<String> strs, String toRemove) 
    {
        for (int i = strs.size() - 1; i >= 0; i--) 
        {
            if (strs.get(i).equals(toRemove))
            {
                strs.remove(strs.get(i));
            }
        }
    }

    private static void demoForwardRemove(ArrayList<String> strs, String toRemove) 
    {
        // For Each - java.util.ConcurrentModificationException
        for (int i = 0; i < strs.size(); i++) 
        {
            if (strs.get(i).equals(toRemove))
            {
                strs.remove(strs.get(i));
            }
        }
    }
}

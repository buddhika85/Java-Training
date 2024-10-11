public class StringComparison {
    public static void main(String[] args) 
    {
        String a = "ABC";
        String b = "abc";
        System.out.println(a.equals(b));
        System.out.println(a.equalsIgnoreCase(b));    


        String c = "ABC";
        System.out.println(a.equals(c));
        System.out.println(a.equalsIgnoreCase(c));   
    }
}

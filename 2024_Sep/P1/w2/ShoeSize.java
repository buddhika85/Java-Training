public class ShoeSize {

    // < 22 cm	Woman's 4 or less
    // 22cm to 23cm	Women's 5 to 7
    // 23cm to 25.1cm	Women's 8 to 10
    // > 25.1 cm	Women's 10 +
    public static void main(String[] args) {

        System.out.println("Please provide foot length in CM: ");
        double size = In.nextDouble();
        
        System.out.println();               // optional - to make output clearer
        if (size < 22)
        {
            System.out.println("Your shoe size is - Woman's 4 or less");
        }
        else if (size >= 22 && size < 23)
        {
            System.out.println("Your shoe size is - Women's 5 to 7");
        }
        else if (size >= 23 && size <= 25.1)
        {
            System.out.println("Your shoe size is - Women's 8 to 10");
        }
        else
        {
            System.out.println("Your shoe size is - Women's 10 +");
        }
    }
}

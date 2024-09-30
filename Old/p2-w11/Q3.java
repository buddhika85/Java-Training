public class Q3 
{
    public static void main(String[] args) 
    {
        int phone = -1;		// -1 indicates unknown
        while(true)
        {
            System.out.println("Please select a Phone [1 for IPHONE, 2 for SAMSUNG and 3 for MOTOROLA]");
            phone = In.nextInt();
            if (phone <= 3 && phone >= 1)
                break;
        }
        
        if (phone == 1)
            System.out.println("IPHONE selected");
        else if (phone == 2)
            System.out.println("SAMSUNG selected");
        else
            System.out.println("MOTOROLA selected");
    }    
}

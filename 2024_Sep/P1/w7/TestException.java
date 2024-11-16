import java.util.InputMismatchException;

class TestException {
    public static void main(String[] args) 
    {
        // try
        // {
        //     System.out.println("Enter a number: ");
        //     int number = In.nextInt();
        //     System.out.println("You've entered " + number);
        // }
        // catch(InputMismatchException e)
        // {
        //     System.out.println("Error - you need to input a number...");
        // }
        

        int number;
        while (true) {
            try {
                System.out.print("Enter an integer: ");
                number = In.nextInt();
                break; // Exit the loop if the input is successfully converted to an integer
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer!");
                // Need the line below otherwise we'll have an infinite loop. It's due to an
                // annoying feature of Java when reading in integers: if we didn't enter
                // an integer on line 10 above, an exception is thrown but Java DOES NOT
                // process the character associated with pressing the ENTER key.
                //
                // The following line consumes and throws away this character, so that we
                // have a clean slate for the next time we reach line 10.
                In.nextLine();
            }
        }
        // Here the 'number' variable contains a valid integer.
        System.out.println("You entered: " + number);
    }
}
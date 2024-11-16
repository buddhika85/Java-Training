import java.util.InputMismatchException;

class UserInput {
    UserInput() {
        // No attributes and so empty constructor.
    }

    // Print 'prompt' to console output, then obtain an int value from user input.
    // Keeps retrying if input isn't an int.
    int getInt(String prompt) 
    {        
        int number = 0;

        // TO-DO: Use In.nextInt() within a while loop, and handle
        // InputMismatchException
        while(true)
        {
            try 
            {
                System.out.println(prompt);
                number = In.nextInt();
                break;              // if we the above line is successful, this line will be executed to break the while loop
            } 
            catch (InputMismatchException e) 
            {
                System.out.println("Error - please provide a valid whole number");
                In.nextLine();
            }
        }

        // Fix this
        return number;
    }
}

class TestUserInputWithRetries {
    public static void main(String[] args) {
        UserInput input = new UserInput();
        int age = input.getInt("Enter you age (in years)");
        System.out.println("You're " + age + " years old");
    }
}
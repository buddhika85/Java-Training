import java.util.InputMismatchException;

class MultipleExceptions {
    public static void main(String[] args) {
        try 
        {
            int[] myArray = { 10, 20, 30, 40, 50 };

            System.out.print("Enter an index for array indexing: ");
            int index = In.nextInt();

            int value = myArray[index];

            System.out.println("Value at index " + index + " is: " + value);
        } 
        catch (InputMismatchException e) 
        {
            System.out.println("Invalid input. Please enter a valid integer.");
            In.nextLine();
        } 
        catch (ArrayIndexOutOfBoundsException e) 
        {
            System.out.println("Index out of range. Please enter a valid index within the range of the array.");
        }
    }
}
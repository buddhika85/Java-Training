public class Age {
    public static void main(String[] args) {
        System.out.println("Please enter your age: ");
        int age = In.nextInt();             // assumption: user always inputs an age which is always greater than 0 
        if (age <= 11)
        {
            System.out.println("Child");
        }
        else if (age >= 12 && age < 18)
        {
            System.out.println("Tween");
        }
        else
        {
            System.out.println("Adult");
        }
    }
}

public class GameRecommender {
    public static void main(String[] args) {
        System.out.println("Enter your favorite video game genre:");
        System.out.println("1. Action");
        System.out.println("2. Adventure");

        // Print blank line
        System.out.println();
        System.out.print("Enter your choice: ");
        int choice = In.nextInt();
        if (choice == 1) {
            System.out.println("We recommend playing Grand Theft Auto V.");
        } else if (choice == 2) {
            System.out.println("We recommend playing The Legend of Zelda: Breath of the Wild.");
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
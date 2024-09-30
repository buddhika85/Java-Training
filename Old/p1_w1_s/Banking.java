public class Banking {
    public static void main(String[] args) {
        String firstName = "Super";
        String lastName = "Mario";
        String date = "12 April 2023";
        double balance = 100.0;

        // deposit postive, withdrawal negative
        double transaction0 = 100.0;
        String transaction0Description = "Small deposit";

        double transaction1 = -25.0;
        String transaction1Description = "Small withdrawal";

        System.out.println(" ---------------------------------");
        System.out.println("|        COMMONWEALTH BANK         |");
        System.out.println(" ---------------------------------");        
        System.out.println("  " + date);        
        System.out.println("  Welcome back, " + firstName + " " + lastName + "!");
        System.out.println("  Starting balance : " + balance);
        System.out.println("\t" + transaction0Description + " : " + transaction0);        
        System.out.println("\t" + transaction1Description + " : " + transaction1);
        balance += transaction0 + transaction1;
        System.out.println("  Current Balance: " + balance);
    }
}

public class Q1 {
    public static void main(String[] args) {
        printFine(-10);
        printFine(3);
        printFine(6);
    }

    private static void printFine(int daysLate) {
        double deposit = 100;
        double penalty = -10;
        // System.out.println("How many days late?");
        // int daysLate = In.nextInt();
        if (daysLate <= 0) {
            penalty = 0;
        } else if (daysLate > 0 && daysLate <= 3) {
            penalty = 0.1;
        } else if (daysLate < 5) {
            penalty = 0.2;
        } else if (daysLate >= 5) {
            penalty = 0.3;
        }
        System.out.println("Your fine is $" + (deposit * penalty));
    }
}
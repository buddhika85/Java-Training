public class Q3 {
    public static void main(String[] args) {
        // Phone phone = null;
        // Phone[] allPhones = Phone.values();
        // while (phone == null) {
        //     System.out.println("Please select a phone:");
        //     for (int i = 0; i < allPhones.length; i++) {
        //         System.out.println("\t" + (i + 1) + " for " + allPhones[i]);
        //     }

        //     int input = In.nextInt();
        //     if (input > 0 && input <= allPhones.length) {
        //         phone = allPhones[input - 1];
        //     } else {
        //         System.out.println("Error - invalid input");
        //     }
        // }
        // System.out.println("You selected = " + phone);

        // antoher
        Phone phone = null;
        Phone[] allPhones = Phone.values();
        while (true) {
            System.out.println("Please select a phone:");
            for (int i = 0; i < allPhones.length; i++) {
                System.out.println("\t" + (i + 1) + " for " + allPhones[i]);
            }

            int input = In.nextInt();
            if (input > 0 && input <= allPhones.length) {
                phone = allPhones[input - 1];
                break;
            } else {
                System.out.println("Error - invalid input");
            }
        }
        System.out.println("You selected = " + phone);
    }
}

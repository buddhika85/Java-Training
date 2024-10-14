class Breakout {
    public static void main(String[] args) {
        int count = 3;
        while (count > 0) {
            System.out.println("Count is " + count + " Press 1 for up, 2 for down: ");
            int choice = In.nextInt();
            if (choice == 1) {
                count++;
            } else if (choice == 2) {
                count--;
            } else {
                System.out.println("ONLY 1 or 2");
            }
        }

        System.out.println("Count is zero, we've broken out!");
    }
}
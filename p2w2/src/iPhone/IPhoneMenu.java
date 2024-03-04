package iPhone;

public class IPhoneMenu 
{
    private IPhone iPhone = new IPhone();
    

    public void runMainMenu() 
    {
        System.out.println("--- IPHONE 15 Buying menu ---");
        System.out.println("Current Configration: " + iPhone);
        while (true) {
            System.out.println("Select an option:");
            System.out.println("  1. Change Model");
            System.out.println("  2. Change Color");
            System.out.println("  3. Change Storage");
            System.out.println("  4. Exit");
            int choice = In.nextInt();
            if (choice == 1) {
                changeModel();
            } else if (choice == 2) {
                changeColor();
            } else if (choice == 3) {
                changeStorage();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Pick an option 1, 2, or 3");
            }
        }
        System.out.println("Finalized: " + iPhone);
        System.out.println("Exiting...");
    }


    private void changeStorage() 
    {
        System.out.println("--- Change Storage ---");
        System.out.println("Select an option:");
        var all = Storage.values();
        for (int i = 0; i < all.length; i++) {
            System.out.println((i + 1) + ". " + all[i].getDescription());
        }
        System.out.println("  5. Back to main menu");
        int choice = In.nextInt();
        if (choice == 1) {
            iPhone.setStorage(Storage.ONE_TWO_EIGHT);                
        } else if (choice == 2) {
            iPhone.setStorage(Storage.TWO_FIVE_SIX);                
        } else if (choice == 3) {
            iPhone.setStorage(Storage.FIVE_TWELVE);                
        } 
        else if (choice == 4) {
            iPhone.setStorage(Storage.ONE_TB);                
        } 
        else if (choice == 5) {
            return;
        } else {
            System.out.println("Pick an option 1, 2, 3 or 4");
        }
    
        System.out.println("  You selected: " + iPhone.getStorage().getDescription());

        System.out.println("Current Configration: " + iPhone);
        System.out.println("Back to main menu...\n");
    }


    private void changeColor() 
    {
        System.out.println("--- Change Color ---");
        System.out.println("Select an option:");
        var all = Color.values();
        for (int i = 0; i < all.length; i++) {
            System.out.println((i + 1) + ". " + all[i]);
        }
        System.out.println("  4. Back to main menu");
        int choice = In.nextInt();
        if (choice == 1) {
            iPhone.setColor(Color.Natural_Titanium);
        } else if (choice == 2) {
            iPhone.setColor(Color.Blue_Titanium);
        } else if (choice == 3) {
            iPhone.setColor(Color.White_Titanium);                
        } 
        else if (choice == 4) {
            iPhone.setColor(Color.Black_Titanium);                
        } 
        else if (choice == 5) {
            return;
        } else {
            System.out.println("Pick an option 1, 2, 3 or 4");
        }
        System.out.println("  You selected: " + iPhone.getColor());

        System.out.println("Current Configration: " + iPhone);
        System.out.println("Back to main menu...\n");
    }


    private void changeModel() {
        System.out.println("--- Change Model ---");
        System.out.println("Select an option:");
        var all = Model.values();
        for (int i = 0; i < all.length; i++) {
            System.out.println((i + 1) + ". " + all[i]);
        }
        System.out.println("  4. Back to main menu");
        int choice = In.nextInt();
        if (choice == 1) {
            iPhone.setModel(Model.IPHONE_15_PRO);                
        } else if (choice == 2) {
            iPhone.setModel(Model.IPHONE_15_PRO_MAX);                
        } else if (choice == 3) {   
            return;
        } else {
            System.out.println("Pick an option 1, 2, 3 or 4");
        }
        System.out.println("  You selected: " + iPhone.getModel().getName());

        System.out.println("Current Configration: " + iPhone);
        System.out.println("Back to main menu...\n");
    }

   

}

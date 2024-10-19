public class DogMenu 
{
    private PuppyTracker puppyTracker = new PuppyTracker();

    void runMainMenu() 
    {
        System.out.println("--- Puppy Tracker menu ---");
        

        while (true)
        {
            System.out.println("\nSelect an option:");
            System.out.println("  1. Add");
            System.out.println("  2. Remove");
            System.out.println("  3. Update name");
            System.out.println("  4. Update weight, age and length by name ");
            System.out.println("  5. Print puppy details ");
            System.out.println("  6. Display a list of all");
            System.out.println("  7. Exit");
            int choice = In.nextInt();
            if (choice == 1) 
            {
                add();
            } 
            else if (choice == 2) 
            {
                remove();
            } 
            else if (choice == 3) 
            {
                updateByName();
            } 
            else if (choice == 4) 
            {
                updateOthersFieldsByName();
            } 
            else if (choice == 5) 
            {
                printPuppyDetails();
            } 
            else if (choice == 6) 
            {
                viewAll();
            } 
            else if (choice == 7) 
            {
                break;
            } 
            else 
            {
                System.out.println("Pick an option 1, 2, 3 or 4");
            }
        }

        System.out.println("Exiting...");
    }

    private void viewAll() 
    {
        System.out.println("\n--- All puppies list ---");
        puppyTracker.displayAll();
    }

    private void add() 
    {
        System.out.println("\n--- Add ---");
        Dog dog = readDogInputs();
        puppyTracker.addPuppy(dog);
    }

    private void remove() 
    {
        System.out.println("\n--- Remove ---");
        puppyTracker.removePuppy(readString("\tname? "));
    }

    private void updateByName() 
    {
        System.out.println("\n--- Update name ---");
        puppyTracker.updatePuppyDetails(readString("\told name? "), readString("\tnew name? "));
    }

    private void updateOthersFieldsByName() 
    {
        System.out.println("\n--- Update weight, age and length by name ---");
        String name = readString("\tname?");
        int age = readInt("\tage?");
        double weight = readDouble("\tweight?");
        double length = readDouble("\tlength?");
        puppyTracker.updatePuppyDetails(name, age, weight, length);
    }

    private void printPuppyDetails() 
    {
        System.out.println("\n--- Print puppy details ---");        
        puppyTracker.printPuppyDetails(readString("\tname? "));
    }


    private Dog readDogInputs()
    {
        String name = readString("\tname?");
        double age = readDouble("\tage?");
        double weight = readDouble("\tweight?");
        double length = readDouble("\tlength?");
        int typeId = readInt("\tType? [1] Husky [2] Poodle");
        if (typeId == 2)
        {
            return new Poodle(age, weight, length, name);
        }
        return new Husky(age, weight, length, name);
    }

    private int readInt(String question) 
    {
        System.out.print(question);
        return In.nextInt();
    }

    private double readDouble(String question) 
    {
        System.out.print(question);
        return In.nextDouble();
    }

    private String readString(String question) 
    {
        System.out.print(question);
        return In.nextLine();
    }    
}

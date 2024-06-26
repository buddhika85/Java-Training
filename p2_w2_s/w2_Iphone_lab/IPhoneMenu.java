public class IPhoneMenu 
{
    private IPhone iPhone = new IPhone();

    public static void main(String[] args) {
        new IPhoneMenu().runMainMenu();
    }

    void runMainMenu() 
    {
        System.out.println("--- IPhone menu ---");
        System.out.println("Your current configuration is : " + iPhone);

        while (true)
        {
            System.out.println("Select an option:");
            System.out.println("  1. Change Model");
            System.out.println("  2. Change Color");
            System.out.println("  3. Change Storage");
            System.out.println("  4. Exit");
            int choice = In.nextInt();
            if (choice == 1) 
            {
                changeModel();
            } 
            else if (choice == 2) 
            {
                changeColor();
            } 
            else if (choice == 3) 
            {
                changeStorage();
            } 
            else if (choice == 4) 
            {
                break;
            } 
            else 
            {
                System.out.println("Pick an option 1, 2, 3 or 4");
            }
        }

        System.out.println("Your current configuration is : " + iPhone);
        System.out.println("Exiting...");
    }

    private void changeModel() 
    {
        System.out.println("Select a model :");
        displayModels();
        iPhone.setModel(findModel(In.nextInt()));        
        System.out.println("Your current configuration is : " + iPhone);
    }      

    private void changeStorage() 
    {
        System.out.println("Select a storage :");
        displayStorages();
        iPhone.setStorage(findStorage(In.nextInt()));        
        System.out.println("Your current configuration is : " + iPhone);
    }

    private void changeColor() 
    {
        System.out.println("Select a color :");
        displayColors();
        iPhone.setColour(findColor(In.nextInt()));        
        System.out.println("Your current configuration is : " + iPhone);
    }

    private Storage findStorage(int storageInt) 
    {
        if (storageInt == 2)
            return Storage.TWO_FIVE_SIX;
        if (storageInt == 3)
            return Storage.FIVE_TWELVE;
        if (storageInt == 4)
            return Storage.ONE_TB;
        return Storage.ONE_TWO_EIGHT;
    }

    private Model findModel(int modelNum) 
    {
        if (modelNum == 2)
            return Model.IPHONE_15_PRO_MAX;
        return Model.IPHONE_15_PRO;
    }
    
    private Colour findColor(int colorInt) 
    {
        if (colorInt == 1)
            return Colour.Natural_Titanium;
        if (colorInt == 2)
            return Colour.Blue_Titanium;
        if (colorInt == 3)
            return Colour.White_Titanium;
        return Colour.Black_Titanium;
    }

    private void displayStorages() 
    {
        Storage[] storages = Storage.values();
        for (int i = 0; i < storages.length; i++) 
        {
            System.out.println("\t" + (i + 1) + ".  " + storages[i]);
        }
    }

    private void displayModels() 
    {
        Model[] models = Model.values();
        for (int i = 0; i < models.length; i++) 
        {
            System.out.println("\t" + (i + 1) + ".  " + models[i]);
        }
    }

    private void displayColors() 
    {
        Colour[] colours = Colour.values();
        for (int i = 0; i < colours.length; i++) 
        {
            System.out.println("\t" + (i + 1) + ".  " + colours[i]);
        }
    }   
}
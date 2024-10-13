import java.util.ArrayList;

public class PuppyTracker 
{
    
    private ArrayList<Dog> puppies = new ArrayList<>();

    void addPuppy(Dog puppy)
    {
        if (findByName(puppy.name) != null)
        {
            System.out.println("Error - already added, Cannot add again !");
            return;
        }

        puppies.add(puppy);
        System.out.println("Puppy added");
    }

    void removePuppy(String name)
    {
        Dog dog = findByName(name);
        if (dog == null)
        {
            System.out.println("Error - puppy with this name does not exists, so cannot remove !");
            return;
        }

        puppies.remove(dog);
        System.out.println("Puppy removed");
    }

    void updatePuppyDetails(String name, double age, double weight, double length)
    {
        Dog dog = findByName(name);
        if (dog == null)
        {
            System.out.println("Error - puppy with this name does not exists");
            return;
        }

        dog.setFeatures(age, weight, length);
        System.out.println("Puppy uodated");
    }

    void updatePuppyDetails(String oldName, String newName)
    {
        Dog dog = findByName(oldName);
        if (dog == null)
        {
            System.out.println("Error - puppy with this name does not exists");
            return;
        }

        dog.name = newName;
        System.out.println("Puppy name updated");
    }

    void printPuppyDetails(String name)
    {
        Dog dog = findByName(name);
        if (dog == null)
        {
            System.out.println("Error - puppy with this name does not exists");
            return;
        }

        // This method prints the current weight and length of the puppy, 
        // as well as all future estimates 
        // (by month) of weight and length up to the age 
        // when the dog is an adult.
        System.out.println("Dog name: " + dog.name + "current age: " + dog.age + ", current weight: " + dog.weight + 
            ", current length: " + dog.length);
        
        if (dog.age < dog.getAdultAge())
        {
            for (double i = dog.age + 1.0; i <= dog.getAdultAge(); i++) 
            {
                Features features = dog.estimateFeatures(dog.getAdultAge());
                System.out.println("\tFuture age: " + dog.age + ", future weight: " + features.weight + 
                    ", future length: " + features.length);
            }
        }
    }

    private Dog findByName(String name) {
        for (Dog dog : puppies) {
            if (dog.name.equals(name))
                return dog;
        }
        return null;
    }

    public void displayAll() 
    {
        if (puppies.isEmpty())
        {
            System.out.println("\tNo puppies to display !");
            return;
        }

        for (Dog dog : puppies) 
        {
            System.out.println("\t" + dog);
        }
    }

}

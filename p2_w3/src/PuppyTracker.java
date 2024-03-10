import java.util.ArrayList;

public class PuppyTracker 
{
    private ArrayList<Dog> puppies = new ArrayList<>();

    public void addPuppy(Dog puppy)
    {
        if (findByName(puppy.getName()) != null)
        {
            System.out.println("Error - " + puppy.getName() + " with same name already exists, cannot add again.");
            return;
        }

        puppies.add(puppy);
        System.out.println(puppy.getName() + " added");
    }

    public void removePuppy(String name)
    {
        var toRemove = findByName(name);
        if (toRemove == null)
        {
            System.out.println("Error - puppy with " + name + " does not exists, cannot remove");
            return;
        }

        puppies.remove(toRemove);
        System.out.println(toRemove.getName() + " removed");
    }

    // find by name and update other fields
    public void updatePuppyDetails(String name, int age, double weight, double length)
    {
        var toUpdate = findByName(name);
        if (toUpdate == null)
        {
            System.out.println("Error - puppy with " + name + " does not exists, cannot update");
            return;
        }

        toUpdate.setFeatures(age, weight, length);
    }

    // overload
    public void updatePuppyDetails(String oldName, String newName)
    {
        var toUpdate = findByName(oldName);
        if (toUpdate == null)
        {
            System.out.println("Error - puppy with " + oldName + " does not exists, cannot update");
            return;
        }
        
        toUpdate.setName(newName);
    }

    // prints the current weight and length of the puppy, 
    // as well as all future estimates of weight and length up to the age 
    // when the dog is an adult.
    public void printPuppyDetails(String name)
    {
        var puppy = findByName(name);
        if (puppy == null)
        {
            System.out.println("Error - no puppy with name " + name + ". so cannot print.");
            return;
        }
        System.out.println("Current Data: " + puppy);

        double growthStopAge = getGrowthStopAge(puppy);
        double monthsToAdult = growthStopAge - puppy.getAge();

        if (monthsToAdult <= 0)
        {
            System.out.println("\tThis puppy is already an adult. Will not grow more.");
            return;
        }

        System.out.println("\tThis puppy will become an adult by another " + 
            monthsToAdult + " months");
        System.out.println("\t\tWhen fully grown: " + puppy.estimateFeatures(growthStopAge));
    }


    private double getGrowthStopAge(Dog puppy) 
    {        
        if (puppy instanceof Husky)
        {
            return Husky.GROWTH_STOP_AGE;
        }
        return Poodle.GROWTH_STOP_AGE;
    }

    private Dog findByName(String name) 
    {
        for (Dog dog : puppies) 
        {
            if (dog.getName().equalsIgnoreCase(name))
                return dog;
        }
        return null;
    }
}

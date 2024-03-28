import java.util.LinkedList;
import java.util.ListIterator;

/**
 * class Animals - contains a list of Animal objects
 * 
 */
public class Animals
{    
    //instance variables
    private LinkedList<Animal> animalList = new LinkedList<Animal>();

    /**
     * Constructor for objects of class Animals
     */
    public Animals()
    {         
           animalList.add(new Cow("Clarabelle"));
           animalList.add(new Cow());
           animalList.add(new Cow("Buttercup"));
           animalList.add(new Cow("Daisy"));
           animalList.add(new Cow("Meg"));

           int count = animalList.size();
           System.out.println("There are " + count + " animals in the list");
    }

    /**
     * noise - prints the animal and noise it makes
     * 
     */
    public void noise()
    {
        ListIterator<Animal> li = animalList.listIterator();
        while (li.hasNext())
        {
            System.out.println(li.next().noise());
        }
    }
}

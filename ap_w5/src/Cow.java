/**
 * class Cow
 * 
 */
public class Cow extends Animal
{
    // constants
    final private String SOUND = "moo";
    final private String ANIMAL = "Cow";
    //instance variables
    private String name;

    /**
     * Default Constructor for objects of class Cow
     */
    public Cow()
    {
        name = "";
    }
   /**
     * Constructor for objects of class Cow
     */
    public Cow(String name)
    {
        this.name = name;
    }

     /**
     * noise Method - returns the noise a cow makes
     * 
     */
    public String noise()
    {
        String message;
        if (!name.equals(""))
        {
            message = name + " the " + ANIMAL + " says " + SOUND;
        }
        else
        {
            message = "A " + ANIMAL + " says " + SOUND;
        }
        return message;
    }
}
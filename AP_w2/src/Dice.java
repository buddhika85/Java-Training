/**
 * class Dice
 */
public class Dice
{
    private final int SIDES = 6;
    public Dice()
    {
    }
    public int roll()
    {
       return (int) ((Math.random()* SIDES)  + 1);
       // Math.random() return a value between 0 and 1.
    }
}


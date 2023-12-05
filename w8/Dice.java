package w8;

public class Dice {
    private final int SIDES = 6;

    /**
     * This is the MODEL - where the data comes from
     */
    public Dice()
    {
    }
    /**
     * roll - rolls the dice
     */
    public int roll()
    {
       int roll = (int) ((Math.random()*SIDES)+1);
       return roll;
    }
}

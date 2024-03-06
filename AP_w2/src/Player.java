public class Player 
{
    private String name;
    private int score;

    public Player(String name) 
    {
        this.name = name;
    }

    public void turn(Dice dice)
    {
        int rolled = dice.roll();
        score += rolled;
        System.out.println(name  + " rolled a " + rolled);
    }

    public int getScore()
    {
        return score;
    }

    @Override
    public String toString()
    {
        return name + " " + score;
    }
}

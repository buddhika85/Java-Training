public class Game 
{
    private Player[] players = new Player[2];
    private final int WIN_SCORE = 10;
    private final Dice dice = new Dice();

    public Game() 
    {
        setup();
        play();
        display();
    }

    private void display() 
    {
        System.out.println("Game Over");
        for (int i = 0; i < players.length; i++) 
        {
            System.out.println("\tPlayer 1 score: " + players[i]);
        }
    }

    private void play() 
    {
        do
        {
            for (int i = 0; i < players.length; i++) 
            {
                players[i].turn(dice);
            }
        }while(!isEnd());
    }

    private boolean isEnd() 
    {
        for (int i = 0; i < players.length; i++) 
        {
            if (players[i].getScore() >= WIN_SCORE)
                return true;
        }
        return false;
    }

    private void setup() 
    {
        for (int i = 0; i < players.length; i++) 
        {
            players[i] = new Player(readName());
        }
    }

    private String readName() 
    {
        System.out.print("Enter player name:  ");
        return In.nextLine();
    }
}

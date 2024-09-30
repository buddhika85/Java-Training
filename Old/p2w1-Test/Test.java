import java.util.Random;

public class Test
{
    private final static Random random = new Random();
    public static void main(String [] args)
    {
        //System.out.println("Hello");
        
        for (int i = 1; i <= 10; i++) {
            
            int playerOneHealth = 100;
            int playerTwoHealth = 100;
            while(playerOneHealth >= 0 && playerTwoHealth >= 0)
            {
                playerOneHealth -= GetDamage(1, 20);
                playerTwoHealth -= GetDamage(1, 20);
            }
            System.out.println("\nRound " + i +  " Player 1 : " + playerOneHealth + ", Player 2 : " + playerTwoHealth);
            if (playerOneHealth > playerTwoHealth)
            {
                System.out.println("Player 1 wins");
            }
            else if (playerTwoHealth > playerOneHealth)
            {
                System.out.println("Player 2 wins");
            }
            else
            {
                System.out.println("Its a draw");
            }
        }
    }

    public static int GetDamage(int low, int high)
    {        
        return random.nextInt(high) + low;
    }
}
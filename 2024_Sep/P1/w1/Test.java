class Test
{
    public static void main(String[] args) 
    {
        String pokemon = "Pikachu";

        int wins = 20;
        int losses = 3;

        System.out.println(pokemon + "'s record:");
        System.out.println("  - " + wins + " wins");
        System.out.println("  - " + losses + " losses");
        System.out.println("  - win-loss ratio of " + (wins / losses));

        double d = 1.1;
        System.out.println(wins + d);
    }
}
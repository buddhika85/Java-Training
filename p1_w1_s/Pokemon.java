public class Pokemon
{
    public static void main(String[] args) {
        String pokemon = "Pikachu";

int wins = 20;
int losses = 3;

System.out.println(pokemon + "'s record:");
System.out.println("  - " + wins + " wins");
System.out.println("  - " + losses + " losses");
System.out.println("  - win-loss ratio of " + (wins / losses));
System.out.println("  - win-loss ratio of " + wins / losses);
//System.out.println("  - with - " + wins - losses);            // does not compile
System.out.println("  - with * " + wins * losses);
System.out.println("  - with + " + wins + losses);
    }
}
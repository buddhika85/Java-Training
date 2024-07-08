public class Cyclist 
{
    String name;
    double endurance;       //, measured as a number between 1 and 100.
    double sprintAbility;   //, also measured as a number between 1 and 100.
    double preparation;     //, measured as a number between 1 and 100.

    Cyclist(String name, double endurance, double sprintAbility, double preparation) 
    {
        this.name = name;
        this.endurance = endurance;
        this.sprintAbility = sprintAbility;
        this.preparation = preparation;
    }

    // race method that computes and returns the cyclist's performance for a race.
    double race()
    {
        return 0.5 * this.preparation + 0.25 * this.endurance + 0.25 * this.sprintAbility;   
    }

    public static void main(String[] args) {
        Cyclist cyclistJack = new Cyclist("Jack", 90, 80, 90);
        Cyclist cyclistJill = new Cyclist("Jill", 100, 90, 70);
        System.out.println(cyclistJack.name +  "'s Performance: " + cyclistJack.race());
        System.out.println(cyclistJill.name +  "'s Performance: " + cyclistJill.race());
    }
}



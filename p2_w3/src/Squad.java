import java.util.ArrayList;

public class Squad 
{
    private ArrayList<Soldier> members;

    Squad() 
    {
        this.members = new ArrayList<>();
    }

    void addSoldier(Soldier soldier) 
    {
        this.members.add(soldier);
    }

    int totalGroundAttackPower() 
    {
        int total = 0;
        for (Soldier s : this.members) 
        {
            total += s.getGroundDamage();
        }

        return total;
    }

    void activateStimpackForMarines() 
    {
        for (Soldier s : this.members) 
        {
            // Here is where we check for `Marine` type
            if (s instanceof Marine) 
            {
                // We need to cast `s` to the `Marine` type.
                Marine m = (Marine) s;  
                m.activateStimpack();              
            }

            // check actual type is Firebat or not
            if (s instanceof Firebat)
            {
                // We need to cast `s` to the `Firebat` type.
                Firebat m = (Firebat) s;
                m.activateStimpack();
            }
        }
    }

    void printSquadComposition()
    {
        int fireBatCount = 0, marineCount = 0, ghostCount = 0;
        for (Soldier s : this.members) 
        {
            if (s instanceof Marine) 
                ++marineCount;
            if (s instanceof Firebat)
                ++fireBatCount;
            if (s instanceof Ghost)
                ++ghostCount;
        }
        System.out.println("FireBat count: " + fireBatCount + 
            ", marine count: " + marineCount +
            ", ghost count: " + ghostCount);
    }

    void cloakAllGhosts()
    {
        for (Soldier s : this.members) 
        {
            if (s instanceof Ghost)
            {
                Ghost ghost = (Ghost) s;
                ghost.activateCloak();
            }
        }
    }

}

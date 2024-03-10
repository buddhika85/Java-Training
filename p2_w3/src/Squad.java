import java.util.ArrayList;

public class Squad 
{
    private ArrayList<TerranUnit> members;

    Squad() 
    {
        this.members = new ArrayList<>();
    }

    void add(TerranUnit terranUnit) 
    {
        this.members.add(terranUnit);
    }

    int totalGroundAttackPower() 
    {
        int total = 0;
        for (TerranUnit s : this.members) 
        {
            if (s instanceof Soldier) 
                total += ((Soldier)s).getGroundDamage();
        }

        return total;
    }

    void activateStimpackForMarines() 
    {
        for (TerranUnit s : this.members) 
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
        int fireBatCount = 0, marineCount = 0, ghostCount = 0, wraithCount = 0;
        for (TerranUnit s : this.members) 
        {
            if (s instanceof Marine) 
                ++marineCount;
            if (s instanceof Firebat)
                ++fireBatCount;
            if (s instanceof Ghost)
                ++ghostCount;
            if (s instanceof Wraith)
                ++wraithCount;
        }
        System.out.println("FireBat count: " + fireBatCount + 
            ", marine count: " + marineCount +
            ", ghost count: " + ghostCount +
            ", wraith count: " + wraithCount);
    }

    void cloakAllGhosts()
    {
        for (TerranUnit s : this.members) 
        {
            if (s instanceof Ghost)
            {
                Ghost ghost = (Ghost) s;
                ghost.activateCloak();
            }
        }
    }

}

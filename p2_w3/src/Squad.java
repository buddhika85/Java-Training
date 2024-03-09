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
            if (s instanceof Marine) {
                // We need to cast `s` to the `Marine` type.
                Marine m = (Marine) s;
                m.activateStimpack();
            }
        }
    }

}

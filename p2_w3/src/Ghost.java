public class Ghost extends Soldier
{    
    boolean isClockActive;

    Ghost() 
    {
        // assumption - Ghost max health is 60 and speed is 6
        super(Weapon.C_10_RIFLE, 60, 6);       
    }

    void activateCloak()
    {
        isClockActive = true;
    }
    
}

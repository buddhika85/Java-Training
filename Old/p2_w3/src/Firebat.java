class Firebat extends Soldier 
{
    boolean stimpackActive;

    Firebat() 
    {
        super(Weapon.FLAME_THROWER, 50, 4);
    }

    void activateStimpack() 
    {
        this.stimpackActive = true;
    }

    // modify the damage it can inflict on GROUND units by overriding the getAirDamage() method:
    // why I use ground damage instead of air damage? Weapon.FLAME_THROWER air damage is 0
    @Override
    int getGroundDamage() 
    {
        int originalDamage = super.getGroundDamage();
        if (this.stimpackActive) 
        {
            // active Stimpack increases theFirebat's damage by a third (1/3). 
            return originalDamage + originalDamage / 3;
        } 
        else 
        {
            return originalDamage;
        }
    }
}
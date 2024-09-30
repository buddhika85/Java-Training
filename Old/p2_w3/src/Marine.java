class Marine extends Soldier 
{
    boolean stimpackActive;

    Marine() 
    {
        super(Weapon.MACHINE_GUN, 40, 4);
        this.stimpackActive = false;
    }

    void activateStimpack() 
    {
        this.stimpackActive = true;
    }

    // modify the damage it can inflict on AIR units by overriding the getAirDamage() method:
    @Override
    int getAirDamage() 
    {
        int originalDamage = super.getAirDamage();
        if (this.stimpackActive) 
        {
            // If stimpack is active, increase damage by 50%.
            return originalDamage + originalDamage / 2;
        } 
        else 
        {
            return originalDamage;
        }
    }

}
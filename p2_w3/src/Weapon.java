enum Weapon 
{
    MACHINE_GUN(6, 6, 4),
    FLAME_THROWER(8, 0, 2);

    // Amount of damage that can be inflicted on ground-base enemies
    private int groundDamage;
    // Amount of damage that can be inflicted on airbourne enemies
    private int airDamage;
    // The maximum distance that the weapon can inflict damage
    private int attackRange;

    Weapon(int groundDamage, int airDamage, int attackRange) {
        this.groundDamage = groundDamage;
        this.airDamage = airDamage;
        this.attackRange = attackRange;
    }
    
    int getGroundDamage() {
        return this.groundDamage;
    }

    int getAirDamage() {
        return this.airDamage;
    }

    int getAttackRange() {
        return this.attackRange;
    }

    public String toString() {
        return this.name() + "\n" +
                " - Ground damage: " + this.groundDamage + "\n" +
                " - Air damage: " + this.airDamage + "\n" +
                " - Attack range: " + this.attackRange;
    }
}
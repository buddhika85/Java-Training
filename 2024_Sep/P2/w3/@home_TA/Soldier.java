public class Soldier {
    private final int MAX_HEALTH;
    private final Weapon WEAPON;

    private int currentHealth;
    // Measures how fast the soldier can move
    private int speed;

    Soldier(Weapon weapon, int maxHealth, int speed) {
        this.MAX_HEALTH = maxHealth;
        this.WEAPON = weapon;
        this.currentHealth = maxHealth;
        this.speed = speed;
    }

    int getGroundDamage() {
        return this.WEAPON.getGroundDamage();
    }

    int getAirDamage() {
        return this.WEAPON.getAirDamage();
    }
}

class Marine extends Soldier {
    boolean stimpackActive;

    Marine() {
        super(Weapon.MACHINE_GUN, 40, 4);
        this.stimpackActive = false;
    }

    void activateStimpack() {
        this.stimpackActive = true;
    }

    @Override
    int getAirDamage() {
        int originalDamage = super.getAirDamage();
        if (this.stimpackActive) {
            // If stimpack is active, increase damage by 50%.
            return originalDamage + originalDamage / 2;
        } else {
            return originalDamage;
        }
    }

}

class Firebat extends Soldier {
    Firebat() {
        super(Weapon.FLAME_THROWER, 50, 4);
    }
}

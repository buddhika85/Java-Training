import java.util.ArrayList;


enum Weapon {
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

    boolean stimpackActive;

    Firebat() {
        super(Weapon.FLAME_THROWER, 50, 4);
    }

    void activateStimpack() {
        this.stimpackActive = true;
    }

    // Ill overrode getGroundDamage()
    // not getAirDamage
    // as FLAME_THROWER airDamage is 0 and cannot cause any air damage anyway

    @Override
    int getGroundDamage() {
        int originalDamage = super.getGroundDamage();
        if (this.stimpackActive) {
            // Stimpack increases the Firebat's damage by a third (1/3)
            return originalDamage + originalDamage / 3;
        } else {
            return originalDamage;
        }
    }
}

class Squad {
    private ArrayList<Soldier> members;

    Squad() {
        this.members = new ArrayList<>();
    }

    void addSoldier(Soldier soldier) {
        this.members.add(soldier);
    }

    int totalGroundAttackPower() {
        int total = 0;
        for (Soldier s : this.members) {
            total += s.getGroundDamage();
        }

        return total;
    }

    void activateStimpackForMarines() {
        for (Soldier s : this.members) {
            // Here is where we check for `Marine` type
            if (s instanceof Marine) {
                // We need to cast `s` to the `Marine` type.
                Marine m = (Marine) s;
                m.activateStimpack();
            }
        }
    }

    void printSquadComposition()
    {
        int marineCount = 0;
        int firebatCount = 0;
        for (Soldier soldier : members) 
        {
            if (soldier instanceof Marine)
                ++marineCount;
            if (soldier instanceof Firebat)
                ++firebatCount;    
        }
        
        System.out.println("Squad composition: ");
        System.out.println("\tMarines - " + marineCount);
        System.out.println("\tFirebats - " + firebatCount);
    }
}

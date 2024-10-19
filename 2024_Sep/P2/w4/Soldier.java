import java.util.ArrayList;

import javax.management.Query;


enum Weapon {
    MACHINE_GUN(6, 6, 4),
    FLAME_THROWER(8, 0, 2),
    C_10_RIFLE(10, 10, 7);

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

enum UnitType
{
    GROUND_BASED_UNIT,
    AIRBOURNE_UNIT;
}

class TerranUnit
{
    protected UnitType unitType;
}
public class Soldier extends TerranUnit
{
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

class Wrait extends TerranUnit
{
    public Wrait() 
    {
        // airbourne unit
        super.unitType = UnitType.AIRBOURNE_UNIT;
    }
}

class Ghost extends Soldier
{
    private boolean isClockActive;

    Ghost()
    {
        super(Weapon.C_10_RIFLE, 45, 4);
        this.isClockActive = false;
    }

    public void activateCloak()
    {
        this.isClockActive = true;          // invisible
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
    private ArrayList<TerranUnit> members;

    Squad() {
        this.members = new ArrayList<>();
    }

    void addSoldier(TerranUnit terranUnit) 
    {
        this.members.add(terranUnit);
    }

    int totalGroundAttackPower() 
    {
        int total = 0;
        for (TerranUnit t : this.members) 
        {
            if (t instanceof Soldier)
            {
                Soldier s = (Soldier) t;
                total += s.getGroundDamage();
            }
        }

        return total;
    }

    void activateStimpackForMarines() 
    {
        for (TerranUnit s : this.members) 
        {
            // Here is where we check for `Marine` type
            if (s instanceof Marine) {
                // We need to cast `s` to the `Marine` type.
                Marine m = (Marine) s;
                m.activateStimpack();
            }
        }
    }

    void cloakAllGhosts()
    {
        for (TerranUnit s : this.members) 
        {           
            if (s instanceof Ghost) 
            {               
                Ghost g = (Ghost) s;
                g.activateCloak();
            }
        }
    }

    void printSquadComposition()
    {
        int marineCount = 0;
        int firebatCount = 0;
        int ghostCount = 0;
        int wraithCount = 0;

        for (TerranUnit soldier : members) 
        {
            if (soldier instanceof Marine)
                ++marineCount;
            if (soldier instanceof Firebat)
                ++firebatCount;   
            if (soldier instanceof Ghost)
                ++ghostCount;  
            if (soldier instanceof Wrait)
                ++wraithCount;    
        }
        
        System.out.println("Squad composition: ");
        System.out.println("\tMarines - " + marineCount);
        System.out.println("\tFirebats - " + firebatCount);
        System.out.println("\tGhosts - " + ghostCount);
        System.out.println("\tWraiths - " + wraithCount);
    }
}

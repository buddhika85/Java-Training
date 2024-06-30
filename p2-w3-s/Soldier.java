import java.util.ArrayList;

enum UnitType
{
    GROUND_BASED,
    AIRBOURNE,
}

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

class TerranUnit 
{
    private UnitType unitType;

    public TerranUnit(UnitType unitType) {
        this.unitType = unitType;
    }

   
    int getGroundDamage() {
        return 0;
    }

    int getAirDamage() { 
        return 0;
    }
}

class Wraith extends TerranUnit
{
    public Wraith(UnitType unitType) 
    {
        super(UnitType.AIRBOURNE);
    }

    @Override
    int getAirDamage() {
        return 8;
    }

    @Override
    int getGroundDamage() {
        return 20;
    }
}

public class Soldier extends TerranUnit {
    protected final int MAX_HEALTH;
    protected final Weapon WEAPON;

    private int currentHealth;
    // Measures how fast the soldier can move
    private int speed;

    Soldier(Weapon weapon, int maxHealth, int speed) {
        super(UnitType.GROUND_BASED);
        this.MAX_HEALTH = maxHealth;
        this.WEAPON = weapon;
        this.currentHealth = maxHealth;
        this.speed = speed;
    }

    @Override
    int getGroundDamage() {
        return this.WEAPON.getGroundDamage();
    }

    @Override
    int getAirDamage() {
        return this.WEAPON.getAirDamage();
    }
}

class Ghost extends Soldier
{
    boolean isCloakActive;      // is invisible

    Ghost()
    {
        super(Weapon.C_10_RIFLE, 45, 4);
    }

    void activateCloak()
    {
        isCloakActive = true;
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

    @Override
    int getGroundDamage() {
        int originalDamage = super.getGroundDamage();
        if (this.stimpackActive) {
            // If stimpack is active, increase damage third (1/3).
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

    void addSoldier(Soldier soldier) {
        this.members.add(soldier);
    }

    int totalGroundAttackPower() {
        int total = 0;
        for (TerranUnit s : this.members) {
            total += s.getGroundDamage();
        }

        return total;
    }

    void activateStimpackForMarines() {
        for (TerranUnit s : this.members) {
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
        int fireBatCount = 0;
        int ghostCount = 0;
        int wraithCount = 0;
        for (TerranUnit soldier : members) {
            if (soldier instanceof Marine)
                ++marineCount;
            if (soldier instanceof Firebat)
                ++fireBatCount;
            if (soldier instanceof Ghost)
                ++ghostCount;    
            if (soldier instanceof Wraith)
                ++ghostCount;  
        }

        System.out.println("Marine count: " + marineCount);
        System.out.println("Firebat count: " + fireBatCount);
        System.out.println("Ghost count: " + ghostCount);
        System.out.println("Wraith count: " + wraithCount);
    }

    void cloakAllGhosts()
    {
        for (TerranUnit soldier : members) {
            if (soldier instanceof Ghost)
                ((Ghost)soldier).activateCloak();
        }
    }

}

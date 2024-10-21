import java.util.ArrayList;

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

// interfaces
interface GroundUnit {}
interface AirbournUnit {}
interface AttackOnGround 
{
    int getGroundDamage();
}
interface AttackOnAir 
{
    int getAirDamage();
}
interface UseStimpack 
{
    void activateStimpack();
}
interface UseCloak
{
    void activateCloak();
}

class Wraith implements AirbournUnit, AttackOnGround, AttackOnAir
{
    private final int MAX_HEALTH;   
    private int currentHealth;
    // Measures how fast the soldier can move
    private int speed;

    Wraith() 
    {
        this.MAX_HEALTH = 120;       
        this.currentHealth = MAX_HEALTH;
        this.speed = 7;
    }

    @Override
    public int getGroundDamage() {
        return 8;
    }

    @Override
    public int getAirDamage() {
        return 20;
    }
}

class Ghost implements GroundUnit, AttackOnGround, AttackOnAir, UseCloak
{
    private boolean isClockActive;
    private final Weapon WEAPON;
    private final int MAX_HEALTH;  
    private int speed;

    Ghost()
    {
        WEAPON = Weapon.C_10_RIFLE;
        MAX_HEALTH =  45;
        this.speed = 4;
        this.isClockActive = false;
    }

    @Override
    public void activateCloak()
    {
        this.isClockActive = true;          // invisible
    }

    @Override
    public int getGroundDamage() {
        return 8;
    }

    @Override
    public int getAirDamage() {
        return 20;
    }
}

class Marine implements GroundUnit, AttackOnGround, AttackOnAir, UseStimpack
{
    boolean stimpackActive;
    private final Weapon WEAPON;
    private final int MAX_HEALTH;  
    private int speed;

    Marine() {
        //super(Weapon.MACHINE_GUN, 40, 4);
        WEAPON = Weapon.MACHINE_GUN;
        MAX_HEALTH =  40;
        this.speed = 4;
        this.stimpackActive = false;
    }

    @Override
    public void activateStimpack() {
        this.stimpackActive = true;
    }

    @Override
    public int getAirDamage() {
        int originalDamage = WEAPON.getAirDamage();
        if (this.stimpackActive) {
            // If stimpack is active, increase damage by 50%.
            return originalDamage + originalDamage / 2;
        } else {
            return originalDamage;
        }
    }

    @Override
    public int getGroundDamage() {
        int originalDamage = WEAPON.getGroundDamage();
        if (this.stimpackActive) {
            // If stimpack is active, increase damage by 50%.
            return originalDamage + originalDamage / 2;
        } else {
            return originalDamage;
        }
    }

}

class Firebat implements GroundUnit, AttackOnGround, AttackOnAir, UseStimpack {

    boolean stimpackActive;
    private final Weapon WEAPON;
    private final int MAX_HEALTH;  
    private int speed;

    Firebat() {
        //super(Weapon.FLAME_THROWER, 50, 4);
        WEAPON = Weapon.MACHINE_GUN;
        MAX_HEALTH =  50;
        this.speed = 4;
        this.stimpackActive = false;
    }

    @Override
    public void activateStimpack() {
        this.stimpackActive = true;
    }

    // Ill overrode getGroundDamage()
    // not getAirDamage
    // as FLAME_THROWER airDamage is 0 and cannot cause any air damage anyway

    @Override
    public int getGroundDamage() {
        int originalDamage = WEAPON.getGroundDamage();
        if (this.stimpackActive) {
            // Stimpack increases the Firebat's damage by a third (1/3)
            return originalDamage + originalDamage / 3;
        } else {
            return originalDamage;
        }
    }

    @Override
    public int getAirDamage() 
    {
        return WEAPON.getAirDamage();
    }
}

class Squad 
{
    private ArrayList<GroundUnit> groundUnitMembers;
    private ArrayList<AirbournUnit> airUnitMembers;

    Squad() {
        this.groundUnitMembers = new ArrayList<>();
        this.airUnitMembers = new ArrayList<>();
    }

    void addSoldier(GroundUnit unit) 
    {
        this.groundUnitMembers.add(unit);
    }

    void addSoldier(AirbournUnit unit) 
    {
        this.airUnitMembers.add(unit);
    }

    int totalGroundAttackPower() 
    {
        int total = 0;
        for (GroundUnit unit : this.groundUnitMembers) 
        {
            if (unit instanceof AttackOnGround)
            {
                AttackOnGround groundAttackUnit = (AttackOnGround) unit;
                total += groundAttackUnit.getGroundDamage();
            }
        }

        for (AirbournUnit unit : this.airUnitMembers) 
        {
            if (unit instanceof AttackOnGround)
            {
                AttackOnGround groundAttackUnit = (AttackOnGround) unit;
                total += groundAttackUnit.getGroundDamage();
            }
        }
        return total;
    }

    void activateStimpackForMarines() 
    {
        for (GroundUnit unit : this.groundUnitMembers) 
        {
            if (unit instanceof Marine) 
            {
                // We need to cast `s` to the `Marine` type.
                Marine m = (Marine) unit;
                m.activateStimpack();
            }
        }
    }

    void cloakAllGhosts()
    {
        for (GroundUnit unit : this.groundUnitMembers) 
        {
            if (unit instanceof Ghost) 
            {               
                Ghost g = (Ghost) unit;
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

        for (GroundUnit soldier : groundUnitMembers) 
        {
            if (soldier instanceof Marine)
                ++marineCount;
            if (soldier instanceof Firebat)
                ++firebatCount;   
            if (soldier instanceof Ghost)
                ++ghostCount;  
        }

        for (AirbournUnit soldier : airUnitMembers) {
            if (soldier instanceof Wraith)
                ++wraithCount; 
        }
        
        System.out.println("Squad composition: ");
        System.out.println("\tMarines - " + marineCount);
        System.out.println("\tFirebats - " + firebatCount);
        System.out.println("\tGhosts - " + ghostCount);
        System.out.println("\tWraiths - " + wraithCount);
    }
}

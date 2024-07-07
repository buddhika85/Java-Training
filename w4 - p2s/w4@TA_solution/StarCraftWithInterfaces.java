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


// replacement for unit type enum
interface GroundUnit {
    // No methods needed
}

// replacement for unit type enum
interface AirbourneUnit {
    // No methods needed
}

interface UseStimpack {
	void activateStimpack();
}

interface UseCloak {
	void activateCloak();
}

// replacement for solidier class
interface AttackGround {
    int getGroundDamage();
}

// replacement for solidier class
interface AttackAir {
    int getAirDamage();
}

// concreate classes starts from here
class Wraith implements AirbourneUnit, AttackAir, AttackGround {
    int currentHealth;
    int speed;
    final int MAX_HEALTH;

    Wraith() {
        this.MAX_HEALTH = 120;
        this.currentHealth = this.MAX_HEALTH;
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

class Marine implements GroundUnit, AttackAir, AttackGround, UseStimpack {
    int currentHealth;
    int speed;
    final int MAX_HEALTH;
    boolean stimpackActive;
    Weapon WEAPON;

    Marine() {
        this.MAX_HEALTH = 40;
        this.currentHealth = this.MAX_HEALTH;
        this.speed = 4;
        this.WEAPON = Weapon.MACHINE_GUN;
        this.stimpackActive = false;
    }

    @Override
    public void activateStimpack() {
        this.stimpackActive = true;
    }

    private int getFinalDamage(int originalDamage) {
        if (this.stimpackActive) {
            // If stimpack is active, increase damage by 50%.
            return originalDamage + originalDamage / 2;
        } else {
            return originalDamage;
        }
    }

    @Override
    public int getAirDamage() {
        return this.getFinalDamage(this.WEAPON.getAirDamage());
    }

    @Override
    public int getGroundDamage() {
        return this.getFinalDamage(this.WEAPON.getGroundDamage());
    }
}

// FLAME_THROWER(8, 0, 2),  // ground damage, air damage, attack range
class Firebat implements GroundUnit, AttackGround, UseStimpack {
    int currentHealth;
    int speed;
    final int MAX_HEALTH;
    Weapon WEAPON;
    boolean stimpackActive;

    Firebat() {
        this.MAX_HEALTH = 50;
        this.currentHealth = this.MAX_HEALTH;
        this.speed = 4;
        this.WEAPON = Weapon.FLAME_THROWER;
        this.stimpackActive = false;
    }

    @Override
    public void activateStimpack() {
        this.stimpackActive = true;
    }

    @Override
    public int getGroundDamage() {
        int originalDamage = this.WEAPON.getGroundDamage();
        if (this.stimpackActive) {
            // If stimpack is active, increase damage by 1/3.
            return originalDamage + originalDamage / 3;
        } else {
            return originalDamage;
        }
    }
}

class Ghost implements GroundUnit, AttackAir, AttackGround, UseCloak {
    int currentHealth;
    int speed;
    final int MAX_HEALTH;
    Weapon WEAPON;
    boolean clockActivated;

    Ghost() {
        this.WEAPON = Weapon.C_10_RIFLE;
        this.MAX_HEALTH = 45;
        this.currentHealth = this.MAX_HEALTH;
        this.speed = 4;
        this.clockActivated = false;
    }

    @Override
    public void activateCloak() {
        this.clockActivated = true;
    }

    @Override
    public int getAirDamage() {
        return this.WEAPON.getAirDamage();
    }

    @Override
    public int getGroundDamage() {
        return this.WEAPON.getGroundDamage();
    }

}

class Squad {
    private ArrayList<GroundUnit> groundMembers;

    // We could just as well change the element type to Wraith, but this
    // keep it general if we add more airbourne unit types.
    private ArrayList<AirbourneUnit> airMembers;

    Squad() {
        this.groundMembers = new ArrayList<>();
        this.airMembers = new ArrayList<>();
    }

    void addGroundUnit(GroundUnit soldier) {
        this.groundMembers.add(soldier);
    }

    void addAirUnit(AirbourneUnit unit) {
        this.airMembers.add(unit);
    }

    int totalGroundAttackPower() {
        int total = 0;
        for (GroundUnit s : this.groundMembers) {
            if (s instanceof AttackGround) {
                AttackGround g = (AttackGround) s;
                total += g.getGroundDamage();
            }
        }

        for (AirbourneUnit s : this.airMembers) {
            if (s instanceof AttackGround) {
                AttackGround g = (AttackGround) s;
                total += g.getGroundDamage();
            }
        }

        return total;
    }

    void activateStimpackForMarines() {
        for (GroundUnit s : this.groundMembers) {
            if (s instanceof Marine) {
                Marine m = (Marine) s;
                m.activateStimpack();
            }
        }
    }

    void printSquadComposition() {
        int numMarines = 0;
        int numFirebats = 0;
        int numGhosts = 0;
       
        for (GroundUnit s : this.groundMembers) {
            if (s instanceof Marine) 
            {
                numMarines += 1;
            } 
            if (s instanceof Firebat) 
            {
                numFirebats += 1;
            }
            if (s instanceof Ghost)
            {
                numGhosts += 1;
            }
        }

        System.out.println(numMarines + " marines");
        System.out.println(numFirebats + " firebats");
        System.out.println(numGhosts + " ghosts");
        System.out.println(this.airMembers.size() + " wraiths");
    }
}




public class StarCraftWithInterfaces {
    public static void main(String[] args) {
        Squad squad = new Squad();
        squad.addGroundUnit(new Marine());
        squad.addGroundUnit(new Firebat());
        squad.addGroundUnit(new Ghost());
        squad.addGroundUnit(new Ghost());
        squad.addAirUnit(new Wraith());

      
        squad.activateStimpackForMarines();
        squad.printSquadComposition();
    }
}

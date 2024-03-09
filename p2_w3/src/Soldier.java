public class Soldier 
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
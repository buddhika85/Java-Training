public class Pokemon {
    String name;        //, e.g. "Pikachu".
    int level;          //, as an integer.
    String pokemonType; //, e.g. "electric".
    int health;         //, as an integer. 


    public Pokemon(String name, int level, String pokemonType) 
    {
        this.name = name;
        this.level = level;
        this.pokemonType = pokemonType;
        this.health = 10 * this.level;     // When creating a new Pokemon, its initial health is equal to 10 * level.
    }

    // This method will reduce the Pokemon's health by damage-units.
    void takeDamage(int damage)
    {
        System.out.println(this.name + " with health " + this.health + " taking " + damage + " damage");
        this.health -= damage;        
        System.out.println("Health is now: " + this.health);
    }

    // This method will result in target taking damage as a result of being attacked. 
    // higher the level, the more damage inflicted on target
    // assume formula for damage calculation is --> level + 10
    void attack(Pokemon target)
    {
        target.takeDamage(level + 10);
    }

    public String toString() 
    {
        return this.name + ", level: " + this.level + ", type: " + 
            this.pokemonType + ", health: " + this.health;
    }

    public static void main(String[] args) 
    {
        // Types - Rock, Water, Dark, Electric
        Pokemon pokemonOne = new Pokemon("Magcargo", 10, "Rock");
        Pokemon pokemonTwo = new Pokemon("Pikachu", 5, "Electric");

        System.out.println("---- Initially attacking");
        System.out.println(pokemonOne);
        System.out.println(pokemonTwo);

        System.out.println();
        System.out.println("---- Attacking");
        pokemonOne.attack(pokemonTwo);
        pokemonTwo.attack(pokemonOne);

        System.out.println();
        System.out.println("---- After attacking");
        System.out.println(pokemonOne);
        System.out.println(pokemonTwo);
    }
}

abstract class Dog {
    protected String name;
    protected Breed breed;

    Dog(String name, Breed breed) {
        this.name = name;
        this.breed = breed;
    }

    abstract void bark();
}

class Poodle extends Dog {
    Poodle(String name) {
        super(name, Breed.POODLE);
    }

    @Override
    void bark() {
        System.out.println(super.name + " the poodle, yaps.");
    }
}

class GermanShepherd extends Dog {
    GermanShepherd(String name) {
        super(name, Breed.GERMAN_SHEPHERD);
    }

    @Override
    void bark() {
        System.out.println(super.name +
                " the German Shephard, barks in a low register.");
    }
}

enum Breed {
    POODLE, GERMAN_SHEPHERD
}

public class DogTest
{
    public static void main(String[] args) {
        //Dog dog = new Dog("White", Breed.POODLE);
        Poodle dog = new Poodle("White");

    }
}
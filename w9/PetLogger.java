import model.MyObserver;
import model.Pet;

public class PetLogger implements MyObserver{
    private Pet pet;
    public PetLogger(Pet pet) {
        this.pet = pet;
        pet.attach(this);
    }
    @Override
    public void update() {
        System.out.println("Log : Save clicked - new details " + pet);
    }
}

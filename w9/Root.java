import model.Pet;

public class Root {
    public static void main(String[] args) {
        Pet sharedModel = new Pet();
        new PetWindow(sharedModel);
        new PetLogger(sharedModel);
    }
}

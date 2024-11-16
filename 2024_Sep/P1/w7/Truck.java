
class Truck extends Vehicle{
   
    int cargoCapacity;

    public Truck(int wheelSize, int tyreThickness, String name, int cargoCapacity) {
        super(wheelSize, tyreThickness, name);
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Cargo Capacity: " + cargoCapacity + "kg");
    }
}
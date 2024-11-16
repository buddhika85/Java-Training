
class Car extends Vehicle{
    
    int seatingCapacity;

    public Car(int wheelSize, int tyreThickness, String name, int seatingCapacity) {
        super(wheelSize, tyreThickness, name);
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Seating Capacity: " + seatingCapacity);
    }
}
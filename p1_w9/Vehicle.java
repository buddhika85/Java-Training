import java.util.ArrayList;

public class Vehicle {
    protected int wheelSize;
    private int tyreThickness;
    private String name;

    public Vehicle(int wheelSize, int tyreThickness, String name) {
        this.wheelSize = wheelSize;
        this.tyreThickness = tyreThickness;
        this.name = name;
    }

    public void showDetails() {
        System.out.println("Vehicle: " + name);
        System.out.println("Wheel Size: " + wheelSize);
        System.out.println("Tyre Thickness: " + tyreThickness);
    }
}


class Truck extends Vehicle {
    private int cargoCapacity;

    public Truck(int wheelSize, int tyreThickness, String name, int cargoCapacity) {
        super(wheelSize, tyreThickness, name); // Call the constructor of the Vehicle class
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Cargo Capacity: " + cargoCapacity + "kg");
    }
}


class Car extends Vehicle {
    private int seatingCapacity;

    public Car(int wheelSize, int tyreThickness, String name, int seatingCapacity) {
        super(wheelSize, tyreThickness, name); // Call the constructor of the Vehicle class
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Seating Capacity: " + seatingCapacity);
    }
}


class Garage {
    private ArrayList<Vehicle> vehicles;

    Garage() {
        vehicles = new ArrayList<>();
    }

    void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    void displayVehicles() {
        for (Vehicle vehicle : vehicles) {
            vehicle.showDetails();
            System.out.println(); // Just to give some separation between outputs
        }
    }
}

class TestGarage {
    public static void main(String[] args) {
        Garage garage = new Garage();
        Truck truck = new Truck(34, 22, "Izuzu", 3435);
        Car car = new Car(80, 30, "Toyota", 5);

        garage.addVehicle(truck);
        garage.addVehicle(car);

        garage.displayVehicles();
    }
}
import java.util.ArrayList;

public class Q6 {
    public static void main(String[] args) {

        // 6.1
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Motorcycle(Colour.RED));
        vehicles.add(new Motorcycle(Colour.BLACK));
        for (Colour colour : Colour.values()) {
            vehicles.add(new Car(colour));

        }

        // testing
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }

        // 6.2 testing
        ArrayList<Vehicle> stock = new ArrayList<>();
        stock.add(new Motorcycle(Colour.BLUE));
        stock.add(new Motorcycle(Colour.RED));
        stock.add(new Motorcycle(Colour.BLACK));
        stock.add(new Motorcycle(Colour.BLUE));
        for (Colour colour : Colour.values()) {
            stock.add(new Car(colour));
        }
        int countBlueMotorCycles = 0;
        for (Vehicle vehicle : stock) {
            if (vehicle instanceof Motorcycle) {
                if (vehicle.colour == Colour.BLUE) {
                    ++countBlueMotorCycles;
                }
            }
        }
        System.out.println(countBlueMotorCycles);

    }
}

abstract class Vehicle {
    protected Colour colour;

    public Vehicle(Colour colour) {
        this.colour = colour;
    }

    public abstract int numberOfWheels();

    @Override
    public String toString() {
        return " [colour=" + colour + "]";
    }

    
}

class Car extends Vehicle {
    public Car(Colour colour) {
        super(colour);
    }

    @Override
    public int numberOfWheels() {
        return 4;
    }

    @Override
    public String toString() {
        return "Car " + super.toString();
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(Colour colour) {
        super(colour);
    }

    @Override
    public int numberOfWheels() {
        return 2;
    }

    @Override
    public String toString() {
        return "Motorcycle " + super.toString();
    }
}

enum Colour {
    RED, BLUE, BLACK
}
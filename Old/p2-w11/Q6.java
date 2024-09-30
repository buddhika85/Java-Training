import java.util.ArrayList;
import java.util.List;

public class Q6 
{
    public static void main(String[] args) 
    {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Motorcycle(Colour.RED));
        vehicles.add(new Motorcycle(Colour.BLACK));
        vehicles.add(new Car(Colour.RED));
        vehicles.add(new Car(Colour.BLUE));
        vehicles.add(new Car(Colour.BLACK));
        int blueMotorCycleCount = 0;
        for (Vehicle vehicle : vehicles)
        {
            if (vehicle instanceof Motorcycle)
            {
                Motorcycle motorcycle = (Motorcycle) vehicle;
                if (motorcycle.colour == Colour.BLUE)
                {
                    ++blueMotorCycleCount;
                }
            }
        }
        System.out.println(blueMotorCycleCount);
    }
}

abstract class Vehicle {
    protected Colour colour;

    public Vehicle(Colour colour) {
        this.colour = colour;
    }

    public abstract int numberOfWheels();
}

class Car extends Vehicle {
    public Car(Colour colour) {
        super(colour);
    }

    @Override
    public int numberOfWheels() {
        return 4;
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
}

enum Colour {
    RED, BLUE, BLACK
}
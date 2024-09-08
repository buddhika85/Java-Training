public class RaceCar
{
    private double topSpeed;

    RaceCar(double topSpeed)
    {
        this.topSpeed = topSpeed;
    }

    double getTopSpeed()
    {
        return this.topSpeed;
    }
}

class Scorcher extends RaceCar
{
    private boolean boostActive;

    public Scorcher(double topSpeed) {
        super(topSpeed);
        this.boostActive = false;
    }

    void activateBoost()
    {
        this.boostActive = true;
    }

    @Override
    double getTopSpeed()
    {
        if (boostActive)
            return super.getTopSpeed() + 100;
        return super.getTopSpeed();
    }

    void testDrive()
    {
        System.out.println("Current top speed is " + getTopSpeed());
        System.out.println("Activate bost? (1 for yes, 2 for no)");
        if (In.nextInt() == 1)
        {
            activateBoost();
        }
        System.out.println("Top speed now is " + getTopSpeed());
    }
}

class Test
{
    public static void main(String[] args) {
        new Scorcher(100).testDrive();
    }
}
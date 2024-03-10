public class Poodle extends Dog
{
    private static final double GROWTH_RATE = 0.5;
    public static final double GROWTH_STOP_AGE = 12;

    public Poodle(double age, double weight, double length, String name) 
    {
        super(age, weight, length, name);
    }

    @Override
    public Features estimateFeatures(double futureAge) 
    {    
        double currentAge = getAge();
        if (futureAge < currentAge)
        {
            System.out.println("Error - it is not a future age, a past age, no estimates made");
            return null;
        }

        if (futureAge >= GROWTH_STOP_AGE)
        {
            System.out.println("Poodle is fully grown by this time");
            futureAge = GROWTH_STOP_AGE;
        }       

        Features features = new Features();
        features.weight = getWeight() + GROWTH_RATE * (futureAge - currentAge);
        features.length = getLength() + GROWTH_RATE * (futureAge - currentAge); 
        return features;
    }    
}

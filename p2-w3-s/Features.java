public class Features
{
    double weight, length;

    public Features(double weight, double length) {
        this.weight = weight;
        this.length = length;
    }

    @Override
    public String toString() {
        return "weight=" + weight + ", length=" + length;
    }
}

class Dog
{
    double age, weight, length;
    String name;
    

    public Dog(double age, double weight, double length, String name) {
        setFeatures(age, weight, length);
        this.name = name;
    }

    void setFeatures(double age, double weight, double length)
    {
        this.age = age;
        this.weight = weight;
        this.length = length;
    }

    //estimate the weight and length of the dog for the given future age.
    Features estimateFeatures(double futureAge)
    {
        // Now this is the parent class so we really can't give a meaningful estimate. As a hack we can simply return null
        return null;
    }

    int getAdultAge()
    {
        return 0;
    }
}

class Poodle extends Dog
{
    public Poodle(double age, double weight, double length) {
        super(age, weight, length, "Poodle");
    }

    final double GROWTH_RATE = .5;
    final int GROWTH_END_AGE = 12;

    @Override
    int getAdultAge() {
        return GROWTH_END_AGE;
    }

    @Override
    Features estimateFeatures(double futureAge)
    {
        if (futureAge < this.age)
        {
            System.out.println("Error - it is not a future age, cannot estimate");
            return null;
        }
        if (futureAge >= GROWTH_END_AGE)
        {
            System.out.println("Poodle is fully grown by this future age");
        }
        double estimatedWeight = this.weight 
            + GROWTH_RATE * (futureAge - this.age);
        double estimatedLength = this.length 
            + GROWTH_RATE * (futureAge - age);
        return new Features(estimatedWeight, estimatedLength);
    }

}

class Husky extends Dog
{
    public Husky(double age, double weight, double length, String name) {
        super(age, weight, length, "Husky");
    }

    final double GROWTH_RATE = .8;
    final int GROWTH_END_AGE = 18;

    @Override
    int getAdultAge() {
       return GROWTH_END_AGE;
    }

    @Override
    Features estimateFeatures(double futureAge)
    {
        if (futureAge < this.age)
        {
            System.out.println("Error - it is not a future age, cannot estimate");
            return null;
        }

        double estimatedWeight = this.weight;
        double estimatedLength = this.length;
        if (futureAge >= GROWTH_END_AGE)
        {
            System.out.println("Husky is fully grown by this future age");        
        }
        else
        {
            estimatedWeight = this.weight 
                + GROWTH_RATE * (futureAge - this.age);
            estimatedLength = this.length 
                + GROWTH_RATE * (futureAge - age);
        }
        return new Features(estimatedWeight, estimatedLength);
    }

}
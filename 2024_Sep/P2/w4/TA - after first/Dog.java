class Features 
{
    public double weight, length;

    public Features(double weight, double length) 
    {
        this.weight = weight;
        this.length = length;
    }

    @Override
    public String toString() 
    {
        return "weight=" + weight + ", length=" + length;
    }    
}


public class Dog 
{
    protected double age;
    protected double weight;
    protected double length;
    protected String name;

    public Dog(double age, double weight, double length, String name) 
    {
        setFeatures(age, weight, length);
        this.name = name;
    }

    public void setFeatures(double age, double weight, double length)
    {
        this.age = age;
        this.weight = weight;
        this.length = length;
    }

    public Features estimateFeatures(double futureAge)
    {
        return null;
    }

    public int getAdultAge()
    {
        return 0;
    }

    @Override
    public String toString() 
    {
        return "Dog [age=" + age + ", weight=" + weight + ", length=" + length + ", name=" + name + "]";
    }
}

class Poodle extends Dog
{
    private static double GROWTH_RATE = 0.5;
    private static int GROWTH_END_AGE = 12;


    public Poodle(double age, double weight, double length, String name) 
    {
        super(age, weight, length, "Poodle " + name);
    }

    @Override
    public int getAdultAge()
    {
        return GROWTH_END_AGE;
    }

    @Override
    public Features estimateFeatures(double futureAge)
    {            
        if (age >= GROWTH_END_AGE)
        {
            System.out.println(name + " is already fully grown !");
            return new Features(weight, length);
        }

        if (futureAge < age)
        {
            System.out.println("Error : Invalid future age");
            return null;
        } 

        // apply formula for feature predition as futureAge > age && age < GROWTH_END_AGE
        double predicatedWeight = this.weight + GROWTH_RATE * (futureAge - this.age);
        double predicatedLength = this.length + GROWTH_RATE * (futureAge - age);
        return  new Features(predicatedWeight, predicatedLength);
    }

    @Override
    public String toString() 
    {
        return "Poodle " + super.toString();
    }
}

class Husky extends Dog
{
    private static double GROWTH_RATE = 0.8;
    private static int GROWTH_END_AGE = 18;

    public Husky(double age, double weight, double length, String name) 
    {
        super(age, weight, length, "Husky " + name);
    }

    @Override
    public int getAdultAge()
    {
        return GROWTH_END_AGE;
    }

    @Override
    public Features estimateFeatures(double futureAge)
    {
        if (age >= GROWTH_END_AGE)
        {
            System.out.println(name + " is already fully grown !");
            return new Features(weight, length);
        }

        if (futureAge < age)
        {
            System.out.println("Error : Invalid future age");
            return null;
        } 

        // apply formula for feature predition as futureAge > age && age < GROWTH_END_AGE
        double predicatedWeight = this.weight + GROWTH_RATE * (futureAge - this.age);
        double predicatedLength = this.length + GROWTH_RATE * (futureAge - age);
        return  new Features(predicatedWeight, predicatedLength);
    }

    @Override
    public String toString() 
    {
        return "Husky " + super.toString();
    }
}
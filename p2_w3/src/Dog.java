public abstract class Dog 
{
    private double age; //(in months)
    private double weight;  // (in kg)
    private double length;  //(in cm).
    private String name;

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

    // purpose of this method is to estimate the weight and length of the dog for the given future age.
    public abstract Features estimateFeatures(double futureAge);

    public void setName(String name)
    {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public double getLength() {
        return length;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() 
    {
        return "Dog [name=" + name + " age=" + age + ", weight=" + weight + ", length=" + length + "]";
    }


}

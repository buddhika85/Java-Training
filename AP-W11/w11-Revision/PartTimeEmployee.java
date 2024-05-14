// child class 2
public class PartTimeEmployee extends Employee
{
    private double numOfHours;
    private double hourlyRate;

    public PartTimeEmployee(String name, double numOfHours, double hourlyRate)
    {
        super(name);
        this.numOfHours = numOfHours;
        this.hourlyRate = hourlyRate;
    }
    
    @Override
    public double calculateSalary()
    {
        return numOfHours * hourlyRate;
    }

    @Override
    public String toString()
    {
        return super.toString() + " hourly Rate: " + hourlyRate + " numOfHours: " + numOfHours;
    }
}
// Write a parent class and a child class to show implementation inheritance
public abstract class Employee
{
    protected String name;

    public Employee(String name)
    {
        this.name = name;
    }
    
    public abstract double calculateSalary();

    @Override
    public String toString()
    {
        return name + " current salary: " + calculateSalary();
    }
}
import java.util.LinkedList;

public class Employees
{
    private LinkedList<Employee> employees = new LinkedList<Employee>();
    
    public void add(Employee employee)
    {
        employees.add(employee);
    }
    
    public void displayAll()
    {
        for(Employee employee : employees)
        {
            System.out.println(employee);       // polymorphic
        }
    }
}

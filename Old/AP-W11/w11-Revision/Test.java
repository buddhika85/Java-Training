public class Test
{
    public Test()
    {
        Employees employees = new Employees();
        
        employees.add(new PartTimeEmployee("Jack",  20, 10));
        employees.add(new FullTimeEmployee("Gill",  60000));
        
        employees.displayAll();
    }
}

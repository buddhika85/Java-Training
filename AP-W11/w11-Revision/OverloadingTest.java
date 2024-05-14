
public class OverloadingTest
{
    public void m()         // m()
    {
        // ...
    }
    
    public void m(int x)        // m(int )
    {
        // ...
    }
    
    public void m(int age, double x)      // m(int, double)
    {
        // ...
    }
    
    public void m(double x, int y)      // m(double, int)
    {
        // ...
    }
}

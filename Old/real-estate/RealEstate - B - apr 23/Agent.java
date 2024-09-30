public class Agent extends Record
{
    private String name;
    
    public Agent(int id, String name)
    {
        super(id);
        this.name = name;
    }
    
    @Override 
    public String toString()
    {
        return super.toString() + " " + name;
    }
}
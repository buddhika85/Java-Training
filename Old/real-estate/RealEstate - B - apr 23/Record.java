public class Record
{
    protected int id;
    
    protected Record(int id)
    {
        this.id = id;       
    }

    public boolean matches(int id)
    {
        return this.id == id;
    } 
    
    public void show()
    {  
        System.out.println(toString());   
    } 

    @Override
    public String toString()
    {   
        return id + "";
    }
}
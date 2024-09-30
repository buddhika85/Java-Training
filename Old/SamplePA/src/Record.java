public abstract class Record
{
    protected int id;
    protected String name;
    
    protected Record(int id, String name)
    {
        this.id = id;     
        setName(name);
    }

    public int getId()
    {
        return id;
    }
    
    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public boolean matches(int id)
    {
        return this.id == id;
    } 

    // overload
    public boolean matches(String name)
    {
        return this.name.equalsIgnoreCase(name);
    }
    
    public void show()
    {  
        System.out.println(toString());   
    }

    @Override
    public String toString() 
    {
        return "id=" + id + ", name=" + name;
    }   
}
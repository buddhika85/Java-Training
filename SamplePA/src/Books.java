public class Books extends Records
{
    @Override
    public Book find(int id)
    {
        return (Book)super.find(id);
    }

    @Override
    public Book find(String name)
    {
        return (Book)super.find(name);
    }

    @Override
    public String toString() 
    {
        return "Books\n" + super.toString();
    }    
}
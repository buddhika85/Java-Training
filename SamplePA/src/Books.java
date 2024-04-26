public class Books extends Records
{
    @Override
    public Book find(int id)
    {
        return (Book)super.find(id);
    }

    public void add(String name, String author)
    {
        add(new Book(++id, name, author));
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
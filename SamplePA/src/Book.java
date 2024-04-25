public class Book extends Record
{
    private String author;
    private BookStatus status = BookStatus.AVAILABLE;
    private int borrowalCount;

    protected Book(int id, String name, String author) 
    {
        super(id, name);  
        this.author = author;
        setAuthor(author);              
    }

    public String getAuthor() 
    {
        return author;
    }

    public void setAuthor(String author) 
    {
        this.author = author;
    }

    public boolean isAvailable() 
    {
        return status == BookStatus.AVAILABLE;
    }

    public void borrow() throws Exception 
    {
        if (!isAvailable())
            throw new Exception(this + " is already borrowed");

        ++borrowalCount;
        status = BookStatus.BORROWED;
    }

    public void returnBook() throws Exception
    {
        if (isAvailable())
            throw new Exception(this + " is already returned");

        status = BookStatus.AVAILABLE;
    }

    @Override
    public String toString() 
    {
        return "Book [" + super.toString() + " author=" + author + ", status=" + status + ", borrowal count: " + borrowalCount + "]";
    } 
}
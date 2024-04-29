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

    public void borrow()
    {
        ++borrowalCount;
        status = BookStatus.BORROWED;
    }

    public void returnBook() 
    {
        status = BookStatus.AVAILABLE;
    }

    public BookStatus getStatus() 
    {
        return status;
    }
    
    public int getBorrowalCount() {
        return borrowalCount;
    }

    @Override
    public String toString() 
    {
        return "Book [" + super.toString() + " author=" + author + ", status=" + status + ", borrowal count: " + borrowalCount + "]";
    } 
}
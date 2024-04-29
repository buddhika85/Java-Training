import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Books extends Records
{
    public static final Comparator<Book> POPULARITY_RANKING_COMPARATOR = 
        Comparator.comparing(Book::getBorrowalCount).reversed();        // most popular first

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

    public List<Book> findByAuthor(String author) 
    {
        List<Book> booksByAuthor = new LinkedList<>();
        for (Record record : records) {
            Book book = (Book) record;
            if (book.getAuthor().equalsIgnoreCase(author))
                booksByAuthor.add(book);
        }
        return booksByAuthor;
    }

    public List<Book> findByStatus(BookStatus status) 
    {
        List<Book> booksByStatus = new ArrayList<>();
        for (Record record : records) {
            Book book = (Book) record;
            if (book.getStatus() == status)
                booksByStatus.add(book);
        }
        return booksByStatus;
    }   
    
    // sort books by borrowal count
    public List<Book> popularBookList()
    {
        ArrayList<Book> booksCopy = new ArrayList<>(getBooksList());
        Collections.sort(booksCopy, POPULARITY_RANKING_COMPARATOR);
        return booksCopy;
    }

    private List<Book> getBooksList()
    {
        List<Book> books = new ArrayList<>();
        for (Record record : records) {
            books.add((Book)record);
        }
        return books;
    }
}
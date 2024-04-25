public class LibrarySystem 
{
    // group class objects
    private Books books = new Books();
    private Members members = new Members();

    public LibrarySystem() 
    {
        populateTestData();
    }

    private void populateTestData() 
    {
        books.add(new Book(0, null, null));
    }
}

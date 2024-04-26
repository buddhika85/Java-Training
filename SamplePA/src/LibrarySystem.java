public class LibrarySystem implements IMenu
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
        books.add("Guliver Travels", "Jonathan Swift");
        books.add("Jungle Book", "Jonathan Swift");
        members.add("James Gun", "james@gmail.com");
        members.add("John Smith", "john@gmail.com");

        System.out.println(books);
        System.out.println(members);
    }


}

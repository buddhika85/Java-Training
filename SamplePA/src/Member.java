public class Member extends Record 
{
    private String email;
    private Books borrowedBooks = new Books();

    protected Member(int id, String name, String email) 
    {
        super(id, name);
        setEmail(email);
    }    
    
    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public void borrowBook(Book book) throws Exception
    {
        if (!book.isAvailable())
            throw new Exception(book + " is already borrowed");

        borrowedBooks.add(book);
        book.borrow();
    }

    @Override
    public String toString() 
    {
        return "Member [" + super.toString() + " email=" + email + "]\n\tborrowedBooks=" + borrowedBooks;
    }
}

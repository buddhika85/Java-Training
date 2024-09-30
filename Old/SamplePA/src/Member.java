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

    public void borrowBook(Book book)
    {
        borrowedBooks.add(book);
        book.borrow();
    }

    public void returnBook(Book book)
    {
        borrowedBooks.remove(book);
        book.returnBook();
    }

    @Override
    public String toString() 
    {
        return "Member [" + super.toString() + " email=" + email + "]\n\tborrowedBooks=" + borrowedBooks;
    }
}

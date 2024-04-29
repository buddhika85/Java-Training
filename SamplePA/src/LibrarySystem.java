import java.util.List;

public class LibrarySystem implements IMenu
{
    // group class objects
    private Books books = new Books();
    private Members members = new Members();

    public LibrarySystem() 
    {
        populateTestData();
        runMainMenu();
    }

    private void runMainMenu() 
    {
        System.out.println("--- Welcome to Library System ---");
        while (true) 
        {
            displayMainMenu();
            int choice = In.nextInt();
            if (choice == 1) 
            {
                addMember();
            } 
            else if (choice == 2) 
            {
                addBook();
            } 
            else if (choice == 3) 
            {
                searchForMember();
            } 
            else if (choice == 4) 
            {
                searchForBooks();
            } 
            else if (choice == 5) 
            {
                removeMember();
            }
            else if (choice == 6) 
            {
                removeBook();
            }
            else if (choice == 7) 
            {
                borrowBook();
            }
            else if (choice == 8) 
            {
                returnBook();
            }
            else if (choice == 9) 
            {
                displayAvailableBooks();
            }
            else if (choice == 10) 
            {
                displayBooksByPopularity();
            }
            else if (choice == 11) 
            {
                displayMemebersInAsc();
            }
            else if (choice == 12) 
            {
                displayMembersInDsc();
            }
            else if (choice == 13) 
            {
                displayFullReport();
            } 
            else if (choice == 14) 
            {
                break;
            } 
            else 
            {
                System.out.println("Pick an option 1, 2, .. 14");
            }
        }

        System.out.println("Exiting...");
    }

    private void displayMainMenu() 
    {
        System.out.println("\nSelect an option:");
        System.out.println("  1. Add Member");
        System.out.println("  2. Add Book");
        System.out.println("  3. Search for Member");
        System.out.println("  4. Search for Books by author");
        System.out.println("  5. Remove a Member");
        System.out.println("  6. Remove a Book");
        System.out.println("  7. Borrow a Book");
        System.out.println("  8. Return a Book");    

        System.out.println("  9. Display available Books");
        System.out.println("  10. Display Books by popularity");
        System.out.println("  11. Display Members by Name - ASC");
        System.out.println("  12. Display Members by Name - DSC");
        System.out.println("  13. Display Full Report");
        System.out.println("  14. Exit");
    }

    
    @Override
    public void addMember() 
    {
        displayHeading("Add Member");
        String name = readString("Name?");
        String email = readString("Email?");
        members.add(name, email);
        displaySuccessMessage("Member Added");
    }    

    @Override
    public void addBook() 
    {
        displayHeading("Add Book");
        String name = readString("Name?");
        String author = readString("Author?");
        books.add(name, author);
        displaySuccessMessage("Book Added");
    }

    @Override
    public void searchForMember() 
    {
        displayHeading("Search for a Member By Name");       
        Member member = members.find(readString("Member Name?"));
        if (member == null)
            System.out.println("hmm -- member with such name does not exist in our records");
        else
            System.out.println("Member found.\n\t" + member + "\n");
    }

    @Override
    public void searchForBooks() 
    {
        displayHeading("Search Books by author");
        String author = readString("Author Name?");
        List<Book> booksAbyAuthor = books.findByAuthor(author);
        if (booksAbyAuthor.isEmpty())
            System.out.println("\nNo books from such author");
        else
        {
            System.out.println("Books of author - " + author);
            for (Book book : booksAbyAuthor) {
                System.out.println(book);
            }
        }
        System.out.println("\n");
    }

    @Override
    public void removeMember() 
    {
        displayHeading("Remove Member");
        String name = readString("Name?");
        Member member = members.find(name);
        if (member == null)
        {
            System.out.println("hmm -- member with such name does not exist in our records");
            return;
        }

        members.remove(member);
        displaySuccessMessage("Member removed - " + name);
    }

    @Override
    public void removeBook() 
    {
        displayHeading("Remove Book");
        String name = readString("Name?");
        Book book = books.find(name);
        if (book == null)
        {
            System.out.println("hmm -- book with such name does not exist in our records");
            return;
        }

        books.remove(book);
        displaySuccessMessage("Book removed - " + name);
    }

    @Override
    public void borrowBook() 
    {
        displayHeading("Borrow Book");
        String memberName = readString("Member Name?");
        Member member = members.find(memberName);
        if (member == null)
        {
            System.out.println("hmm -- member with such name does not exist in our records");
            return;
        }
        
        System.out.println("Member found.\n\t" + member + "\n");
        String bookName = readString("Book Name (to borrow)?");
        Book book = books.find(bookName);
        if (book == null)
        {
            System.out.println("hmm -- book with such name does not exist in our records");
            return;
        }
        if (!book.isAvailable())   
        {
            System.out.println("hmm -- book " + bookName + " is borrowed, please retry later");
            return;
        } 

        // borrow
        member.borrowBook(book);
        displaySuccessMessage(memberName + " borrowed book : " + bookName);
    }

    @Override
    public void returnBook() 
    {
        displayHeading("Return Book");
        String memberName = readString("Member Name?");
        Member member = members.find(memberName);
        if (member == null)
        {
            System.out.println("hmm -- member with such name does not exist in our records");
            return;
        }
        
        System.out.println("Member found.\n\t" + member + "\n");
        String bookName = readString("Book Name (to return)?");
        Book book = books.find(bookName);
        if (book == null)
        {
            System.out.println("hmm -- book with such name does not exist in our records");
            return;
        }
        if (book.isAvailable())   
        {
            System.out.println("hmm -- book " + bookName + " is not borrowed by this member");
            return;
        } 

        // borrow
        member.returnBook(book);
        displaySuccessMessage(memberName + " returned book : " + bookName);
    }

    @Override
    public void displayAvailableBooks() 
    {
        displayHeading("Display all available Book");
        List<Book> availableBooks = books.findByStatus(BookStatus.AVAILABLE);
        if (availableBooks.isEmpty())
            System.out.println("\nCurrently all books are Borrow");
        else
        {
            System.out.println("Available books");
            for (Book book : availableBooks) {
                System.out.println(book);
            }
        }
        System.out.println("\n");
    }

    @Override
    public void displayBooksByPopularity() 
    {
        displayHeading("Display Book by popularity");
        List<Book> bookByPopularity = books.popularBookList();
        for (int index = 0; index < bookByPopularity.size(); index++) 
        {
            Book book = bookByPopularity.get(index);
            System.out.println("Rank " + (index + 1) + " ID " + book.getId() + " " + book.getName() 
                + " by " + book.getAuthor() + 
                " borrowed " + book.getBorrowalCount() + " times");
        }
        System.out.println("\n");
    }

    @Override
    public void displayMemebersInAsc() 
    {
        displayHeading("Display members in ASC");
    }

    @Override
    public void displayMembersInDsc() {
        displayHeading("Display members in DSC");
    }

    
    @Override
    public void displayFullReport() 
    {
        displayHeading("Complete Report");        
        System.out.println(books);
        System.out.println(members);
        displayFooter("End of Report");
    }    

    private void populateTestData() 
    {
        books.add("Guliver Travels", "Jonathan Swift");
        books.add("Five on a Treasure Island", "Enid Blyton");
        books.add("Jungle Book", "Rudyard Kipling");
        books.add("If", "Rudyard Kipling");
        books.add("The Enchanted Wood", "Enid Blyton");
        books.add("Kim", "Rudyard Kipling");
        books.add("Kipling's Poems", "Rudyard Kipling");
        books.add("Brer Rabbit Book", "Enid Blyton");
        books.add("The white mans burden", "Rudyard Kipling");

        members.add("James Gun", "james@gmail.com");
        members.add("John Smith", "john@gmail.com");
        members.add("Lorgan", "wolverine@gmail.com");
        members.add("Scott Summers", "scott@gmail.com");
        members.add("Jean Grey", "jean@gmail.com");
        members.add("Charls Xvier", "proffX@gmail.com");
        members.add("Magnus", "magnito@gmail.com");

        members.find(1).borrowBook(books.find(1));
        members.find(1).returnBook(books.find(1));

        members.find(1).borrowBook(books.find(2));
        members.find(1).returnBook(books.find(2));

        members.find(2).borrowBook(books.find(1));
        members.find(2).returnBook(books.find(1));

        members.find(3).borrowBook(books.find(3));
        members.find(3).returnBook(books.find(3));

        members.find(4).borrowBook(books.find(6));
        members.find(5).borrowBook(books.find(7));
        members.find(6).borrowBook(books.find(8));
        members.find(7).borrowBook(books.find(9));

        System.out.println(books);
        System.out.println(members);
    }

    private String readString(String question) 
    {
        System.out.print(question + "\t");
        return In.nextLine();
    }

    private void displaySuccessMessage(String message) 
    {
        System.out.println("Success - " + message + "\n");
    }

    private void displayHeading(String heading) 
    {
        System.out.println("---------" + heading + "---------");
    }

    private void displayFooter(String footer) 
    {
        System.out.println("---------" + footer + "---------");
    }
}

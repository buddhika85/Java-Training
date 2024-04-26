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
        System.out.println("--- Main menu ---");
        while (true) {
            System.out.println("Select an option:");
            System.out.println("  1. Add Member");
            System.out.println("  2. Add Book");
            System.out.println("  1. Add Member");
            System.out.println("  2. Add Book");
            System.out.println("  3. Exit");
            int choice = In.nextInt();
            if (choice == 1) {
                
            } else if (choice == 2) {
               
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Pick an option 1, 2, or 3");
            }
        }

        System.out.println("Exiting...");
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

    @Override
    public void addMember() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addMember'");
    }

    @Override
    public void addBook() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addBook'");
    }

    @Override
    public void searchForMember() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchForMember'");
    }

    @Override
    public void searchForBook() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchForBook'");
    }

    @Override
    public void removeMember() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeMember'");
    }

    @Override
    public void removeBook() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeBook'");
    }

    @Override
    public void borrowBook() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrowBook'");
    }

    @Override
    public void returnBook() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'returnBook'");
    }

    @Override
    public void displayBooksByGenre() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayBooksByGenre'");
    }

    @Override
    public void displayAvailableBooks() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayAvailableBooks'");
    }

    @Override
    public void displayBooksByPopularity() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayBooksByPopularity'");
    }

    @Override
    public void displayMemebersInAsc() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayMemebersInAsc'");
    }

    @Override
    public void displayMembersInDsc() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayMembersInDsc'");
    }


}

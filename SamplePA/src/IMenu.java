public interface IMenu 
{
    // add
    void addMember();
    void addBook();

    // retireve an object
    void searchForMember();
    void searchForBooks();

    // remove
    void removeMember();
    void removeBook();

    // edit
    void borrowBook();
    void returnBook();

    // generate a sub list
    // void displayBooksByGenre();         
    void displayAvailableBooks();    
    
    // sorting
    void displayBooksByPopularity();
    void displayMemebersInAsc();
    void displayMembersInDsc();

    // full report
    void displayFullReport();
}

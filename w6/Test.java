package w6;

import java.util.LinkedList;

public class Test {  

    public static void main(String[] args) {
        //new GladiatorPrimeTest().rent(); 

        // Customers customers = new Customers();
        // customers.add();
        // customers.show();

        new GladiatorPrime();
    }  
}


class GladiatorPrimeTest
{
    private LinkedList<StreamedMovie> movies = new LinkedList<StreamedMovie>();
    private Customer customer; 

    GladiatorPrimeTest() {
        customer = new Customer(1, "Jack");
        movies.add(new StreamedMovie(1, "Harry Potter 1", 100.0, 7, Status.FOR_RENT));
        movies.add(new StreamedMovie(1, "Jurrasic Park", 90.0, 7, Status.UNAVAILABLE));
    }

    public void rent()
    {
        for (StreamedMovie streamedMovie : movies) {
            rentMovie(streamedMovie);
        }
    }

    private void rentMovie(StreamedMovie movie)
    {
        customer.rent(movie);
    }
}
package w6;

import java.util.LinkedList;

public class Customer extends Record {

    private double balance = 100.0;
    private LinkedList<StreamedMovie> movies = new LinkedList<StreamedMovie>();

    public Customer(int id, String name) {
        super(id, name);
    }

    public void rent(StreamedMovie movie) {
        if (movie.rent()) {
            movies.add(movie);
            balance -= movie.getPrice();
        }
    }

    public String toString() {
        String str = super.toString() + " has ";
        for (StreamedMovie sm : movies)
            str += sm.toString() + ", ";
        if (movies.size() == 0)
            str += " none ";
        return str;
    }

    public double getBalance() {
        return balance;
    }

}
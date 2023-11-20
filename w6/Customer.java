package w6;

import java.util.LinkedList;

public class Customer {
    private int id;
    private String name;
    private double balance = 100.0;
    private LinkedList<StreamedMovie> movies = new LinkedList<StreamedMovie>();

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void rent(StreamedMovie movie) {
        if (movie.rent()) {
            movies.add(movie);
            balance -= movie.getPrice();
        }
    }

    public void show() {
        System.out.println(toString());
    }

    public String toString() {
        String str = id + "  " + name + " has ";
        for (StreamedMovie sm : movies)
            str += sm.toString() + ", ";
        if (movies.size() == 0)
            str += " none ";
        return str;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public boolean matches(int id) {
        return this.id == id;
    }
}
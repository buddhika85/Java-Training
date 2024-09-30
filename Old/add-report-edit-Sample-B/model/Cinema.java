package model;

import java.util.*;
/**
 * class Cinema 
 */
public class Cinema extends Updater
{
    private final String NAME = "MyCinema";
    protected double balance = 100000.00;    
    protected double profit = 0.0;
    private Movies movies = new Movies();
    private Theatres theatres = new Theatres();
    private Sessions sessions = new Sessions();

    public Movies getMovies()
    {
        return movies;
    }
    
    private double income()
    {
        return sessions.income();
    }

    private double cost()
    {
        return sessions.cost();
    }

    private void profit()
    { 
        profit = income() - cost();
        updateViews();
    }

    private double balance()
    { 
        return balance + profit;
    }         

    @Override
    public String toString()
    {   
        String s = "Cinema:";
        s += " cost = $" + cost();
        s += " income = $" + income();
        s += " profit = $" + profit;
        s+= " balance = $" + balance();
        return s;   
    }
}
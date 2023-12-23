package model;

import java.util.*;
/**
 * class Session 
 */
public class Session extends Record
{
    private Movie movie;
    private double profit = 0.0;
    private Theatre theatre;
    private LinkedList<Seat> seats = new LinkedList<Seat>();

    public Session(int id, String name, Movie movie, Theatre theatre)
    {
        super(id, name);
        this.movie = movie; 
        this.theatre = theatre;
        seats.add(new Seat("Gold Class", theatre.goldSeats()));
        seats.add(new Seat("Regular", theatre.regularSeats()));   
    }

    public LinkedList<Seat> getSeats()
    {   
        return seats;   
    }

    public int groups()
    {   
        return seats.size();   
    }

    public Movie getMovie()
    {
        return movie;
    }

    public Theatre getTheatre()
    {
        return theatre;
    }

    public double cost()
    {
        return movie.getCost();
    }

    public void profit()
    {
        profit = income() - cost();
    }

    public void sellTickets(int gold, int regular)
    {  
        int sold[] = {gold, regular};
        sellSeats(sold);
    }

    public double income()
    {   
        double income = 0;
        for(Seat seat : seats)
            income += seat.income();
        return income;  
    }

    public void setPrices(double[] prices)
    {
        int i = 0;
        for(Seat seat : seats)
        {
            seat.setPrice(prices[i++]);
        }
    }

    public void sellSeats(int[] sold)
    {
        int i = 0;
        for(Seat seat : seats)
        {
            seat.sell(sold[i++]);
        }
        profit();
    }

    @Override
    public String toString()
    {   String str = "Session: " + super.toString();
        str += " cost = $" + cost();
        str += " income = $" + income();
        str += " profit = $" + profit;
        return str;   
    }

}
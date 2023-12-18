package model;
import java.util.*;
public class Stadium extends Updater
{   
    private LinkedList<Seat> seats = new LinkedList<Seat>();
    private double rent;
    public Stadium()
    {   
        seats.add(new Seat("Front", 200));
        seats.add(new Seat("Back", 400));    
    }     
    public LinkedList<Seat> seats()
    {   
        return seats;   
    }
    public int groups()
    {   
        return seats.size();   
    }
    public double income()
    {   
        double income = 0;
        Iterator<Seat> it = seats.iterator();
        while (it.hasNext())
            income += it.next().income();
        return income;  
    }
    public double rent()
    {
        return rent;
    }
    public void setRent(double rent)
    {
        this.rent = rent;
        updateViews();
    }
    public void setPrices(double[] prices)
    {
        Iterator<Seat> it = seats.iterator();
        int i = 0;
        while (it.hasNext())
        {
            it.next().setPrice(prices[i]);
            i++;
        }
        updateViews();
    }
}

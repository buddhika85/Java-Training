package model;
import java.util.*;
public class Concert extends Updater
{
    private Band band;
    private Stadium stadium;
    public Concert(Band band, Stadium stadium)
    {
        this.band = band; 
        this.stadium = stadium;
    }
    public Band band()
    {
        return band;
    }
    public Stadium stadium()
    {
        return stadium;
    }
    public String income()
    {
        return Double.toString(stadium.income());
    }
    public String cost()
    {
        double rentCost = stadium.rent();
        double bandCost = band.cost();
        double totalCost = rentCost + bandCost;
        return Double.toString(totalCost);
    }
    public String profit()
    {
        double income = stadium.income();
        double profit = income - Double.parseDouble(cost());
        return Double.toString(profit);
    }
}
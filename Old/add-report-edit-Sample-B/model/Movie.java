package model;

import java.util.*;
/**
 * class Movie - complete
 */
public class Movie extends Record
{   
    private double cost;
    public Movie(int id, String name, double cost)
    {
        super(id, name);
        this.cost = cost;  
    }
    public double getCost()
    {
        return cost;
    }

    public void set(String name, double cost)
    {
        this.cost = cost;
        this.name = name;
        updateViews(AddOrEdit.EDIT);
    }

    public void setCost(double cost)
    {
        this.cost = cost;
        updateViews(AddOrEdit.EDIT);
    }

    public void setName(String name)
    {
        this.name = name;
        updateViews(AddOrEdit.EDIT);
    }

    public String toString()
    {
        return "Movie: "+ super.toString() + " cost: $"+ cost;
    }
}

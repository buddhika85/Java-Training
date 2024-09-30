package model;

import java.util.*;
/**
 * class Seat
 */
public class Seat
{   
    private String name;
    private int number;
    private double price;
    private int sold = 0;
    
    public Seat(String name, int number)
    {   
        this.name = name;
        this.number = number;   
    }      
    public void setPrice(double price)
    {   
        this.price = price;
        show();
    }    
    public void sell(int number)
    {  
        if (left() >= number)
        {
            sold += number;
            show();
        }
        else
            System.out.println("Not enough seats available in " + name + ", sale aborted");
    }    
    
    public int left()
    {   
        return number - sold;   
    }
    public double income()
    {  
        return sold * price;    
    } 
    public void show()
    {   
        System.out.println(toString()); 
    }                
    public String toString()
    {   String s = name + " seats:";
        s += " n = " + number;
        s += " price = $" + price;
        s += " sold = " + sold;
        return s;   
    }
}

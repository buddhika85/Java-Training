package model;
import java.util.*;
public class Seat extends Updater
{   
    private String name;
    private int forSale;
    private double price;
    private int sold = 0;
    public Seat(String name, int forSale)
    {   
        this.name = name;
        this.forSale = forSale;   
    }      
    public String name()
    {   
        return name;   
    }
    public void setPrice(double price)
    {   
        this.price = price;
        show();
        updateViews();
    }    
    public int sold()
    {   
        return sold;    
    }
    public void sell(int number)
    {  
        sold += number;
        show();
        updateViews();
    }    
    public int left()
    {   
        return forSale - sold;   
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
        s += " n = " + forSale;
        s += " price = $" + price;
        s += " sold = " + sold;
        return s;   
    }
}

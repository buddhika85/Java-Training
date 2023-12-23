package model;

import java.util.*;
/**
 * class Theatres 
 */
public class Theatres extends Records
{
    public void add(String name, int goldClass, int regularClass)
    {   
        System.out.println("Add a Theatre");
        Theatre theatre = new Theatre(++id, name, goldClass, regularClass);
        add(theatre);
    }

    public Theatre find(int id)
    {   
        return (Theatre) super.find(id);   
    }
}
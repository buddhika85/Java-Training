package model;
import java.util.*;
public class Updater 
{   
    private LinkedList<MyObserver> views = new LinkedList<MyObserver>();
    public void attach(MyObserver o)
    {   
        views.add(o);   
    }  
    public void detach(MyObserver o)
    {   
        views.remove(o);    
    }                
    public void updateViews()
    {   
        for(MyObserver observer : views)
            observer.update(); 
    }
}

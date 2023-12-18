package model;

public class Band extends Updater
{   
	private String name;
    private double cost;

    public void setup(String name, double cost)
    {   
        this.name = name;
        this.cost = cost; 
        updateViews();
    }
    public double cost()
    {
        return cost;
    }
}

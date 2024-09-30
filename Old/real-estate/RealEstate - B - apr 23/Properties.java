public abstract class Properties extends Records // I dont want other classes to make objects of this
{    
    // income for all properties
    public double calcIncome()
    {
        double income = 0.0;
        for(Record record : records)
        {
            income += ((Property) record).income();            
        }
        return income;
    }  
}